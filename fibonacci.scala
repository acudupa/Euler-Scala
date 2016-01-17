//Here #:: operator is similiar to :: for List
// This basically means that There is a stream of Integers that is lazy loaded
// Its head is 0 and tail is defined by intStream.scanLeft(1)(_ + _)
// That inturns means that start with 1 and then add 0 and 1 and so on
lazy val intStream: Stream[Int] = 0 #:: intStream.scanLeft(1)(_ + _)

//View produces a lazy collection, so that calls to e.g. filter do not evaluate every element of the collection. 
//Elements are only evaluated once they are explicitly accessed. 
//Now sum does access all elements, but with view the call to filter doesn't create a full Vector
val r = intStream.view.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum

//As opposed to, where entire stream is first formed and then filter is applied
//val r = intStream.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum

/**
*
* A good example of the use of view would be:
*
* scala> (1 to 1000000000).filter(_ % 2 == 0).take(10).toList
* java.lang.OutOfMemoryError: GC overhead limit exceeded
* Here Scala tries to create a collection with 500000000 elements to then access the first 10. But with view:
*
* scala> (1 to 1000000000).view.filter(_ % 2 == 0).take(10).toList
* res2: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
*
*/

/**
* scala> val s = "abba.aadd" 
* s: String = abba.aadd
* scala> val (beforeDot,afterDot) = (s takeWhile (_!='.'), s dropWhile (_!='.'))
* beforeDot: String = abba
* afterDot: String = .aadd
*
* scala> val (beforeDot, afterDot) = s.span{ _ != '.' }
* beforeDot: String = abba
* afterDot: String = .aadd
* 
*/

assert(r == 4613732) // 1 ms
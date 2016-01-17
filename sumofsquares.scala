import scala.language.postfixOps

val reqNumbers = (1 to 100)
def square(n: Int) = n * n

val sumOfsq = (reqNumbers map ( square(_))).sum
val sqOfSum = square( reqNumbers sum )
val finalDiff = sqOfSum - sumOfsq
assert (finalDiff == 25164150)
val sumArr = for(a <- 1 until 1000; if ((a%3==0) || (a%5==0))) yield a
assert(sumArr.sum == 233168)


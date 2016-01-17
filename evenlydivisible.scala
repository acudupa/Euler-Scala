val num = Range(20, Int.MaxValue).view //We can safely assume number is > 20, until maxumum value of Int
		.find(n => Range(11,20).forall(n % _ == 0)) // Find a number such that it is divisible by all numbers in Range 11 to 20
		.get
assert(num == 232792560)
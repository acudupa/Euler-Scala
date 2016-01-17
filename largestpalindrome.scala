val r = (100 to 999).view //Since we need 3 digit numbers, get all numbers lazy collection
	.flatMap(i => (i to 999) map (j => j * i)) // For each i get all numbers from i to 999 i.e. j and calculate i*j
	.filter(n => n.toString == n.toString.reverse) // Filter only those that are palindrome
	.max //And get the maximum value

assert(r == 906609) 
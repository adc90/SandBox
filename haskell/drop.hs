-- file: ch02/drop.hs
myDrop n xs = if n <= 0 || null xs
	then xs
	else myDrop (n - 1) (tail xs)

isOdd n = n `mod` 2 == 1

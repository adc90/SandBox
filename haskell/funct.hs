multThree :: (Num a) => a -> a -> a -> a
multThree x y z = x * y * z

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys

largestDivisible :: (Integral a) => a
largestDivisible = head (filter p [100000,99999..])
	where p x = x `mod` 3829 == 0

chain :: (Integral a) => a -> [a]
chain 1 = [1]
chain n 
      | even n = n:chain (n `div` 2)
      | odd n  = n:chain (n * 3 + 1)

listOfFuns = map (*) [0..]

numLongChains :: Int
numLongChains = length (filter (\xs -> length xs > 15) (map chain[1..100]))

addThree :: (Num a) => a -> a -> a -> a
addThree x y z = x + y + z

sum' :: (Num a) => [a] -> a
sum' xs = foldl (\acc x -> acc + x) 0 xs


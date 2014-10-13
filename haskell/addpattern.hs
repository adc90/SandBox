-- Author: Aaron Clevenger
-- Description: Add up the numbers in a list using Haskell

sumList (x:xs) = x + sumList xs
	sumList [] = 0


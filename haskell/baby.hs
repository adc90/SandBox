-- Baby's first function

doubleMe x = x + x

doubleUs x y = doubleMe x + doubleMe y 

doubleSmallNumber x = if x > 100 then x else x*2

conanO'Brien = "It's a-me, Conan O'Brien!"

lostNumbers = [4,8,15,16,23,42]

listAdd = [1,2,3,4] ++ [9,10,11,12]

steve = "Steve Buscemi" !! 6

david = "David"

listHead = head david
listTail = tail david
listLast = last david
listInit = init david
listLeng = length david
listNull = null david
listRev  = reverse david
listTake = take 3 david
listDrop = drop 2 david

isMember = 4 `elem` [3,4,5,6,7]

texasRange = [1..400]
rangeStep  = [2,4..20]

takeRange = take 12 (cycle [1,2,3])
repRange  = take 10 (repeat 5)
sumRange = sum repRange

listComp1 = [x*2 | x <- [1..10]]
listComp2 = [x | x <- [50..100], x `mod` 7 == 3]

boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

-- x is 10-20 where x is not 13,15, or 19
multPred = [x | x <- [10..20], x /= 13, x /= 15, x /= 19]

-- (2 * 8), (2 * 10), (2 * 11), (5 * 8), (5 * 10), (5 * 11)...etc
listMult = [ x*y | x <- [2,5,10], y <- [8,10,11]]

length' xs = sum [1 | _ <- xs]

first = fst ("Wow", False)

zippy = zip [1,2,4,5,6] [5,5,5,5,5]

removeNonUppercase st = [c | c <- st, c `elem` ['A' .. 'Z']]

readVar = read "5" :: Int

lucky :: (Integral a) => a -> String
lucky 7 = "Lucky Number Seven!"
lucky x = "Sorry, you're out of luck, pal!"

factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n - 1)

addVectors :: (Num a) => (a, a) -> (a,a) -> (a,a)
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

firstElem :: (a, b, c) -> a
firstElem (x, _, _) = x

capital :: String -> String
capital "" = "Empty string, whoops!"
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height
    | bmi <= 18.5   = "You're underweight."
    | bmi <= 25.0   = "You're normal weight."
    | bmi <= 30.0   = "You're over weight."
    | otherwise = "You're obese."
    where bmi = weight / height ^ 2

cylinder :: (RealFloat a) => a -> a -> a
cylinder r h = 
    let sideArea = 2 * pi * r * h
        topArea = pi * r ^ 2
    in sideArea + 2 * topArea

-- describeList :: [a] -> String
-- describeList xs = "The list is " ++ case xs of [] -> "Empty."
--                                                [x] -> "A singleton list."
--                                                 xs -> "A longer list."
    
maximum' :: (Ord a) => [a] -> a
maximum' [] = error "Maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
    | x > maxTail = x
    | otherwise = maxTail
    where maxTail = maximum' xs

-- Use Num and Ord as class constraints because we 
-- are compairing numbers and performing arithmatic on them
replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x 
    | n <= 0 = []
    | otherwise = x:replicate' (n-1) x


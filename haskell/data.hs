-- file: ch03

data BookInfo = Book Int String [String]
	deriving (Show)

myInfo = Book 92239048 "Algebra of Programming" ["Richard Bird", "Oege de Moor"]

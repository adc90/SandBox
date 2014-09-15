-- Author: Aaron Clevenger
data BookInfo - Book Int String [String]
     deriving (Show)

data MagazineInfo = Magazine Int String [String]
     deriving (Show)

data BookReview = BookReview BookInfo CustomerID String

type CardHolder = String
type CardNumber = String 
type Address = [String]

data BillingInfo = CreditCard CardNumber CardHolder Address
     | CashOnDelivery
     | Invoice CustomerID
     deriving (Show)

myInfo = Book 84903489348 "Algebra of Programming"
       ["Richard Bird", "Oege de Moor"]




-- Author: Aaron Clevenger
-- Description: Counts the words in a text file using haskell

main = interact wordCount
     where wordCount input = show(length (lines input)) ++ "\n"
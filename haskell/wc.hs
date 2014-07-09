-- file: ch01/WC.hs
-- these are comments :)

main = interact wordCount
	where wordCount input = show (length (lines input)) ++ "\n"

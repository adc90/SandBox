-- Author: Aaron Clevenger
-- Description: Simple adding program written in Haskell

add :: Maybe Int -> Maybe Int -> Maybe Int
add mx my = 
    case mx of
        Nothing -> Nothing
        Just x  -> case my of 
                    Nothing -> Nothing
                    Just y  -> Just (x + y)

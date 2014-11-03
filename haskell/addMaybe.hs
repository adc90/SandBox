(>>==) :: Maybe a -> (a -> Maybe b) -> Maybe b
Nothing >>== _ = Nothing
(Just x) >>== f = f x 

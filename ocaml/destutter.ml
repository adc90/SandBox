let rec destutter list = 
        match list with
        | [] -> []
        | [hd] -> [hd]
        | hd :: hd' :: tl ->
                        if hd = hd' then destutter (hd' :: tl)
                        else hd :: destutter(hd' :: tl)
;;

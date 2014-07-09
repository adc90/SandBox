let x = [1;2;3;4;5;643;4]

let rec sum l = 
                match l with 
                | [] -> 0
                | hd :: tl -> hd + sum tl
;;
sum x

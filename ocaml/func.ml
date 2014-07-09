let double x = x * 2 in
        List.map double [1; 2; 3];;

let multiply n list = 
        let f x = 
                n * x in
        List.map f list;;
let x = [1;2;3];

let rec print_list = function
        [] -> ()
        | e::l -> print_int e ; print_string " " ; print_list l


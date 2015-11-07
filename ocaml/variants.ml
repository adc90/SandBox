(* Example of a record types *)
type point2d = { x: float; y: float }
type circle_desc = { center: point2d; radius: float }
type rect_desc = { lower_left: point2d; width: float; height: float }
type segment_desc = { endpoint1: point2d; endpoint2: point2d }

(* Example of variants *)
type scene_element =
    |   Circle  of circle_desc
    |   Rect    of rect_desc
    |   Segment of segment_desc

(* Example of an array  *)
let numbers = [|1; 2; 3; 4;|];;
numbers.(2) <- 4

(* Mutable Record Fields *)
type running_sum =
{ 
    mutable sum     : float;
    mutable sum_sq  : float;
    mutable samples : int;
}

(* Example of anonymous functions *)
List.map ~f:(fun x -> x + 1) [1;2;3];;

(* Example of a recursive function *)
let rec print_list = function
    [] -> ()
    | e::l -> print_int e; 
              print_string " ";
              print_list l


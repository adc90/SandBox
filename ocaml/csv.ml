open Core.Std

let read_file filename =
  let chan = open_in filename in
  Std.input_list chan

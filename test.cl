(deffunction factorial (?a)
	     (if (not (integerp ?a)) (< ?a 0)) then
	     	(printout t "Factorial Error!" crlf)
		else
			(if (= ?a 0 ) then
			  1
			 else
			(* ?a (factorial (- ?a 1))))))

PROGRAM QuadraticEquation
    IMPLICIT NONE

    REAL :: a, b, c
    REAL :: d
    REAL :: root1, root2

    WRITE(*,*) 'A, B, C Please : '
    READ(*,*) a, b, c

    d = SQRT(b*b - 4.0 * a * c)

    root1 = (-b + d) / (2.0 * a)
    root2 = (-b - d) / (2.0 * a)

    WRITE(*,*)
    WRITE(*,*) 'Roots are ', root1, ' and ', root2
END PROGRAM QuadraticEquation

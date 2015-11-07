use strict;
use warnings;

my %hashref = (
    'Adam' => 'Eve',
    'Clyde' => 'Bonnie',
    'funct' => $funcRef->("1", "2")
);

print $hashref{Adam}; print "\n";
print $hashref{Clyde}; print "\n";
my $funcRef = \&func;
$funcRef = sub {
    sub { my ($a, $b) = @_; return $a + $b; }
};
$hashref{funct}
(
    "Hello\n", 
    "World\n",
    $funcRef
); 

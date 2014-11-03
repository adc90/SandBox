use strict;
use warnings;

my %hash = ("Name" => "David", "Age" => "24");
my @array = ("Aaron","David","Clevenger");
my $scalar = "This is a string";

my $a = \%hash;
my $b = \@array;
my $c = \$scalar;

print "$a \n";
print "$b \n";
print "$c \n";

print "\n";

print "%$a \n";
print "@$b \n";
print "$$c \n";


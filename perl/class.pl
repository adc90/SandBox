package Foo;

use strict;
use warnings;

my $object = {};
bless($object);

my $obj = [3,5];
print ref($obj), " ", $obj->[1], "\n";
bless($obj);
print ref($obj), " ", $obj->[1], "\n";



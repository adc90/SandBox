my $a = 20;

unless($a < 20)
{
    printf "a is not less than 20 \n";
}
print "Value of a is : $a\n";

my $bool = 0;

unless(not $bool)
{
    print "This is false";
}

my $bool = not $bool;
print $bool;

@names = qw(Steve Bill Connor Bradley);
$count = 1;

print "\n";
foreach $names(@names) 
{
  print "$count $names \n";
  $count++;
}

my $d = 5;

until($d > 10)
{
    printf "Value of a: $d\n";
    $d = $d + 1;
}

<<<<<<< HEAD
foreach $names(@names)
{
    print "$count $names \n";
    #count++;
}
=======
until($d > 10)
{
    printf "Value of a :$\n";
}


>>>>>>> cecbab8d9684417cf034bed33c2a22365732b6b4

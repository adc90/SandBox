use strict;
use warnings;

sub subroutine_name
{
    my @list = @_;
    print "Given list is @list\n";
}

subroutine_name("A","B","C");

sub PrintHash
{
    my (%hash) = @_;

    foreach my $key (keys %hash)
    {
        my $value = $hash{$key};
        print "$key : $value\n";
    }
}

my %hash = ('Name' => 'Tom', 'Age' => 19);
PrintHash(%hash);

$a = 3.14159;
{
    my $a = 3;
    print "In block, \$a = $a\n";
    print "In block, \$::a = $::a\n";
}

print "Outside block, \$a = $a\n";
print "Outside block, \$::a = $::a\n";

$b = "hello";
{
    local $b = 3;
    print "In block, \$b = $b\n";
}
print $b;
print "\n";

my @john = (47, "brown", 186);

print "@john\n";
print \@john;

my $hashref = {'Adam' => 'Eve','Clyde' => 'Bonnie',};


sub doCoolStuff
{
    # Remember @_ = ($obj, $a, $b)
    my $self = shift;
    my ($a, $b) = @_;
}

my @ar = ("A","B","C","D","E","F");
my $s = shift @ar;
print $s;
my $g = shift @ar;
print $g;
print @ar;


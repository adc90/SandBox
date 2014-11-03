sub test
{
	print("HI\n");
	for(my $i = 0; $i <= 9; $i++)
	{
		print("$i\n");
	}

	foreach my $j (0..9)
	{
		print "$j\n";
	}
}

sub function
{
	$foo = 'Bill';
	$fooref = \$foo;
	print $fooref;
}


package Person;
sub new
{
	my $class = shift;
	my $self = {
		_firstName => shift,
		_lastName  => shift,
		_ssn       => shift,
	};
	# Print all the values just for clarification.
	print "First Name is $self->{_firstName}\n";
	print "Last Name is $self->{_lastName}\n";
	print "SSN is $self->{_ssn}\n";
	bless $self, $class;
	return $self;

	sub newFunc
	{
		print "Hi\n";
	}

        sub newFunctionTwo
        {
            print "Hi this is function two \n";
        }
}

$object = new Person("Mohammad","Saleem",23234345);
$object->newFunc();
$obj2 = new Person("Aaron","Gilbert",2334235);
$obj2->newFunc();
$obj2->newFunctionTwo();




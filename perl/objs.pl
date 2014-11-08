use strict;
use warnings;

package Person;

sub new 
{
    my $class = shift;
    my $self = {
        _firstName => shift,
        _lastName => shift,
        _ssn => shift, 
    };

    bless $self, $class;
    return $self;
}

sub setFirstName
{
    my ($self, $firstName) = @_;
    $self->{_firstName} = $firstName if defined($firstName);
    return $self->{_firstName};
}

sub getFirstName
{
    my ($self) = @_;
    return $self->{_firstName};
}

my $object = new Person("Mohammad","Saleem",23234345);
my $firstName = $object->getFirstName();
print "$firstName\n";
$object->setFirstName("David");
print $object->getFirstName();

package Employee;
use Person;

sub new {
    my ($class) = @_;

    # Call the constructor of the parent class, Person.
    my $self = $class->SUPER::new( $_[1], $_[2], $_[3] );
    # Add few more attributes
    $self->{_id}   = undef;
    $self->{_title} = undef;
    bless $self, $class;
    return $self;
}

# Override helper function
sub getFirstName {
    my( $self ) = @_;
    # This is child class function.
    print "This is child class helper function\n";
    return $self->{_firstName};
}

# Add more methods
sub setLastName{
    my ( $self, $lastName ) = @_;
    $self->{_lastName} = $lastName if defined($lastName);
    return $self->{_lastName};
}

sub getLastName {
    my( $self ) = @_;
    return $self->{_lastName};
}
$object = new Employee( "Mohammad", "Saleem", 23234345);o
$firstName = $object->getFirstName();
$object->setFirstName( "Mohd." );
print $object->getFirstName();

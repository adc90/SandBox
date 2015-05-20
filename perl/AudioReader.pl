use warnings;
use strict;

use Audio::Analyzer;

my $source = \*FILEHANDLE;
my $source = 'input.pcm';

my $analyzer = Audio::Analyzer->new(file => $source);

while(defined(my $chunk = $analyzer->next)){
	my $done = $analyzer->progress;

	print "$done% completed\n";
}

#useful information
my $freqs = $analyzer->freqs; #returns array reference
































require 'pry'



def call_back
        binding.pry
	yield
	puts "Test 1"
	yield
	puts "Test 2"
	yield
	puts "Test 3"
	yield
end

call_back{puts "I'm in the block yay"}

x = 10
5.times do |x|
        binding.pry
	puts "x inside the block: #{x * 10}"
end


puts "x outside the block: #{x}"

name = ['David','Mark','Lisa']

puts name[1]


name.each do |nm|
        binding.pry
	puts 'Hello ' + nm + '!'
end


def test(&block)
	#{block.parameters}
end

test{puts "Block on line 35"}

test

def funct(var)
	yield(var)
end

=begin
	 test
=end


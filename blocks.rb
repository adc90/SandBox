def call_back
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
	puts "x inside the block: #{x * 10}"
end


puts "x outside the block: #{x}"

name = ['David','Mark','Lisa']

puts name[1]


name.each do |nm|
	puts 'Hello ' + nm + '!'
end


def test(&block)
	#{block.parameters}
end

test{puts "Hi"}

test




def funct(var)
	yield(var)
end

=begin
	 test
=end


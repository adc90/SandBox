#Test 2 Ruby file

def three_times
    yield "Hi"
    yield "how"
    yield "are" 
    yield "you" 
    yield "?" 
end

three_times {|f| puts f}

f = File.open("Makefile")
f.each do |line|
    puts line
end
f.close

g = File.open("blocks.rb")
g.each{|i| puts i}
g.close

puts /mi/ =~ "hi mike"
puts "hi mike" =~ /mi/

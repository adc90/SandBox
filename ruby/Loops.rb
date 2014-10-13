#Loop constructs

i = 0
num = 5
while i < num do
    puts("Inside the while loop i = #{i}")
    i += 1
end

puts "\n"

for i in 0...5
    puts("Inside the for loop i = #{i}")
end

puts "\n"

i = 0
num = 5
until i > num do
    puts("Inside the until loop i = #{i}")
    i += 1
end

puts "\n"

(0..5).each do |i|
    puts("Inside the each do loop i = #{i}")
end

puts "\n"

x = 1
unless x > 2
    puts "X is less than 2"
else
    puts "X is greater than 2"
end

puts "\n"

age = 5
case age
when 0 .. 2
    puts "You are a baby"
when 3 .. 6
    puts "You are a little child"
when 7 .. 12
    puts "You are a child"
when 13 .. 18
    puts "You are a youth"
else
    puts "You are an adult"
end

unless

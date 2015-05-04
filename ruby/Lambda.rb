lamb = lambda { |x, y| puts x + y}
pnew = Proc.new {|x, y| puts x + y}

a = pnew.call(2,4)
b = lamb.call(2,4)

print a
print b

def try_ret_procnew
    ret = Proc.new {return "Baam"}
    ret.call
    "This is not reached"
end

puts try_ret_procnew

say = lambda {|something| puts something}

say["Hello"]

pr = lambda {puts "hello"}
pr.call

numbers = [1,2,5,6,9,21]

numbers.each do |x|
    puts "#{x} is " + (x >= 3 ? "many" : "few")
end

def do_twice
    yield "Welcome to the machine"
    yield "Welcome to the house"
end

def HelloTwice
    puts "Hi"
    puts "Hello"
end

dr = -> () {puts "Hola"}
do_twice {dr}
dr.call()

do_twice {|i| puts "Hello world #{i}"}

def test(&block)
    block.call "Aaron"
end

test {|i| puts "Hi #{i}"}

my_array = [:uno, :dos, :tres]
my_array.each {|item|
    puts item
}

my_array.each do |item|
    puts item
end




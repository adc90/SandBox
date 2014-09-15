class Song 
    @@plays = 0
    def initialize(name, artist, duration)
        @name = name
        @artist = artist
        @duration = duration
        @plays = 0
    end

    def play 
        @plays += 1
        @@plays += 1
        puts "This song: #@plays plays. Total #@@plays plays."
    end

    def Song.static_method
        puts "Hello static method"
    end
end

s1 = Song.new("Song1", "Artist1", 234)
s2 = Song.new("Song2", "Artist2", 345)
s1.play
s2.play

Song.static_method

fred = Class.new do
    def meth1
        "hello"
    end
    def meth2
        "bye"
    end
end
a = fred.new
puts a.meth1

class Customer
    @@no_of_customers=0
    def initialize(id, name, addr)
        @cust_id = id
        @cust_name = name
        @cust_addr = addr
        @@no_of_customers += 1
    end
    def getCust
        @@no_of_customers
    end
end

d = Customer.new
e = Customer.new
puts e.getCust

class Greeter
    attr_accessor :name
end

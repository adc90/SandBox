class MyClass
    @@value = 0

    def initialize
        puts "Hi"
        @@value = @@value + 1
    end

    def add_one
        @@value = @@value + 1
    end

    def value
        @@value
    end

    def MyClass.static_method
        puts "Static method"
    end
end

instanceOne = MyClass.new
instanceTwo = MyClass.new
puts instanceOne.value
MyClass.static_method


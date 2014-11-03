println "Hello World"
println "hello, world"
for (arg in this.args )
{
  println "Argument:" + arg;
}

def closure = {param -> println("Hello ${param}")}
closure.call("World!")

a = closure
a("Hi")

[1,2,3,4,5,6].each{item -> print "${item}-"}

println ""

class Greet
{
    def name 
    Greet(who){
        name = who[0].toUpperCase() + who[1..-1]
    }
    def salute()
    {
        println "Hello $name!"
    }
}

def foo(str)
{
    // if(str != null){ return str.reverse()}
    // Checks if the string is null, neat
    str?.reverse()
}


g = new Greet('World')
g.salute()

for(int i = 0; i < 3; i++)
    println i

for(i in 0..2)
    print 'ho '

println ""

0.upto(2){print "$it "}

println ""

3.times{print "$it "}

println ""

0.step(10,2) {print "$it "}

println ""

println foo("Hello World")

class Car
{
    def miles = 0
    final year

    Car(theYear)
    {
        year = theYear
    }
}
Car car = new Car(2008)
println "Year: $car.year"

class Robot
{
    def type, height, width

    def access(location, weight, fragile)
    {
        println "Received fragile? $fragile, wight: $weight, loc: $location"
    }
}

robot = new Robot(type: "arm", width: 10, height: 40)

println "$robot.type, $robot.height, $robot.width"

def log(x, base=10)
{
    Math.log(x) / Math.log(base)
}

println log(1024)




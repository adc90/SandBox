class Parent:
    parentAttr = 100

    def __init__(self):
        print "Calling parent constructor"

    def parentMethod(self):
        print "Calling parent method"

    def setAttr(self,attr):
        Parent.parentAttr = attr

    def getAttr(self):
        print "Parrent attribute : ", Parent.parentAttr

    def myMethod(self):
        print "Calling my method from parent"

class Child(Parent):
    someAttribute = "hello"
    __secrAttribute = "Secert"
    
    def __init__(self):
        print "Calling child constructor"

    def childMethod(self):
        print "Calling child method"

    def myMethod(self):
        print "Calling my method from child"
    
    def setSecret(self,t):
        self.__secrAttribute = t

c = Child()
c.childMethod()
c.parentMethod()
c.setAttr(200)
c.getAttr()

p = Parent()
p.myMethod()

print c.someAttribute
print c._Child__secrAttribute
c.setSecret("This is a new secert")
print c._Child__secrAttribute

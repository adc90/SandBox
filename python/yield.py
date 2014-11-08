mylist = [x*x for x in range(3)]
for i in mylist:
    print(i)
print("")
mygenerator = (x*x for x in range(3))
for i in mygenerator:
    print(i)
print("")
for i in mylist:
    print(i)
print("")
def createGenerator():
    mylist = range(3)
    for i in mylist:
        yield i*i
mygen = createGenerator()
print("")
for i in mygen:
    print(i)

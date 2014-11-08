#Fill in this function
def createGenerator():
    mylist = range(3)
    for i in mylist:
        yield i*i

myGen = createGenerator()
print(myGen)
for i in myGen:
    print(i)

a = [4,6]
b = [9,48]
a.extend(b)

for j in a:
    print(j)

def countdown(n):
    while n > 0:
        yield n
        n -= 1

for x in countdown(5):
    print x,

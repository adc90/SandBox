from __future__ import print_function

list1 = [1,2,3,4,5,6,7,8,9]

print("list1", list1[2:5])

print(len(list1))

print(list1 * 2)

print(2 in list1)

for x in list1:
    print(x)

print(list1[:3])
print(list1[3:])

tup1 = ('physics', 'chemistry', 1997, 2000, 'hello','test')

for y in tup1:
    print(y)

print(tup1[1:3])

dict = {'Alice':2341,'Beth':9102,'Cecil':3258}

print(dict['Alice'])


for keys,values in dict.items():
    print(keys)
    print(values)

g = lambda x: x**2

f = lambda x: print(x)

f("Hey")


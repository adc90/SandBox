#Python Comment

def ask_ok(prompt, r=4, complaint='Yes or No, please!'):
    while True:
        ok = input(prompt)
        if ok in ('y', 'ye', 'yes'):
            return True
        if ok in ('n', 'no', 'nope'):
            return False
        r = r - 1
        if r < 0:
            raise OSError('Uncooperative user')
        print(complaint)

ask_ok('Do you really want to quit?: ') 

def make_incrementor(n):
    return lambda x: x + n

f = make_incrementor(5)
print(f(2))

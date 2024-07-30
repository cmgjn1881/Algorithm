import sys

N = int(sys.stdin.readline())

def check(x):
    for i in range(2,int(x**0.5)+1):
        if x%i==0:
            return False
    return True

for _ in range(N):
    A = int(sys.stdin.readline())
    while True:
        if A == 0 or A == 1:
            print(2)
            break
        if check(A):
            print(A)
            break
        else:
            A += 1
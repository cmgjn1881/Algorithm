import sys

N = int(sys.stdin.readline())
L1 = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
L2 = list(map(int, sys.stdin.readline().split()))

D = {}
for i in L1:
    if i in D:
        D[i] += 1
    else:
        D[i] = 1

for i in L2:
    X = D.get(i)
    if X == None:
        print("0", end=" ")
    else:
        print(X, end=" ")
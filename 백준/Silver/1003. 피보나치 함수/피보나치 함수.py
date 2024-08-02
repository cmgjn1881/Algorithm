import sys

L = [0]*41
L[1] = 1
for i in range(2, 41):
    L[i] = L[i - 1] + L[i - 2]

T = int(sys.stdin.readline())
for i in range(T):
    n = int(sys.stdin.readline())

    if n == 0:
        print(1, 0, sep=" ")
    else:
        print(L[n - 1], L[n], sep=" ")
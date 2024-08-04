import sys

N = list(sys.stdin.readline().rstrip())
L = []

for i in range(len(N)):
    L.append("".join(N))
    N.pop(0)

L.sort()

for i in L:
    print(i)
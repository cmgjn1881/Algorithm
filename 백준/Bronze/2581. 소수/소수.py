M = int(input())
N = int(input())

L = []

for i in range(M, N+1):
    L2 = []
    for j in range(1, i):
        if i % j == 0:
            L2.append(j)
    if len(L2) == 1:
        L.append(i)

X = len(L)

if X >= 1:
    print(sum(L))
    print(L[0])
else:
    print("-1")

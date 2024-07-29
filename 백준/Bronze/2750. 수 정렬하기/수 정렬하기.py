N = int(input())

L = []

for _ in range(N):
    a = int(input())
    L.append(a)

L.sort()

for i in range(N):
    print(L[i])
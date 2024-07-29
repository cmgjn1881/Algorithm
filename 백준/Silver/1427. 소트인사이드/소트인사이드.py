N = int(input())

S = str(N)
L = []

for i in range(len(S)):
    L.append(S[i])

L.sort()
L.reverse()

for i in range(len(L)):
    print(L[i], end="")
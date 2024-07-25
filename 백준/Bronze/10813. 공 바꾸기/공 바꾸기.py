N, M = map(int, input().split())
L = []

for x in range(1, N+1):
    L.append(x)

for x in range(M):
    i, j = map(int, input().split())
    temp = L[i-1]
    L[i-1] = L[j-1]
    L[j-1] = temp
    
for x in range(N):
    print(L[x], end=" ")
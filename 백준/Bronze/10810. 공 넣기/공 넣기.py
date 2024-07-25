N, M = map(int, input().split())

L = [0]*N

for x in range(M):
    i, j, k = map(int, input().split())
    for y in range(i-1, j):
        L[y] = k

for i in range(N):
    print(L[i], end=" ")
N = int(input())

L = [list(map(int, input().split()))for _ in range(N)]
L.sort()

for i in range(N):
    print(L[i][0], L[i][1], sep=" ")


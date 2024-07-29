N = int(input())

L = [list(map(int, input().split()))for _ in range(N)]
L.sort(key=lambda x: (x[1], x[0]))

for i in range(N):
    print(L[i][0], L[i][1], sep=" ")
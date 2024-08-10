import sys

T = int(sys.stdin.readline())

def BFS(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    Q = [(x, y)]
    L[x][y] = 0

    while Q:
        x, y = Q.pop(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if L[nx][ny] == 1:
                    Q.append((nx, ny))
                    L[nx][ny] = 0


for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    L = [[0]*N for i in range(M)]
    cnt = 0

    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        L[x][y] = 1

    for i in range(M):
        for j in range(N):
            if L[i][j] == 1:
                BFS(i, j)
                cnt += 1

    print(cnt)


#4963
import sys
from collections import deque

def BFS(x, y):
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]

    Q = deque([(x, y)])
    L[x][y] = 0

    while Q:
        x, y = Q.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < h and 0 <= ny < w:
                if L[nx][ny] == 1:
                    Q.append((nx, ny))
                    L[nx][ny] = 0


while True:
    w, h = map(int, sys.stdin.readline().split())
    cnt = 0

    if w == 0 and h == 0:
        break

    L = []
    for _ in range(h):
        S = list(map(int, sys.stdin.readline().split()))
        L.append(S)

    for i in range(h):
        for j in range(w):
            if L[i][j] == 1:
                BFS(i, j)
                cnt += 1

    print(cnt)
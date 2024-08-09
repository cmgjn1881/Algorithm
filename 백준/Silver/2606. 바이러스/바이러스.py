import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


visited = [False]*(N + 1)
cnt = 0

def dfs(x):
    global cnt
    visited[x] = True
    for i in graph[x]:
        if not visited[i]:
            cnt += 1
            dfs(i)

dfs(1)
print(cnt)
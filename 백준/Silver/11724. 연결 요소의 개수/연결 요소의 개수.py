import sys
from collections import defaultdict, deque

N, M = map(int, sys.stdin.readline().split())
D = defaultdict(list)

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    D[a].append(b)
    D[b].append(a)

for key in D:
    D[key].sort()


def DFS(node, visited, graph):
    stack = [node]
    while stack:
        current = stack.pop()
        if current not in visited:
            visited.add(current)
            stack.extend(graph[current])


visited = set()
cnt = 0

for node in range(1, N + 1):
    if node not in visited:
        DFS(node, visited, D)
        cnt += 1

print(cnt)
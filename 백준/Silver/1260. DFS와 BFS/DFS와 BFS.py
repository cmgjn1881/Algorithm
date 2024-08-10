import sys
from collections import deque, defaultdict

N, M, V = map(int, sys.stdin.readline().split())
D = defaultdict(list)

for i in range(M):
    x, y = map(int, sys.stdin.readline().split())

    D[x].append(y)
    D[y].append(x)

for key in D:
    D[key].sort()


def BFS(graph, root):
    visit = []
    Q = deque([root])

    while Q:
        node = Q.popleft()
        if node not in visit:
            visit.append(node)
            Q.extend(graph[node])
    return visit

def DFS(graph, root):
    result, visit = [], []
    visit.append(root)

    while visit:
        node = visit.pop()
        if node not in result:
            result.append(node)
            visit.extend(reversed(graph[node]))

    return result


dfs_result = DFS(D, V)
print(" ".join(map(str, dfs_result)))
bfs_result = BFS(D, V)
print(" ".join(map(str, bfs_result)))

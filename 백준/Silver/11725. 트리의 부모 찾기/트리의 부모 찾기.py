import sys
from collections import defaultdict, deque

N = int(sys.stdin.readline())
D = defaultdict(list)

for i in range(N - 1):
    a, b = map(int, sys.stdin.readline().split())
    D[a].append(b)
    D[b].append(a)

def BFS(root, graph):
    visit = set()
    Q = deque([root])
    L = [0] * (N + 1)

    while Q:
        node = Q.popleft()
        visit.add(node)

        for x in graph[node]:
            if x not in visit:
                L[x] = node
                Q.append(x)

    return L


result = BFS(1, D)

for i in range(2, N + 1):
    print(result[i])
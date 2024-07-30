import sys

n = int(input())

L = {}

for _ in range(n):
    name, T = map(str, sys.stdin.readline().rstrip().split())
    if T == "enter":
        L[name] = True
    elif T == "leave":
        del L[name]

print("\n".join(sorted(L.keys(), reverse=True)))
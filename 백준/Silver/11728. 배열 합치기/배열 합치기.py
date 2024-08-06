import sys

N, M = map(int, sys.stdin.readline().split())

La = list(map(int, sys.stdin.readline().split()))
Lb = list(map(int, sys.stdin.readline().split()))

result = La + Lb
result.sort()

for x in result:
    print(x, end=" ")

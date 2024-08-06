import sys

N, K = map(int, sys.stdin.readline().split())

L = list(map(int, sys.stdin.readline().split()))

L.sort()

print(L[K - 1])
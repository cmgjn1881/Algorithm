import sys

A, B = map(int, sys.stdin.readline().split())

La = set(map(int, sys.stdin.readline().split()))

Lb = set(map(int, sys.stdin.readline().split()))

print(len(La - Lb) + len(Lb - La))
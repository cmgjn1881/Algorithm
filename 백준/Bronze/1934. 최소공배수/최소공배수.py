import sys
import math

N = int(sys.stdin.readline())

for _ in range(N):
    a, b = map(int, sys.stdin.readline().split())
    print(math.lcm(a, b))
    
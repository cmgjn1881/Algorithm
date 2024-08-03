import sys
import heapq

H = []

N = int(sys.stdin.readline())

for _ in range(N):

    X = int(sys.stdin.readline())

    if X == 0:
        if len(H) == 0:
            print(0)
        else:
            print(heapq.heappop(H))
    else:
        heapq.heappush(H, X)
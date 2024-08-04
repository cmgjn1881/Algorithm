import sys

N = int(sys.stdin.readline())

La = list(map(int, sys.stdin.readline().split()))
Lb = list(map(int, sys.stdin.readline().split()))

La.sort(reverse=True)
result = 0

for i in range(N):
    b = Lb.pop(Lb.index(max(Lb)))
    a = La.pop(-1)
    result += a * b

print(result)
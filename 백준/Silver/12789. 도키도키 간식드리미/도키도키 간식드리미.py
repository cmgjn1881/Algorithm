import sys

N = int(sys.stdin.readline())

L = list(map(int, sys.stdin.readline().split()))

stack = []
cnt = 1

for i in L:
    stack.append(i)

    while stack and stack[-1] == cnt:
        stack.pop()
        cnt += 1

if stack:
    print("Sad")
else:
    print("Nice")
import sys

S = str(sys.stdin.readline().rstrip())
N = len(S) * (len(S) + 1) // 2

L = set()

for i in range(len(S)):
    for j in range(i + 1, len(S) + 1):
        L.add(S[i:j])

L = list(L)

print(len(L))
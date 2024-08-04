import sys

N, K = map(int, sys.stdin.readline().split())

S = set()
T = 0
cnt = 0

for _ in range(N):
    x = int(sys.stdin.readline())
    S.add(x)
    if x <= K:
        T = x

L = list(sorted(S, reverse=True))
a = L.index(T)

for i in range(a, N):
    quotient, K = divmod(K, L[i])
    cnt += quotient

print(cnt)

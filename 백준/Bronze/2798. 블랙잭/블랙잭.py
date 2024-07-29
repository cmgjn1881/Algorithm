import itertools

N, M = map(int, input().split())

L = list(map(int, input().split()))

L2 = list(itertools.combinations(L, 3))

Sum = 0

for i in range(len(L2)):
    S = sum(L2[i])
    if S >= Sum:
        if S <= M:
            Sum = S
print(Sum)

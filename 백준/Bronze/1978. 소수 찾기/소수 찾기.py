N = int(input())

L = list(map(int, input().split()))
cnt = 0

for i in range(len(L)):
    M = []
    X = L[i]
    if X > 1:
        for j in range(1, X):
            if X % j == 0:
                M.append(j)

        if len(M) == 1:
            cnt += 1

print(cnt)

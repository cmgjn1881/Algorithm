N = int(input())

cnt = 0

for i in range(1, N + 1):
    if i < 100:
        cnt += 1
    else:
        K = str(i)
        L = []
        for j in range(len(K) - 1):
            X = int(K[j]) - int(K[j + 1])
            L.append(X)
        L = set(L)
        if len(L) == 1:
            cnt += 1

print(cnt)
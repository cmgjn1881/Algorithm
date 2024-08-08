import sys

N, M = map(int, sys.stdin.readline().split())
D = {}

for i in range(N):
    word = str(sys.stdin.readline().rstrip())

    if len(word) >= M:
        if word in D:
            D[word][1] += 1
        else:
            D[word] = [len(word), 1]

result = sorted(D.items(), key=lambda x : (-x[1][1], -x[1][0], x[0]))

for k in result:
    print(k[0])
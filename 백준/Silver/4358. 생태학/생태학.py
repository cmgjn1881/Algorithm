import sys

D = {}
cnt = 0
while True:
    S = str(sys.stdin.readline().rstrip())

    if S == "":
        break
    elif S in D:
        D[S] += 1
        cnt += 1
    else:
        D[S] = 1
        cnt += 1

result = sorted(D.items(),  key=lambda x : x[0])

for K in result:
    x = K[1] / cnt * 100
    print("%s %.4f" %(K[0], x))
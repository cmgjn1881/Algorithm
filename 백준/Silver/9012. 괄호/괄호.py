import sys

T = int(sys.stdin.readline())

for _ in range(T):
    S = str(sys.stdin.readline().rstrip())

    result = True
    L = []
    for i in range(len(S)):
        X = S[i]
        if X == "(":
            L.append(X)
        else:
            if len(L) == 0:
                result = False
            else:
                L.pop()

    if len(L) == 0:
        if result:
            print("YES")
        else:
            print("NO")
    else:
        print("NO")

import sys

while True:
    S = str(sys.stdin.readline().rstrip())

    L = []

    if S == ".":
        break

    for i in S:
        if i == "(" or i == "[":
            L.append(i)
        elif i == ")":
            if len(L) != 0 and L[-1] == "(":
                L.pop()
            else:
                L.append(i)
                break
        elif i == "]":
            if len(L) != 0 and L[-1] == "[":
                L.pop()
            else:
                L.append(i)
                break

    if len(L) == 0:
        print("yes")
    else:
        print("no")
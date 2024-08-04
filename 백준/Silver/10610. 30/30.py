import sys

N = list(sys.stdin.readline().rstrip())

if "0" not in N:
    print(-1)
else:
    Sum = 0
    for i in range(len(N)):
        Sum += int(N[i])

    if Sum % 3 != 0:
        print(-1)
    else:
        N.sort(reverse=True)
        print("".join(N))

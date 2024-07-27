N = int(input())

X = 2

while X <= N:
    if N % X == 0:
        N = N / X
        print(X)
    else:
        X += 1
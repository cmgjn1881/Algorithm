N = int(input())
R = 2 * N - 1

for i in range(1, R + 1):
    if i <= N:
        S = 2 * i - 1
        spaces = N - i
    else:
        S = 2 * (R - i) + 1
        spaces = i - N

    print(" " * spaces + "*" * S)

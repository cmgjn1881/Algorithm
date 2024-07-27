N = int(input())

sum = 2
X = 1

for i in range(N):
    if i > 0:
        X = X * 2
    sum += X

print(sum * sum)
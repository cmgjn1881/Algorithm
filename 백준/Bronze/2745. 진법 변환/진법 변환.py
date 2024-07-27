B, N = input().split()

alp = ['A', 'B', 'C', 'D', 'E', 'F', 'G',
       'H', 'I', 'J', 'K', 'L', 'M', 'N',
       'O', 'P', 'Q', 'R', 'S', 'T', 'U',
       'V', 'W', 'X', 'Y', 'Z']

num = [10, 11, 12, 13, 14, 15, 16, 17, 18,
       19, 20, 21, 22, 23, 24, 25, 26, 27,
       28, 29, 30, 31, 32, 33, 34, 35]

B = B[::-1]
A = B[0]
sum = 0
X = 1

for i in range(len(B)):

    if i >= 1:
        X = X * int(N)

    if B[i].isdigit():
        A = int(B[i])
    else:
        A = num[alp.index(B[i])]

    sum += X * A

print(sum)


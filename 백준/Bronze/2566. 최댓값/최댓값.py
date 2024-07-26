A = [list(map(int, input().split())) for _ in range(9)]

Max = A[0][0]
R, C = 0, 0

for row in range(9):
    for col in range(9):
        if A[row][col] >= Max:
            Max = A[row][col]
            R = row + 1
            C = col + 1

print(Max)
print(R, C)
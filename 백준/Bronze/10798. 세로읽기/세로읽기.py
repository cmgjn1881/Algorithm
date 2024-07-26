A = [input() for _ in range(5)]

for i in range(15):
    for j in range(5):
        if i < len(A[j]):
            print(A[j][i], end="")
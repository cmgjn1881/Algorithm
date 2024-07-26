S = str(input())
R = S[::-1]
F = 1

for i in range(int(len(S) / 2)):
    if S[i] != R[i]:
        F = 0
        break
        
print(F)
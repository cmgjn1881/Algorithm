S = str(input())

L = [-1]*26

for i in range(len(S)):
    X = ord(S[i]) - 97
    if L[X] == -1:
        L[X] = i
        
for i in range(len(L)):
    print(L[i], end=" ")
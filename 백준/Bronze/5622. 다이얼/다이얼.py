S = str(input())

L = []

for i in range(5):
    for j in range(3):
        L.append(i+3)
        
for i in range(4):
    L.append(8)
    
for i in range(3):
    L.append(9)
    
for i in range(4):
    L.append(10)

sum = 0
for i in range(len(S)):
    X = ord(S[i]) - 65
    sum += L[X]
    
print(sum)
    
    
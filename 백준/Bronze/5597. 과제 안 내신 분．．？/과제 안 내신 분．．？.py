L = []
for i in range(30):
    L.append(i+1)

for i in range(28):
    a = int(input())
    L.remove(a)
    
print(min(L))
print(max(L))
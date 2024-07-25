L = []

for i in range(10):
    a = int(input())
    b = a % 42
    if b not in L:
        L.append(b)
           
print(len(L))
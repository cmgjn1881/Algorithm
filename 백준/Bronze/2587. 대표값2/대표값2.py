L = []

for _ in range(5):
    a = int(input())
    L.append(a)
    
avg = sum(L) // 5
L.sort()
mid = L[2]

print(avg)
print(mid)

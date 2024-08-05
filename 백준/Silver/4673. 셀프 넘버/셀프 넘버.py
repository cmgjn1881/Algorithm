L = [1]*10001
L[0] = 0

for i in range(1, len(L)):
    L[i] = i

L2 = []

for i in range(1, len(L)):
    k = str(L[i])
    Sum = L[i]
    for j in range(len(k)):
        Sum += int(k[j])
    if Sum in L:
        L2.append(Sum)

L3 = set(L) - set(L2)
L3.remove(0)
result = list(sorted(L3))
for x in result:
    print(x)

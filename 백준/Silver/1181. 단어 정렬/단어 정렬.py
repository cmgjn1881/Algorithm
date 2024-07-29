N = int(input())

L = []
L3 = []

for _ in range(N):
    A = input()
    L.append(A)

L2 = list(set(L))
for i in range(len(L2)):
    B = [len(L2[i]), L2[i]]
    L3.append(B)

L3.sort()

for i in range(len(L3)):
    print(L3[i][1])

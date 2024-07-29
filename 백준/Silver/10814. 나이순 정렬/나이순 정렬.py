N = int(input())

L = []
for i in range(N):
    age, name = input().split()
    X = [age, name]
    L.append(X)

L.sort(key=lambda x:int(x[0]))

for i in L:
    print(i[0], i[1])
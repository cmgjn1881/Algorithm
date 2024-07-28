N = int(input())

Lx = []
Ly = []

for i in range(N):
    a, b = map(int, input().split())
    Lx.append(a)
    Ly.append(b)

X = max(Lx) - min(Lx)
Y = max(Ly) - min(Ly)

print(int(X * Y))



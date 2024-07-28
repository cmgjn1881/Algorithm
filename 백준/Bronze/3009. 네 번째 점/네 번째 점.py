Lx = [0]*3
Ly = [0]*3

for i in range(3):
    a, b = map(int, input().split())
    Lx[i] = a
    Ly[i] = b

dx, dy = Lx[0], Ly[0]

for i in range(3):
    if Lx.count(Lx[i]) == 1:
        dx = Lx[i]
    if Ly.count(Ly[i]) == 1:
        dy = Ly[i]

print(dx, dy, sep=" ")




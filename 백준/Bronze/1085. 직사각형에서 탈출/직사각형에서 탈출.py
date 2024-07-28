x, y, w ,h = map(int, input().split())

L = []

L.append(x)
L.append(y)
L.append(w - x)
L.append(h - y)
d1 = ((x - w)**2 + (y - h)**2)**(1/2)
d2 = ((w - x)**2 + (h - y)**2)**(1/2)
L.append(d1)
L.append(d2)

print(min(L))
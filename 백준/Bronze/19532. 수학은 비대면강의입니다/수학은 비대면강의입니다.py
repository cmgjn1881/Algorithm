a, b, c, d, e, f = map(int, input().split())

y = int((f * a - d * c) / (e * a - d * b))

x = int((e * c - b * f) / (a * e - d * b))

print(x, y, sep=" ")
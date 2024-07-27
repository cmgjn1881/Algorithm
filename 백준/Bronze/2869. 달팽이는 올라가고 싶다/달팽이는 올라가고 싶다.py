A, B, V = map(int, input().split())

D = (V - B) / (A - B)

if D == int(D):
    print(int(D))
else:
    print(int(D + 1))
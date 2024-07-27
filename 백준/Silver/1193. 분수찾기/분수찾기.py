X = int(input())

cnt = 1
i = 1
a, b = 1, 1

while X > cnt:
    X -= cnt
    cnt += 1

if cnt % 2 == 0:
    a = X
    b = cnt + 1 - X
else:
    a = cnt + 1 - X
    b = X

print(str(a) + "/" + str(b))
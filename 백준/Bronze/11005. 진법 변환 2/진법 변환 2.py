N, B = map(int, input().split())

alp = ['A', 'B', 'C', 'D', 'E', 'F', 'G',
       'H', 'I', 'J', 'K', 'L', 'M', 'N',
       'O', 'P', 'Q', 'R', 'S', 'T', 'U',
       'V', 'W', 'X', 'Y', 'Z']

L = []

remain = N

while remain >= B:
    remain, quotient = divmod(remain, B)
    L.append(quotient)
L.append(remain)

L.reverse()

result = ""
for A in L:
    if A >= 10:
        result += alp[A - 10]
    else:
        result += str(A)

print(result)

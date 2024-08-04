import sys

N = str(sys.stdin.readline().rstrip())
L = []
check = False
result = ""

for i in N:

    if i == "<":
        while L:
            result += L.pop()
        check = True
        result += i
    elif i == ">":
        check = False
        result += i
    elif i == " ":
        while L:
            result += L.pop()
        result += i
    elif check:
        result += i
    else:
        L.append(i)

while L:
    result += L.pop()
print(result)
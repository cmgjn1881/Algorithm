a = int(input())
b = int(input())
c = int(input())

S = " "

if a + b + c == 180:
    if a == b:
        if a == c:
            S = "Equilateral"
        else:
            S = "Isosceles"
    else:
        if b == c:
            S = "Isosceles"
        elif a == c:
            S = "Isosceles"
        else:
            S = "Scalene"
else:
    S = "Error"

print(S)
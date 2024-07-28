while True:
    a, b, c = map(int, input().split())

    S = " "

    if a == b and b == c:
        if a == 0:
            break
        else:
            S = "Equilateral"
    else:
        L = [a, b, c]
        Max, Min = max(L), min(L)
        L.remove(Max)
        L.remove(Min)
        Mid = L[0]
        if Max >= Mid + Min:
            S = "Invalid"
        else:
            if a == b:
                S = "Isosceles"
            elif b == c:
                S = "Isosceles"
            elif a == c:
                S = "Isosceles"
            else:
                S = "Scalene"
    print(S)
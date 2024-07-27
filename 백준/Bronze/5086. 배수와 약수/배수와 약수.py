while True:
    a, b = map(int, input().split())

    S = ""

    if a == 0:
        if b == 0:
            break
    elif a >= b:
        if a % b == 0:
            S = "multiple"
        else:
            S = "neither"
    else:
        if b % a == 0:
            S = "factor"
        else:
            S = "neither"
    print(S)



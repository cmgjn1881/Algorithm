a, b, c = map(int, input().split())

L = [a, b, c]

Max, Min = max(L), min(L)

L.remove(Max)
L.remove(Min)

Mid = L[0]

if Max >= Mid + Min:
    Max = Mid + Min - 1

R = Max + Mid + Min
print(R)
N, k = map(int, input().split())

L = list(map(int, input().split()))

L.sort()
L.reverse()

print(L[k - 1])
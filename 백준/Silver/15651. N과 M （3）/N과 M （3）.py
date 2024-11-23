import itertools

N, M = map(int, input().split())

for product in itertools.product(range(1, N + 1), repeat=M):
    print(*product)
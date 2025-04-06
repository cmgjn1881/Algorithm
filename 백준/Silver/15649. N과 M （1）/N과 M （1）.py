import itertools

N, M = map(int, input().split())

for permutation in itertools.permutations(range(1, N + 1), M):
    print(*permutation)
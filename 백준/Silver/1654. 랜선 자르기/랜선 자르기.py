import sys

K, N = map(int, sys.stdin.readline().split())
L = []

for i in range(K):
    x = int(sys.stdin.readline())
    L.append(x)


def binary_search(target, data):
    start = 1
    end = max(data)
    result = 0

    while start <= end:
        mid = (start + end) // 2
        Sum = 0

        for lan in data:
             Sum += lan // mid

        if Sum >= target:
            result = mid
            start = mid + 1

        else:
            end = mid - 1

    return result


print(binary_search(N, L))







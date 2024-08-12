import sys

N, M = map(int, sys.stdin.readline().split())
L = list(map(int, sys.stdin.readline().split()))


def binary_search(target, data):
    start = 0
    end = max(data)
    result = 0

    while start <= end:
        mid = (start + end) // 2
        Sum = 0

        for tree in data:
            if tree > mid:
                Sum += tree - mid

        if Sum >= target:
            result = mid
            start = mid + 1

        else:
            end = mid - 1

    return result


result = binary_search(M, L)
print(result)





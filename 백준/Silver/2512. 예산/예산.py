import sys

N = int(sys.stdin.readline())
L = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())

L.sort()

def binary_search(data, budget, n):
    start = 0
    end = data[-1]
    result = 0

    while start <= end:
        mid = (start + end) // 2
        Sum = 0

        for i in range(n):
            if data[i] > mid:
                Sum += mid
            else:
                Sum += data[i]

        if Sum <= budget:
            result = mid
            start = mid + 1
        else:
            end = mid - 1

    return result



if sum(L) <= M:
    print(L[-1])

else:
    x = binary_search(L, M, N)
    print(x)
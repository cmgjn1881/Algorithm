N = int(input())

result = 0

for i in range(N):
    n = str(i)
    Sum = i
    for j in range(len(n)):
        Sum += int(n[j])

    if Sum == N:
        result = i
        break

print(result)
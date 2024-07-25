N = int(input())
L = list(map(int, input().split()))

Max = max(L)
for i in range(N):
    L[i] = L[i] / Max * 100
    
avg = sum(L) / len(L)
print(avg)
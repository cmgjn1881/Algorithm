import sys

def check(x):
    if x == 1:
        return False
    else:
        for i in range(2,int(x**0.5)+1):
            if x%i==0:
                return False
        return True

L = list(range(2, 246912))
L2 = []

for i in L:
    if check(i):
        L2.append(i)

while True:
    n = int(sys.stdin.readline())

    if n == 0:
        break

    cnt = 0

    for i in L2:
        if n < i <= 2 * n:
            cnt += 1
    print(cnt)
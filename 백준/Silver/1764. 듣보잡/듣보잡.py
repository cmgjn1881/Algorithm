import sys

A, B = map(int, sys.stdin.readline().split())

L1 = set()
L2 = set()
for _ in range(A):
    a = sys.stdin.readline().rstrip()
    L1.add(a)

for _ in range(B):
    b = sys.stdin.readline().rstrip()
    L2.add(b)

L3 = L1 & L2

print(len(L3))
print("\n".join(sorted(L3)))
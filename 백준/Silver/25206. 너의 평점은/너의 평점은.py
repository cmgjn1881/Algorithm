rating = ['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', 'F']
grade = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0]

total = 0
result = 0

for _ in range(20):
    A, B, C = input().split()
    B = float(B)
    if C != 'P':
        total += B
        result += B * grade[rating.index(C)]


print(result / total)
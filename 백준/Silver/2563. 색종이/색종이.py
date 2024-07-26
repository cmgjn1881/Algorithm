N = int(input())

# 100x100 크기의 격자판 초기화
grid = [[0] * 100 for _ in range(100)]

# 색종이 붙이기
for _ in range(N):
    x, y = map(int, input().split())
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            grid[i][j] = 1  # 색종이가 덮는 영역을 1로 표시

# 덮인 영역의 크기 계산
total_area = 0
for row in grid:
    total_area += sum(row)

print(total_area)

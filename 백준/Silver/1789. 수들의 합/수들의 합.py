import sys

N = int(sys.stdin.readline())
cnt = 0
current_num = 1

while N > 0:
    if N >= current_num:
        N -= current_num
        cnt += 1
    else:
        break
    current_num += 1

print(cnt)
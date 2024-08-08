import sys


def split_list(lst, delimiter):
    result = []
    current_list = []

    for item in lst:
        if item == delimiter:
            result.append(set(current_list))
            current_list = []
        else:
            current_list.append(item)

    result.append(set(current_list))

    return result


N = int(sys.stdin.readline())

L = []
P = False

for i in range(N):
    S = str(sys.stdin.readline().rstrip())
    if S == "ENTER":
        P = True

    if P:
        L.append(S)


result = split_list(L, "ENTER")
cnt = 0
for k in result:
    cnt += len(k)
    
print(cnt)
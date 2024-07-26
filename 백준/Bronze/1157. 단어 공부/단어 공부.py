S = str(input())

L = [0]*26

for i in range(len(S)):
    if S[i].islower():
        L[ord(S[i]) - 97] += 1
    else:
        L[ord(S[i]) - 65] += 1

Max = 0
MaxN = -1
is_duplicate = False

for i in range(26):
    if L[i] > Max:
        Max = L[i]
        MaxN = i
        is_duplicate = False
    elif L[i] == Max:
        is_duplicate = True
        
if is_duplicate:
    print("?")
else:
    print(chr(MaxN + ord('A')))
while True:

    n = int(input())

    if n == -1:
        break

    L = []
    sum = 0

    for i in range(1, n):
        if n % i == 0:
            L.append(i)
            sum += i

    if n == sum:
        print(str(n) + " =", end="")
        for k in range(len(L)):
            if k < len(L) - 1:
                print(" " + str(L[k]) + " +", end="")
            else:
                print(" " + str(L[k]))

    else:
        print(str(n) + " is NOT perfect.")
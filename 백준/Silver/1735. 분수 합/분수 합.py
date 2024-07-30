import sys
import math

A, B = map(int, sys.stdin.readline().split())
C, D = map(int, sys.stdin.readline().split())

Y = math.lcm(B, D)

X = (Y // B) * A + (Y // D) * C

if math.gcd(X, Y) == 1:
    print(X, Y, sep=" ")
else:
    T = math.gcd(X, Y)
    print((X // T), (Y // T), sep=" ")
import sys
input = sys.stdin.readline
tc = int(input())

for _ in range(tc):
    n = int(input())
    dp = [0] * (n+1)
    for i in range(1, n+1):
        if i < 4:
            dp[i] = 1
        elif i < 6:
            dp[i] = 2
        else:
            dp[i] = dp[i-1] + dp[i-5]
    print(dp[n])
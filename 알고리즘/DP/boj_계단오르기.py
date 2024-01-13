import sys
input = sys.stdin.readline
n = int(input())
stairPoint = [0] * (n+1)
dp = [0] * (n+1)
for i in range(1, n+1):
    stairPoint[i] = int(input())

dp[1] = stairPoint[1]

for i in range(2, n+1):
    if i == 2:
        dp[2] = stairPoint[1] + stairPoint[2]
    else:
        dp[i] = max(dp[i-2], dp[i-3] + stairPoint[i-1]) + stairPoint[i]

print(dp[n])
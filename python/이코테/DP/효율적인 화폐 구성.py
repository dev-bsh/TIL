n, m = map(int, input().split())
coin = []
for _ in range(n):
    coin.append(int(input()))

dp = [10001] * (m + 1)
dp[0] = 0

for i in range(n):
    for j in range(coin[i], m+1):
        if dp[j - coin[i]] != 10001:
            dp[j] = min(dp[j], dp[j - coin[i]] + 1)

print(dp[m] if dp[m] != 10001 else -1)

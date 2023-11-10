x = int(input())
food = list(map(int, input().split()))

dp = [0] * 101
dp[0] = food[0]
dp[1] = max(food[0], food[1])

for i in range(2, x):
    dp[i] = max(dp[i-1], dp[i-2] + food[i])

print(dp[x-1])
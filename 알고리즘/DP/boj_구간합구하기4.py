import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
numberList = [0] + list(map(int, input().rstrip().split()))

target = []
for _ in range(m):
    a, b = map(int, input().rstrip().split())
    target.append((a,b))

dp = [0] * (n+1)
for i in range(1, n+1):
    dp[i] = dp[i-1] + numberList[i]

for i in range(m):
    a, b = target[i]
    print(dp[b] - dp[a-1])

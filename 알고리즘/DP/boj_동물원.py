n = int(input())
answer = 0
# dp = (왼쪽으로 끝, 오른쪽 끝, 아무것도 없음)
# 사자 넣는 경우의 수 = 3
# 칸을 늘려 왼쪽 배치하는 경우 
# 이전칸 왼쪽으로 사자가 배치된 경우를 빼고 계산

dp = [1, 1, 1]

for i in range(2, n+1):
    pre_total = sum(dp)
    dp[0] = pre_total - dp[0]
    dp[1] = pre_total - dp[1]
    dp[2] = pre_total

print(sum(dp) % 9901)

# 다른 풀이
# dp[i] = dp[i-1]*2 + dp[i-2]
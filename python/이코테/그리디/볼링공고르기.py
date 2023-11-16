n, m = map(int, input().split())
nums = list(map(int, input().split()))

numCnt = [0] * (m+1)

for i in nums:
    numCnt[i] += 1

result = 0

# 2중 for문
for i in range(1, m+1):
    for j in range(i+1, m+1):
        result += numCnt[i] * numCnt[j]

# 더 빠른 풀이
for i in range(1, m+1):
    # A가 사용하는 볼링공 개수 제외
    n -= numCnt[i]
    # A가 사용하려는 볼링공 개수 * 나머지 공 개수
    result += numCnt[i] * n


print(result)

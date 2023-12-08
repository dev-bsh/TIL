a = input()
b = input()
sWord = a if len(a) <= len(b) else b
lWord = b if len(a) <= len(b) else a
answer = 0

## 문자열 직접 비교 구현 풀이 ##
def checkSubString(right, left):
    answer = 0
    count = 0
    for i in range(len(right)):
        if right[i] == left[i]:
            count += 1
            answer = max(answer, count)
        else:
            count = 0
    return answer

for i in range(1, len(sWord)):
    right = sWord[-i:]
    left = lWord[:i]
    answer = max(checkSubString(right, left), answer)

for i in range(len(lWord) - len(sWord)+1):
    right = sWord
    left = lWord[i:i+len(sWord)]
    answer = max(checkSubString(right, left), answer)
    
for i in range(1, len(sWord)):
    right = lWord[-i:]
    left = sWord[:i]
    answer = max(checkSubString(right, left), answer)

print(answer)


## DP 풀이법 -> pypy3로 돌려야됨 ##
dp = [[0] * (len(a)+1) for _ in range(len(b)+1)]

for i in range(1, len(b)+1):
    for j in range(1, len(a)+1):
        if b[i-1] == a[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
            answer = max(answer, dp[i][j])
print(answer)

## 탐색 범위 최소화 ##
dp = [0] * (len(sWord)+1)
for i in range(len(sWord)):
    start = max(dp)
    # 최대값 개수부터만 체크해서 범위 축소
    for k in range(start, len(sWord)+1):
        # 범위 넘어가면 pass
        if i+k > len(sWord):
            break
        target = sWord[i:i+k]

        # 최대값 갱신
        if target in lWord:
            dp[k] = max(dp[k], k)
        else:
            break
print(max(dp))

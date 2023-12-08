n = int(input())
nums = list(map(int, input().split()))
nums.sort()

# 누적합 풀이
answer = 1
for n in nums:
    if answer >= n:
        answer += n
    else:
        break
print(answer)


# 옛날 풀이
# 가지고 있는 숫자로 만들 수 있는지 계속 확인
# 확인할 숫자에서 가능한 큰 수 부터 빼준다
answer = 1
count = answer
idx = n-1
while idx >= 0:
    if count < nums[idx]:
        idx -= 1
    elif count == nums[idx]:
        answer += 1
        idx = n-1
        count = answer
    else:
        count -= nums[idx]
        idx -= 1
    
print(answer)
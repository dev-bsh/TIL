n = int(input())
nums = list(map(int, input().split()))
nums.sort()

preTime = 0
result = 0
for i in range(len(nums)):
    result += preTime + nums[i]
    preTime += nums[i]

print(result)


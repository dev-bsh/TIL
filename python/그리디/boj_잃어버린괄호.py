s = input()

target = s.split('-')

for i in range(len(target)):
    nums = list(map(int, target[i].split('+')))
    target[i] = sum(nums)

answer = target[0]
for i in range(1, len(target)):
    answer -= target[i]

print(answer)

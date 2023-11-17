score = input()
mid = len(score) // 2
leftSum, rightSum = 0, 0

for i in range(len(score)):
    if i < mid:
        leftSum += int(score[i])
    else:
        rightSum += int(score[i])
        
print('LUCKY' if leftSum == rightSum else 'READY')
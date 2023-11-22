numStr = input()

result = 0
for i in range(len(numStr)):
    num = int(numStr[i])
    if result < 2 or num < 2:
        result += num
    else:
        result *= num

print(result)
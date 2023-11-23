n = int(input())

result = 0
while n > 0:
    if n % 5 == 0:
        result += n // 5
        n %= 5
    elif n % 3 == 0:
        result += 1
        n -= 3
    elif n > 5:
        result += 1
        n -= 5
    elif n > 3:
        result += 1
        n -= 3
    else:
        break

if n > 0:
    print(-1)
else:
    print(result)
    
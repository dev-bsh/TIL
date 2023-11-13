n = int(input())
coins = list(map(int, input().split()))
coins.sort()

result = 1
for coin in coins:
    # 지금까지 만들었던 값에 포함되지 않은 동전
    if result < coin:
        break
    result += coin

print(result)



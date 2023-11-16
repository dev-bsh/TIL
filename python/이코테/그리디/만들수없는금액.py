n = int(input())
coins = list(map(int, input().split()))
coins.sort()

target = 1
for coin in coins:
    # 만들수 있는 값에 포함된 동전이면 최대값을 (최대값 + 해당동전)으로 갱신
    if target >= coin:
        target += coin
    else:
        break

print(target)



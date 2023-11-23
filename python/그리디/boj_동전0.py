n, k = map(int, input().split())
coins = [0] * n
for i in range(n):
    coins[i] = int(input())

result = 0

while k > 0:
    for i in reversed(range(n)):
        if k >= coins[i]:
            result += k // coins[i]
            k %= coins[i]

print(result)
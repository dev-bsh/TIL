n, m = map(int, input().split())
s = []
target = []
answer = 0

for _ in range(n):
    s.append(input())

for _ in range(m):
    target.append(input())

for word in target:
    if word in s:
        answer += 1

print(answer)
n = int(input())
schedule = []

for i in range(n):
    a, b = map(int, input().split())
    schedule.append((a, b))

# 제일 빨리 끝나는 회의중 제일 빠르게 시작하는 회의 순
schedule.sort(key= lambda x: (x[1], x[0]))

curStart, curEnd, result = 0, 0, 0
for s in schedule:
    start = s[0]
    end = s[1]
    if curEnd <= start:
        curStart = start
        curEnd = end
        result += 1
    print(start, end)
print(result)
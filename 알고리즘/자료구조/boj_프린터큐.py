import heapq
from collections import deque
import sys
input = sys.stdin.readline
tc = int(input())
answer = []

for _ in range(tc):
    n, m = map(int, input().split())
    numbers = list(map(int, input().split()))
    dataQue = deque()
    priorityQue = []
    for i in range(len(numbers)):
        dataQue.append((numbers[i], i))
        heapq.heappush(priorityQue, -1 * numbers[i])
    
    count = 1
    priority = heapq.heappop(priorityQue)
    while True:
        # 제일 앞쪽 data
        nowPriority, nowIdx = dataQue.popleft()
        # 우선순위 동일하면 m 과 비교
        if -1*priority == nowPriority:
            if nowIdx == m:
                break
            priority = heapq.heappop(priorityQue)
            count += 1
        # 우선순위 낮으면 배열 맨 뒤로            
        else:
            dataQue.append((nowPriority, nowIdx))
    answer.append(count)

for data in answer:
    print(data)

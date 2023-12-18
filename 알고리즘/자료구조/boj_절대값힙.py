import heapq
import sys
input = sys.stdin.readline
n = int(input())
q = []
answer = []
for _ in range(n):
    x = int(input())
    if x != 0:
        heapq.heappush(q, (abs(x), x))
    else:
        if q:
            top = heapq.heappop(q)
            tmp = []
            heapq.heappush(tmp, top[1])
            while q:
                data = heapq.heappop(q)
                if top[0] == data[0]:
                    heapq.heappush(tmp, data[1])
                else:
                    heapq.heappush(q, data)
                    break
            answer.append(heapq.heappop(tmp))
            while tmp:
                data = heapq.heappop(tmp)
                heapq.heappush(q, (abs(data), data))
        else:
            answer.append(0)
            
for a in answer:
    print(a)
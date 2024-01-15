import heapq
import sys
input = sys.stdin.readline
q = []
n = int(input())

for _ in range(n):
    num = int(input())
    if num == 0:
        print(heapq.heappop(q) if q else 0)
    else:
        heapq.heappush(q, num)
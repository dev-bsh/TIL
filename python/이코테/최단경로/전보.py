import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)

# x to y value z
for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y,z))

def dijkstra(start):
    q = []
    # (거리, 위치)
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        # 최단 거리가 가장 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 이미 최단거리로 방문한 노드면 continue
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)
totalCount = 0
# 총 시간은 가장 먼 노드까지의 거리
totalTime = 0
for i in distance:
    if i != INF:
        totalCount += 1
        totalTime = max(totalTime, i)

print(totalCount - 1, totalTime)
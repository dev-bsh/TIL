INF = int(1e9)
n = int(input())
m = int(input())

graph = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    start, end, dist = map(int, input().split())
    graph[start][end] = dist

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print("INFINYTY", end=" ")
        else:
            print(graph[a][b], end=" ")
    print()

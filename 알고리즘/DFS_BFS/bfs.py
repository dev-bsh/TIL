from collections import deque

def bfs(graph, start, visited):
    visited[start] = True
    # [start값] 으로된 배열을 넣어 queue초기화
    queue = deque([start]) 

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9
bfs(graph, 1 , visited)
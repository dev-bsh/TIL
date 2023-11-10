from collections import deque

n, m = map(int, input().split())
maze = []
visited = [[False]*m for _ in range(n)]
for _ in range(n):
    maze.append(list(map(int, input())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

count = 1
def bfs(x, y):
    queue = deque()
    queue.append((x,y))

    while queue:
        x,y = queue.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if maze[nx][ny] == 0:
                continue
            if not visited[nx][ny]:
                queue.append((nx,ny))
                maze[nx][ny] = maze[x][y] + 1
    return maze[n-1][m-1]

print(bfs(0, 0))
for i in range(n):
    for j in range(m):
        print(maze[i][j], end=' ')
    print()

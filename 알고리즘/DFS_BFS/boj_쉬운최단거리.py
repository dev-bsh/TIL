import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
board = [[0] * m for _ in range(n)]
startX, startY = 0, 0
for i in range(n):
    tmp = list(map(int, input().rstrip().split()))
    for j in range(len(tmp)):
        board[i][j] = int(tmp[j]) -1
        if tmp[j] == 2:
            startX = i
            startY = j

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def bfs():
    q = deque()
    q.append((startX, startY))
    board[startX][startY] = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if board[nx][ny] != 0 or (nx == startX and ny == startY):
                continue
            q.append((nx, ny))
            board[nx][ny] = board[x][y] + 1

bfs()

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 and (i != startX or j != startY):
            print(-1, end=' ')
        elif board[i][j] == -1:
            print(0, end=' ')
        else:
            print(board[i][j], end=' ')
    print()
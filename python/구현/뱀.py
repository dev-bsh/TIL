from collections import deque
n = int(input())
board = [[0] * n for _ in range(n)]

apple = int(input())
# 사과는 2
for a in range(apple):
    i, j = map(int, input().split())
    board[i-1][j-1] = 2

c = int(input())
command = deque()
for _ in range(c):
    time, direction = input().split()
    command.append((int(time), direction))

board[0][0] = 1
cnt, headX, headY = 0, 0, 0
tailX, tailY = 0, 0
dx = [1,0,-1,0]
dy = [0,1,0,-1]
idx = 0

tailIdx = 0
turnPoints = deque()
time, direction = command.popleft()

while True:
    cnt += 1
    
    # 머리를 다음칸으로
    headX += dx[idx]
    headY += dy[idx]
    # 벽이나 몸이랑 부딪히면 종료
    if headX >= n or headX < 0 or headY >= n or headY < 0 or board[headY][headX] == 1:
        break
    # 사과가 있으면 사과가 머리로 대체하고 꼬리 그대로
    elif board[headY][headX] == 2:
        board[headY][headX] = 1
    # 사과가 없으면 머리는 전진하고 꼬리칸 비우기
    elif board[headY][headX] == 0:
        board[headY][headX] = 1
        board[tailY][tailX] = 0

        # 꼬리가 방향 변경점에 이르면 꼬리 이동방향 변경
        if len(turnPoints) > 0:
            tx, ty, dr = turnPoints[0]
            if tx == tailX and ty == tailY:
                if dr == 'L':
                    tailIdx = tailIdx-1 if tailIdx > 0 else 3
                elif dr == 'D':
                    tailIdx = tailIdx+1 if tailIdx < 3 else 0
                turnPoints.popleft()

        tailX += dx[tailIdx]
        tailY += dy[tailIdx]
    
    # 방향전환
    if cnt == time:
        if direction == 'L':
            idx = idx-1 if idx > 0 else 3
        elif direction == 'D':
            idx = idx+1 if idx < 3 else 0
        # 꼬리 이동을 위해 방향전환지점 기록
        turnPoints.append((headX, headY, direction))
        if len(command) > 0:
            time, direction = command.popleft()
    

print(cnt)



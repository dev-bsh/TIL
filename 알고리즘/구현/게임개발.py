n,m = map(int, input().split())
array = [[0] * m for _ in range(n)]
x, y, direction = map(int, input().split())
for i in range(n):
    array[i] = list(map(int, input().split()))

# 북,동,남,서의 왼쪽
dx = [0,-1,0,1]
dy = [-1,0,1,0]

# 북,동,남,서의 뒤쪽
bx = [1,0,-1,0]
by = [0,-1,0,1]

result = 1
count = 0
array[x][y] = 2 #최초 시작 육지 포인트
while True:
    # for i in range(n):
    #     for j in range(m):
    #         print(array[i][j], end=' ')
    #     print()
    # print()
    # print(x,y,direction,count)
    if count > 3:
        count = 0
        x += bx[direction]
        y += by[direction]
        if array[x][y] == 1:
            break
    if array[x+dx[direction]][y+dy[direction]] == 0:
        result += 1
        count = 0
        array[x+dx[direction]][y+dy[direction]] = 2
        x += dx[direction]
        y += dy[direction]
        direction = direction - 1 if direction > 0 else 3
    else:
        direction = direction - 1 if direction > 0 else 3
        count += 1

print(result)
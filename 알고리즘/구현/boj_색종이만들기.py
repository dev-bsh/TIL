length = int(input())
board = [[] for _ in range(length)]
oneCnt = 0
zeroCnt = 0
for i in range(length):
    board[i] = list(map(int, input().split()))


def find(x, y, n):
    global board
    global oneCnt
    global zeroCnt

    base = board[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if board[i][j] != base:
                find(x, y, n//2)
                find(x, y+n//2, n//2)
                find(x+n//2, y, n//2)
                find(x+n//2, y+n//2, n//2)
                return
    if base:
        oneCnt += 1
    else:
        zeroCnt += 1
    
find(0, 0, length)
print(zeroCnt)
print(oneCnt)
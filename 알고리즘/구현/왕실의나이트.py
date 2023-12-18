point = input() # ex) a1, b3, c5
x,y = ord(point[0]), int(point[1])
minX, maxX = ord('a'), ord('h')
minY, maxY = 1, 8
result = 0
dx = [2, -2]
dy = [1, -1]
for i in dx:
    for j in dy:
        if minX <= x+i <= maxX and minY <= y+j <= maxY:
            result += 1
        if minY <= y+i <= maxY and minX <= x+j <= maxX:
            result += 1
print(result)

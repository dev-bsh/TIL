n = int(input())
command = input().split()
x, y = 0, 0
for c in command:
    if c == 'R' and x+1 < n:
        x += 1
    elif c == 'L' and x-1 > -1:
        x -= 1
    elif c == 'U' and y-1 > -1:
        y -= 1
    elif c == 'D' and y+1 < n:
        y += 1
print(y+1, x+1)

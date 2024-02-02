n = int(input())
answer = 0
queen = [0] * n

def check(x):
    for i in range(x):
        if queen[x] == queen[i] or abs(queen[x] - queen[i]) == abs(x - i):
            return False
    return True

def find(x):
    global answer
    if x == n:
        answer += 1
        return
    for i in range(n):
        queen[x] = i
        if check(x):
            find(x+1)

find(0)
print(answer)
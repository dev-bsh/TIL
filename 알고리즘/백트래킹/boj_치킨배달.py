INF = int(1e9)
# 1. 치킨집 좌표를 조합
# 2. 집 좌표 배열 저장
# 3. 치킨집 좌표 조합에 따른 각 집마다 최소 치킨거리 구하기
n, m = map(int, input().split())
chicken = []
house = []
for i in range(n):
    board = list(map(int, input().split()))
    for j in range(n):
        if board[j] == 1:
            house.append([i, j, INF])
        elif board[j] == 2:
            chicken.append((i, j))

answer = INF
target = [0] * m
# 재귀로 치킨집 경우의수 조합 찾기
def find(x, k):
    if x == m:
        checkDist()
        return
    for i in range(k, len(chicken)):
        target[x] = i
        find(x+1, i+1)

# 브루트포스로 최소 치킨거리 찾기
def checkDist():
    global answer
    for i in target:
        for j in range(len(house)):
            dist = abs(chicken[i][0] - house[j][0]) + abs(chicken[i][1] - house[j][1])
            house[j][2] = min(house[j][2], dist)
    tmp = 0
    for i in range(len(house)):
        tmp += house[i][2]
        house[i][2] = INF
    answer = min(answer, tmp)

find(0, 0)
print(answer)

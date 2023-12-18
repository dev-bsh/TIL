import sys
input = sys.stdin.readline
n = int(input())
adventurers = list(map(int, input().split()))
adventurers.sort()

answer = 0
count = 0
for i in adventurers:
    count += 1
    # 그룹 총원 보다 공포도가 작거나 같으면 새로운 그룹으로 생성
    if count >= i:
        answer += 1
        count = 0

print(answer)
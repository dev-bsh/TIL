# 튜플을 사용한 정렬 lambda를 이용한 키 정렬
n = int(input())
array = []
for i in range(n):
    data = input().split()
    array.append((data[0], data[1]))

array.sort(key=lambda x: x[1])

for i in array:
    print(i[0], end=' ')
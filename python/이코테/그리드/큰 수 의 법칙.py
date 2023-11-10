# 배열의 크기 n, 숫자가 더해지는 횟수 m, 최대 중복 k
n,m,k = map(int, input().split())
array = list(map(int, input().split()))
list.sort(array, reverse=True)

result = 0
count = 0

# 반복문 풀이
for _ in range(m):
    if count == k:
        result += array[1]
        count = 0
    else:
        result += array[0]
        count += 1
print(result)

# 수열 풀이
count = int(m/ (k+1)) * k
count += m % (k+1)

result += count * array[0]
result += (m-count) * array[1]
print(result)
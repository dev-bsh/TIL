n, k = map(int, input().split())

# 1단계씩 반복
# count = 0
# while n > 1:
#     if n % k == 0:
#         n = int(n/k)
#     else:
#         n -= 1
#     count += 1
# print(count)

# 더 빠른 풀이
count = 0
while n > 1:
    if n < k:
        count += n - 1
        break
    if n % k == 0:
        n = int(n/k)
        count += 1
    else:
        diff = n%k
        n -= diff
        count += diff
print(count)
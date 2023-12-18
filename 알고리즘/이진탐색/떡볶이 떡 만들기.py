n, m = map(int, input().split())
array = list(map(int, input().split()))
start, end = 0, max(array)
result = 0
while start <= end:
    mid = (start+end) // 2
    total = 0
    for i in array:
        if mid < i:
            total += i - mid
    if total < m:
        end = mid - 1
    else:
        start = mid + 1
        result = mid
print(result)
            
n = int(input())
array = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))

# SET 풀이
totalSet = set(array)
for i in target:
    if i in totalSet:
        print('yes')
    else:
        print('no')

# 계수정렬 풀이
totalArray = [0] * 1000001
for i in array:
    totalArray[i] += 1
for i in target:
    if totalArray[i] >= 1:
        print('yes')
    else:
        print('no')

# 이진탐색 풀이
array.sort()
def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start+end) // 2

        if array[mid] == target:
            return mid
        elif target < array[mid]:
            end = mid - 1
        elif target > array[mid]:
            start = mid + 1
    
    return None

for i in target:
    if binarySearch(array, i, 0, n-1) == None:
        print('no', end=' ')
    else:
        print('yes', end=' ')
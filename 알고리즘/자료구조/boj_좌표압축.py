import sys
input = sys.stdin.readline
n = int(input())
numbers = list(map(int, input().split()))
arr = sorted(set(numbers))
num_dict = {}
for i in range(len(arr)):
    num_dict[arr[i]] = i

for num in numbers:
    print(num_dict[num], end=' ')
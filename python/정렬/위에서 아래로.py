n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))
    
list.sort(array, reverse=True)

for i in array:
    print(i, end=' ')
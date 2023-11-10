n,m = map(int, input().split())
array = [[0] * m for _ in range(n)]

for i in range(n):
    array[i] = list(map(int, input().split()))

result = 0
for i in range(n):
    # min||max (iterable)
    minV = min(array[i])
    # min||max (arg1, arg2)
    result = max(minV, result)
print(result)
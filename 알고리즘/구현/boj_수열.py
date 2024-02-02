import sys
input = sys.stdin.readline
n, k = map(int, input().rstrip().split())
temperature = list(map(int, input().rstrip().split()))
tempSum = [0] * n
for i in range(n):
    if i == 0:
        tempSum[i] = temperature[i]
    else:
        tempSum[i] = tempSum[i-1] + temperature[i]
    
answer = tempSum[k-1]
for i in range(k, n):
    answer = max(answer, tempSum[i] - tempSum[i-k])
    
print(answer)
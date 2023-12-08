import sys
input = sys.stdin.readline
tc = int(input())
result = []

for _ in range(tc):
    n = int(input())
    numbers = []
    isPossible = True

    for i in range(n):
        numbers.append(input().rstrip())
    numbers.sort()

    for i in range(len(numbers)-1):
        if numbers[i] == numbers[i+1][:len(numbers[i])]:
            isPossible = False
            break

    result.append(isPossible)

for r in result:
    print("YES" if r else "NO")

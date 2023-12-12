import sys
input = sys.stdin.readline
n = int(input())
target = []
for _ in range(n):
    target.append(int(input()))

stack = []
answer = []
now_n = 1
isPossible = True
for num in target:
    while now_n <= num:
        stack.append(now_n)
        answer.append('+')
        now_n += 1

    if stack[-1] == num:
        stack.pop()
        answer.append('-')
    else:
        isPossible = False
        break

if not isPossible:
    print("NO")
else:
    for a in answer:
        print(a)    

import sys
input = sys.stdin.readline
tc = int(input())

stack = []

for _ in range(tc):
    cmd = input().rstrip()
    if 'push' in cmd:
        stack.append(cmd.split()[1])
    elif 'top' == cmd:
        print(stack[-1] if stack else -1)
    elif 'size' == cmd:
        print(len(stack))
    elif 'empty' == cmd:
        print(0 if stack else 1)
    elif 'pop' == cmd:
        print(-1 if not stack else stack.pop())
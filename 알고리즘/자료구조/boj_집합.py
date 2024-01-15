import sys
input = sys.stdin.readline
n = int(input())
arr = [i for i in range(1, 21)]
S = set()
for _ in range(n):
    cmd = input().rstrip()
    x = int(cmd.split()[1]) if ' ' in cmd else None
    if 'add' in cmd:
        S.add(x)
    elif 'remove' in cmd:
        if x in S:
            S.remove(x)
    elif 'check' in cmd:
        print(1 if x in S else 0)
    elif 'toggle' in cmd:
        if x in S:
            S.remove(x)
        else:
            S.add(x)
    elif cmd == 'all':
        S = set(arr)
    elif cmd == 'empty':
        S = set()
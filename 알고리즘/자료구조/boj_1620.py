import sys
input = sys.stdin.readline
n, m = map(int, input().split())
pokeDict = {}
pokeList = [''] * (n+1)

for i in range(1, n+1):
    name = input().rstrip()
    pokeList[i] = name
    pokeDict[name] = i

for _ in range(m):
    target = input().rstrip()
    if target.isdigit():
        print(pokeList[int(target)])
    else:
        print(pokeDict.get(target))
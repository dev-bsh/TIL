target = input()
if '0' not in target:
    print(-1)
else:
    total = 0
    for num in target:
        total += int(num)
    arr = sorted(list(target), reverse=True)
    print(''.join(arr) if total % 3 == 0 else -1)

s = input()
arr = list(map(int, s))
total = sum(arr)
count = 1
if int(s) > 10:
    while total > 9:
        s = str(total)
        arr = list(map(int, s))
        total = sum(arr)
        count += 1
else:
    count = 0
    total = int(s)

print(count)
print("YES" if total % 3 == 0 else "NO")

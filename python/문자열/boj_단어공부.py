from collections import Counter
s = input().upper()
count = Counter(s)

if len(count) < 2:
    print(count.most_common(1)[0][0])
else:
    target = count.most_common(2)
    if target[0][1] == target[1][1]:
        print("?")
    else:
        print(target[0][0])
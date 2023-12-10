from collections import Counter
s = input()
data = Counter(s)
words = sorted(list(data))
left = ''
right = ''
for w in words:
    count = data[w]
    if count >= 2:
        left += w * (count // 2)
        right += w * (count // 2)
        data[w] %= 2

cnt = 0
for w in words:
    if data[w] > 0:
        left += w
        cnt += 1

answer = left + right[::-1]
print(answer if cnt < 2 else "I'm Sorry Hansoo")

    
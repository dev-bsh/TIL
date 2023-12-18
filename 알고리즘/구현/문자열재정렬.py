total = input()
sum = 0
alpha = ''
for ch in total:
    if ch.isdigit():
        sum += int(ch)
    else:
        alpha += ch

arr = sorted(alpha)
result = ''.join(arr) + str(sum)

print(result)
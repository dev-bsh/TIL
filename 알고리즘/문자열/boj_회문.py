tc = int(input())
target = []
answer = []
for _ in range(tc):
    target.append(input())

for t in target:
    # 팰린드롬 체크
    if t == t[::-1]:
        answer.append(0)
        continue
    mid = len(t) // 2
    # 유사 팰린드롬 체크
    for i in range(mid):
        if t[i] != t[len(t)-1-i]:
            left = t[:i] + t[i+1:]
            right = t[:len(t)-1-i] + t[len(t)-i:]
            if left == left[::-1] or right == right[::-1]:
                answer.append(1)
            else:
                answer.append(2)
            break
for a in answer:
    print(a)
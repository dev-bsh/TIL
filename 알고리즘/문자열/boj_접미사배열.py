S = input()
answer = []

for i in range(len(S)):
    answer.append(S[i:])
answer.sort()

for a in answer:
    print(a)

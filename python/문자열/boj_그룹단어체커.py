def checkGroupWord(word):
    isGroup = True
    for i in range(len(word)):
        diff = False
        for j in range(i+1, len(word)):
            if word[i] != word[j]:
                diff = True
            elif diff and word[i] == word[j]:
                isGroup = False
                break
    return isGroup

n = int(input())
words = []
for _ in range(n):
    words.append(input())

answer = 0
for word in words:
    if checkGroupWord(word):
        answer += 1
print(answer)




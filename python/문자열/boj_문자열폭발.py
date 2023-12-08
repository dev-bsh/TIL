word = input()
bomb = input()

stack = []
for w in word:
    stack.append(w)
    if ''.join(stack[-len(bomb):]) == bomb:
        for _ in range(len(bomb)):
            stack.pop()

answer = ''.join(stack)
print(answer if answer != '' else "FRULA")
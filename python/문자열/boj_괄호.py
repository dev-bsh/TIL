n = int(input())
words = []
for _ in range(n):
    words.append(input())
    
for s in words:
    stack = []
    isVPS = True
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        elif s[i] == ')':
            if len(stack) == 0 or stack.pop() == ')':
                isVPS = False
                break
    if len(stack) > 0:
        isVPS = False
    print("YES" if isVPS else "NO")
    
s = input()
shortStr = s[0]
idx = 0
for ch in s:
    if shortStr[idx] != ch:
        shortStr += ch
        idx += 1
    
print(min(shortStr.count('0'), shortStr.count('1')))
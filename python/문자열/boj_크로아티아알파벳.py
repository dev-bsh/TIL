target = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
answer = len(target)

for c in croatia:
    if c in target:
        answer -= target.count(c)

print(answer)
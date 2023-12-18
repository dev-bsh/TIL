from collections import deque
n = int(input())
q = [i for i in range(1, n+1)]
q = deque(q)

while len(q) > 1:
    q.popleft()
    n = q.popleft()
    q.append(n)
    
print(q[0])

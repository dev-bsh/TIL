exp = input()
operator = []
answer = ''
for e in exp:
    # 문자면 그대로 추가
    if e.isalpha():
        answer += e
    # 여는 괄호면 연산자 stack에 추가
    elif e == '(':
        operator.append(e)
    # 연산 중 *, / 가 나오면 이전에 나온 *, /만 먼저 처리해준다(같은 우선순위)
    # +,-는 연산 후순위이기 때문에 빼지않음
    elif e == '*' or e == '/':
        while operator and (operator[-1] == '*' or operator[-1] == '/'):
            answer += operator.pop()
        operator.append(e)
    # +, -가 나오면 여는 괄호 이전까지(같은 연산 우선순위인 연산자들만)만
    # 스택에서 빼서 처리해준다.
    elif e == '+' or e == '-':
        while operator and operator[-1] != '(':
            answer += operator.pop()
        operator.append(e)
    # 닫는 괄호면 여는 괄호까지 연산자 전부 pop (같은 우선순위)
    elif e == ')':
        while operator and operator[-1] != '(':
            answer += operator.pop()
        # '(' 제거
        operator.pop()
# 남은 연산자 추가
while operator:
    answer += operator.pop()
print(answer)

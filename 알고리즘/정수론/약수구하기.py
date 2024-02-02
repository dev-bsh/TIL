n = int(input())

for i in range(1, int(n ** 0.5) + 1):
    if n % i == 0:
        print(i)
        if i * i != n: # 제곱수 처리
            print(n//i)

# 탐색 조건을 제곱근 범위로 줄이기
# 해당 범위로 소수판정 빠르게 가능        
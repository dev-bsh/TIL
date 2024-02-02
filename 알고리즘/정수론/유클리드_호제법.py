a, b = map(int, input().split())

A, B = a, b
while a % b != 0:
    a, b = b, a % b

print(b) # 최대공약수
print(A * B // b) # 최소공배수


# a > b 일때 최대공약수 = gcd(a, b)
# 약수 k 일때 a = kx, b = ky
# a-b = k(x-y) -> a-b 도 k의 약수
# gcd(a, b) = gcd(a-b, b)
# gcd(a, b) = gcd(a-2b, b) = gcd(a-3b, b) ...
# gcd(a, b) = gcd(a % b, b)
# 이때 a%b < b 이므로 gcd(b, a%b)
# gcd(b, a%b) = gcd(b % (a%b), a%b) 이므로
# a가 b의 배수가 될 때 까지 a%b 연산을 통해 공약수를 구할 수 있다.


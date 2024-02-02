
a = 10
b = 15
c = 3

print((a+b) % c == (a%c + b%c) % c)
print((a*b) % c == (a%c * b%c) % c)

#음수가 되면 +c를 해줘야함.
print((a-b) % c == (a%c - b%c + c) % c)

#페르마소 정리, 수학적으로는 가능. 코딩에선 안됨.
print((a+b) % c == (a//c - b//c) % c)
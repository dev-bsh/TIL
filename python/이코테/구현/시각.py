# 최대 86400번 탐색 -> 완전탐색 유형 (탐색 데이터가 100만개 이하에서 사용하면 적절)
# 숫자 -> 문자로 변환하여 비교
maxH = int(input())
result = 0
for h in range(maxH + 1):
    for m in range(60):
        for s in range(60):
            if '3' in str(h) + str(m) + str(s):
                result += 1
print(result)
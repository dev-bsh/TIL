def solution(s):
    mid = len(s) // 2
    result = len(s)

    # 압축 길이
    for i in range(1, mid+1):
        total = ''
        base = s[:i]
        cnt = 1

        # 문자열 압축
        for j in range(i, len(s), i):
            target = s[j:j+i]
            if base != target:
                compressedWord = str(cnt) + base if cnt > 1 else base
                total += compressedWord
                base = target
                cnt = 1
            else:
                cnt += 1
        # 남은 문자열 추가
        total += str(cnt) + base if cnt > 1 else base
        result = min(result, len(total))
    return result
n, r, c = map(int, input().split())
cnt = 0

def find(i, j, n):
    global cnt
    half = n//2

    if i == r and j == c:
        print(cnt)
        return
    
    # 좌표가 현재 사분면 안에 있는 경우만 탐색
    if r < i+n and r >= i and c < j+n and c >= j:
        find(i, j, half)
        find(i, j+half, half)
        find(i+half, j, half)
        find(i+half, j+half, half)
    # 없으면 사이즈만큼 추가
    else:
        cnt += n*n

find(0, 0, 2**n)
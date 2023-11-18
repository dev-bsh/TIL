def solution(key, lock):
    answer = False
    lockSize = len(lock)
    keySize = len(key)

    # 자물쇠 범위 확장
    totalMap = [[0] * lockSize * 3 for _ in range(lockSize * 3)]
    for i in range(lockSize, lockSize * 2):
        for j in range(lockSize, lockSize * 2):
            totalMap[i][j] = lock[i-lockSize][j-lockSize]

    # 완전탐색
    for _ in range(4):
        for i in range(lockSize * 3):
            for j in range(lockSize * 3):
                tempMap = [i.copy() for i in totalMap]

                for a in range(keySize):
                    for b in range(keySize):
                        if i+a >= lockSize * 3 or j+b >= lockSize * 3:
                            continue
                        else:
                            tempMap[i+a][j+b] += key[a][b]                

                if checkOpenLock(tempMap):
                    answer = True
                    break
        if answer:
            break
        key = rotationArray(key)

    return answer

def rotationArray(arr):
    n = len(arr)
    rotaArr = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            rotaArr[j][n-1-i] = arr[i][j]
    return rotaArr

def checkOpenLock(totalMap):
    isMatch = True
    n = len(totalMap) // 3
    for i in range(n, n+n):
        for j in range(n, n+n):
            if totalMap[i][j] != 1:
                isMatch = False
    return isMatch
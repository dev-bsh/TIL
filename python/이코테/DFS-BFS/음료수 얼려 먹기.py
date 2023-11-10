def main():
    n,m = map(int, input().split())
    ice = [[0] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        ice[i] = list(map(int, input()))

    result = 0
    for i in range(n):
        for j in range(m):
            if ice[i][j] == 0 and not visited[i][j]:
                if dfs(ice, i, j, visited):
                    result += 1
    print(result)

def dfs(ice, i, j, visited):
    if i < 0 or i >= len(ice) or j < 0 or j >= len(ice[0]) or visited[i][j] or ice[i][j] == 1:
        return False
    
    visited[i][j] = True

    dfs(ice, i-1, j, visited)
    dfs(ice, i+1, j, visited)
    dfs(ice, i, j-1, visited)
    dfs(ice, i, j+1, visited)

    return True

main()
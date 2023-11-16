import heapq
def solution(food_times, k):
    totalTime = 0
    totalFoodCnt = len(food_times)
    q = []
    for i in range(totalFoodCnt):
        totalTime += food_times[i]
        heapq.heappush(q, (food_times[i], i+1))
    
    if k >= totalTime:
        return -1
    else:
        now = 0
        while q:
            minFood, idx = heapq.heappop(q)
            if (minFood - now) * totalFoodCnt <= k:
                k -= (minFood - now) * totalFoodCnt
                totalFoodCnt -= 1
                now = minFood
            else:
                heapq.heappush(q, (minFood, idx))
                break
        leftFoods = sorted(q, key= lambda x : x[1])
        answer = leftFoods[k % totalFoodCnt][1]
    return answer

print(solution([3,1,1], 4))
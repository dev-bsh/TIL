package com.company;

import java.util.*;

public class Back_2108 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        double sum = 0;
        int median, mode, range;
        double average;
        HashMap<Integer,Integer> modes = new HashMap<>();

        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            // 평균 구하기 위한 합계(sum과 average와 같은 double로 선언하는게 중요)
            sum += nums[i];
            // 최빈값을 구하기 위해 각 숫자의 빈도를 hashMap으로 저장
            if(modes.containsKey(nums[i])){
                modes.put(nums[i],modes.get(nums[i])+1);
            }
            else{
                modes.put(nums[i],1);
            }
        }
        // 중앙값, 범위를 구하기 위한 정렬
        Arrays.sort(nums);

        int modeCount = 1;
        int tmpCount = 1;
        // 최대 빈도 구하기
        for(int i=1; i<N; i++){
            if(nums[i] == nums[i-1]){
                tmpCount++;
                if(i == N-1 && tmpCount>=modeCount){
                    modeCount = tmpCount;
                }
            }
            else{
                if(tmpCount>=modeCount){
                    modeCount = tmpCount;
                }
                tmpCount = 1;
            }
        }

        // 최대 빈도와 일치하는 value를 가진 key 값 추출
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer key : modes.keySet()){
            Integer value = modes.get(key);
            if(value == modeCount){
                pq.add(key);
            }
        }

        if(pq.size()>1){
            pq.poll();
            mode = pq.poll();
        }
        else{
            mode = pq.poll();
        }
        average = Math.round(sum/N);
        median = nums[N/2];
        range = nums[N-1] - nums[0];
        int avg = (int)average;

        System.out.println(avg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);

    }
}

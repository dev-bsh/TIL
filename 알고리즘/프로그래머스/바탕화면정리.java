package 프로그래머스;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {

        int minX = wallpaper.length;
        int minY = wallpaper[0].length();
        int maxX = 0;
        int maxY = 0;

        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[0].length(); y++) {
                if (wallpaper[x].charAt(y) == '#') {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x+1);
                    maxY = Math.max(maxY, y+1);
                }
            }
        }
        int[] answer = {minX, minY, maxX, maxY};
        return answer;
    }
}

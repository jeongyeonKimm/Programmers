class Solution {
    private static final int[] dx = {1, 0, -1};
    private static final int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        
        while(true) {
            triangle[x][y] = value++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[nx][ny] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[nx][ny] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }
        
        int[] answer = new int[value - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}

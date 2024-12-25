package level2;

public class 행렬테두리회전하기 {
    int[][] matrix;

    int swap(int x, int y, int z, int w) { // And return min value
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[z][w];
        matrix[z][w] = tmp;
        return Integer.min(matrix[x][y], matrix[z][w]);
    }

    int cycle(int[] query) {
        int min = 10001;

        int startX = query[0] - 1;
        int startY = query[1] - 1;
        int endX = query[2] - 1;
        int endY = query[3] - 1;

        for (int i = startX; i < endX; ++i)
            min = Integer.min(min, swap(i, startY, i + 1, startY));
        for (int i = startY; i < endY; ++i)
            min = Integer.min(min, swap(endX, i, endX, i + 1));
        for (int i = endX; i > startX; --i)
            min = Integer.min(min, swap(i, endY, i - 1, endY));
        for (int i = endY; i > startY + 1; --i)
            min = Integer.min(min, swap(startX, i, startX, i - 1));

        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        matrix = new int[rows][columns];
        int num = 0;
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                matrix[i][j] = ++num;

        for (int i = 0; i < answer.length; ++i)
            answer[i] = cycle(queries[i]);

        return answer;
    }
}

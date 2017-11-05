import java.util.*;

/**
 * Created by TaeHwan
 * 2017. 10. 31. PM 12:12
 */
public class MineSweeper{

    private static class Mine{
        private int row;
        private int col;
        Mine(int row, int col){
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "Mine{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    // 지뢰
    private static Set<Mine> mines = new HashSet<>();

    private static int randomInteger(final int randomLength){
        return new Random().nextInt(randomLength);
    }

    // 지뢰설치
    private static void mineInit(final int row, final int col, final int bombQuantity){
        while (mines.size() < bombQuantity)
            mines.add(new Mine(randomInteger(row), randomInteger(col)));
    }

    // 맵세팅
    private static void mapInit(final int row, final int col){
        boolean[][] map = new boolean[row][col];

        for(Mine mine : mines)
            map[mine.row][mine.col] = true;
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                if(map[rowIndex][colIndex])
                    System.out.print("*");
                else{
                    int currentNumber = 0;

                    if (0 < rowIndex)
                        if(map[rowIndex-1][colIndex])
                            currentNumber += 1;
                    if (rowIndex+1 < row)
                        if(map[rowIndex+1][colIndex])
                            currentNumber += 1;
                    if (0 < rowIndex & colIndex+1 < row)
                        if(map[rowIndex-1][colIndex+1])
                            currentNumber += 1;
                    if (0 < rowIndex & 0 < colIndex)
                        if(map[rowIndex-1][colIndex-1])
                            currentNumber += 1;
                    if (0 < colIndex)
                        if(map[rowIndex][colIndex-1])
                            currentNumber += 1;
                    if (colIndex+1 < col)
                        if(map[rowIndex][colIndex+1])
                            currentNumber += 1;
                    if (rowIndex+1 < row & colIndex+1 < col)
                        if(map[rowIndex+1][colIndex+1])
                            currentNumber += 1;
                    if (rowIndex+1 < row & 0 < colIndex)
                        if(map[rowIndex+1][colIndex-1])
                            currentNumber += 1;

                    System.out.print(currentNumber);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        final int row = 10;
        final int col = 10;
        final int bombs = 10;
        mineInit(row, col, bombs);
        mapInit(row, col);
    }
}

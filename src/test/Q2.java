package test;

import java.util.Arrays;

public class Q2 {
    public int[] solution(int rows, int columns, int[][] swipes) {
        // write your code in Java SE 8
        int[] answer = new int[swipes.length];

        // 배열 초기화
        int[][] sources = new int[rows][columns];
        int[][] dumps = new int[rows][columns];
        for ( int i = rows - 1; i >= 0; i-- ) {
            for ( int j = columns - 1; j >= 0; j-- ) {
                sources[i][j] = (i) * columns + j + 1;
                dumps[i][j] = (i) * columns + j + 1;
            }
        }

        // 영역 지정
        for ( int i = rows - 1; i >= 0; i-- ) {
            for ( int j = columns - 1; j >= 0; j-- )
                sources[i][j] = (i) * columns + j + 1;
        }

        int index = 0;
        for ( int[] swipe : swipes ) {
            answer[index] = goSwipe( swipe, sources, dumps );
            for ( int i = rows - 1; i >= 0; i-- )
                System.arraycopy( dumps[i], 0, sources[i], 0, dumps[i].length );
            index++;
        }

        System.out.println( Arrays.toString( answer ) );
        return answer;
    }

    private int goSwipe(int[] swipe, int[][] sources, int[][] dumps) {
        int r1 = swipe[1] - 1, c1 = swipe[2] - 1, r2 = swipe[3] - 1, c2 = swipe[4] - 1;
        int result = 0;

        for ( int i = r2; i >= r1; i-- ) {
            for ( int j = c2; j >= c1; j-- ) {
                // 스와이프 방향 지정
                int[] vector = drivenVector( swipe[0] );
                int indexI = i + vector[0], indexJ = j + vector[1];

                boolean flag = false;
                if ( indexI >= r1 ) {
                    if ( indexI > r2 ) {
                        indexI = r1;
                        flag = true;
                    }
                } else {
                    indexI = r2;
                    flag = true;
                }
                if ( indexJ >= c1 ) {
                    if ( indexJ > c2 ) {
                        indexJ = c1;
                        flag = true;
                    }
                } else {
                    indexJ = c2;
                    flag = true;
                }

                System.out.println( indexI + " / " + indexJ );

                int temp = sources[indexI][indexJ];
                dumps[i][j] = temp;
                if ( flag ) result += sources[indexI][indexJ];
            }
        }

        System.out.println( Arrays.deepToString( dumps ) );
        return result;
    }

    private int[] drivenVector(int i) {
        int[] vector = {};

        switch ( i ) {
            case 1:
                vector = new int[]{-1, 0};
                break;
            case 2:
                vector = new int[]{1, 0};
                break;
            case 3:
                vector = new int[]{0, -1};
                break;
            case 4:
                vector = new int[]{0, 1};
                break;
        }
        return vector;
    }
}

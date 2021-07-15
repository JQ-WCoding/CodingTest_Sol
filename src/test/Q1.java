package test;

public class Q1 {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        int answer = -1;
        long money2 = money;

        for ( int j = 0; j < months; j++ ) {
            // 100의 자리 버림
            long checkMoney = ( long ) (Math.floor( money2 / 100 ) * 100);

            if ( threshold <= checkMoney ) {
                for ( int i = 0; minratio + i <= maxratio; i++ ) {
                    if ( threshold + (i * ranksize) <= checkMoney && checkMoney < threshold + ((i + 1) * ranksize) - 1 ) {
                        money2 = (money2 - ((checkMoney * (minratio + i)) / 100));
                        break;
                    } else if ( minratio + i == maxratio ) {
                        money2 = (money2 - ((checkMoney * maxratio) / 100));
                        break;
                    }
                }
            } else {
                answer = ( int ) money2;
                break;
            }
        }

        answer = ( int ) money2;

        return answer;
    }
}

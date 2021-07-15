package test;

public class main {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println( q1.solution( 1000000000, 50, 99, 100000, 0, 6 ) );
        System.out.println( q1.solution( 12345678, 10, 20, 250000, 10000000, 4 ) );


        Q3 q3 = new Q3();
        System.out.println( q3.solution( "abcabcabc", "abc" ) );
    }
}

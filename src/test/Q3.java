package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q3 {
    public int solution(String line1, String line2) {
        // write your code in Java SE 8
        int result = 0;

        int index = 0;
        while ( true ) {
            StringBuilder temp = new StringBuilder();
            StringBuilder temp2 = new StringBuilder();
            for ( int i = 0; i < line2.length(); i++ ) {
                temp.append( line2.charAt( i ) );
                temp2.append( line2.charAt( i ) );
                if ( i < line2.length() - 1 ) {
                    temp.append( ".{" ).append( index ).append( "}" );
                    for ( int j = 0; j < index; j++ )
                        temp2.append( "_" );
                }
            }
            if ( temp2.length() > line1.length() ) break;

            String regex = temp.toString();
            System.out.println( regex );
            System.out.println( temp2 );

            Pattern pattern = Pattern.compile( regex );
            Matcher matcher = pattern.matcher( line1 );

            int count = 0;
            int i = 0;
            while ( matcher.find( i ) ) {
                count++;
                i = matcher.start() + 1;
            }
            result += count;
            System.out.println( result );

            index++;
        }

        return result;
    }
}

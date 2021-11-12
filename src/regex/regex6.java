package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class regex6 {
    public static void main(String[] args) {
        String myString =
                "12345678912345670325987;"+
                "15633214789654125235614";
        //03/25 1234 5678 9123 4567  (987) - б/к
        Pattern pattern =
       Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})" +
               "(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(myString);
        //группы это выражение взятые в круглые скобки
        //отсчет идет от 1.
//        String myNewString =
//                matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
//        System.out.println(myNewString);
        while (matcher.find()){
            //так же в группе можно вывести
            System.out.println(matcher.group(7));
        }

    }
}
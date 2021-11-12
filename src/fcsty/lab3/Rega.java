package fcsty.lab3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Паша Яковлев😎😜🧠, [05.11.2021 20:51]
//        Создайте программу и метод, который возвращает true, если две строки имеют один и тот
//        же буквенный шаблон, и false в противном случае.
//        Пример:
//        sameLetterPattern("ABAB", "CDCD") ➞ true
//        sameLetterPattern("ABCBA", "BCDCB") ➞ true
//        sameLetterPattern("FFGG", "CDCD") ➞ false
//        sameLetterPattern("FFFF", "ABCD") ➞ false
public class Rega {
    public static void main(String[] args) {
        sameLetterPattern("ABAB", "CDCD");
        sameLetterPattern("ABCBA", "BCDCB");
        sameLetterPattern("FFGG", "CDCD");
        sameLetterPattern("FFFF", "ABCD");
    }

    public static boolean sameLetterPattern(String s1, String s2) {
        Pattern pattern = Pattern.compile("[A-D]+");
        Matcher matcher1 = pattern.matcher(s1);
        Matcher matcher2 = pattern.matcher(s2);
        if (matcher1.find() == matcher2.find()) {
            System.out.println("{"+s1+" " +s2+ "}"+"->"+"true");
            return true;
        }
        System.out.println("{"+s1+" " +s2+ "}"+"->"+"false");
        return false;

    }
}


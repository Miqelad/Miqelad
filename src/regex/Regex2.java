package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Демонстрация, как работают разные символы и метасимволы
 */
public class Regex2 {
    public static void main(String[] args) {
        String s1 = "58asdad45";
        //Любые цифры,{количество подряд повторений}
        Pattern pattern1 = Pattern.compile("\\d{2}");
        //out 0 58
        //7 45
        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group());
        }

    }
}

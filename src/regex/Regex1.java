package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Работа с текстом, будем тут искать информацию
 */
public class Regex1 {
    public static void main(String[] args) {
       String s =
"Ivanov Vlad, Russia, Moscow, Lenin street, 51, Flat 48, "+
"email: vlad@mail.ru, Postcode: aa99, Phone Number: +78541256898"+
"Ivanova Vladsa, Russia, Bronitsy, MOyakkovskaya street, 52, Flat 11, "+
"email: vladsa@gmail.com, Postcode: b99, Phone Number: +71239632574";
       //Нашего число состоит из  двух цифр, слева и справа ничего нет
        //aa99 - не подходит
        Pattern pattern = Pattern.compile("\\b\\d{2}\\b");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }
}

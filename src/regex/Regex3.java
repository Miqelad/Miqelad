package regex;

import java.util.Arrays;

public class Regex3 {
    public static void main(String[] args) {
        String s =
                "Ivanov Vlad, Russia, Moscow, Lenin street, 51, Flat 48, "+
                        "email: vlad@mail.ru, Postcode: aa99, Phone Number: +78541256898"+
                        "Ivanova Vladsa, Russia, Bronitsy, MOyakkovskaya street, 52, Flat 11, "+
                        "email: vladsa@gmail.com, Postcode: b99, Phone Number: +71239632574";

String s2 = "sa@gmail.com";
//Данный метод используем, когда нужна подтвердить одно соответсвие
boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");
        System.out.println(result);
        //Что будет выполнять роль разделителя, и засунется в массив
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
    }
}

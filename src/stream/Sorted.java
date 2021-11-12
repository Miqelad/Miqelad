package stream;

import java.util.Arrays;

//TODO: Пример на цепочку методов подряд
public class Sorted {
    public static void main(String[] args) {
        int [] array = {3,8,1,5,16,8,99,78};
        //Если при деление на 3, без остатка, дели на 3 и найти сумму
        //всеъ елементов,getAsInt вернет как инт
      int result= Arrays.stream(array).filter(e->e%2==1)
               .map(e->{if(e%3==0){ e/=3;}return e;})
               .reduce((a,e)->a+e).getAsInt();
        System.out.println(result);
    }}


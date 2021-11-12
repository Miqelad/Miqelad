package JavaProTeach.Functional;

import java.util.ArrayList;
import java.util.function.Predicate;

//TODO: or & and & negate
public class Method {
  public static void info (ArrayList<String> al,Predicate<String> pr){
        for(String s:al){
            if(pr.test(s)){
                System.out.print(s+",");

            }
        }

}
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<>();
        al.add("Hello");
        al.add("Bye");
        al.add("ok");
        Predicate<String> p = (String element)->{return element.length()<5;};
        Predicate<String> p1 = element->element.length()>0;
        //and это и то и то условие
        info(al,p1.and(p));//TODO:Bye,ok
        //хотябы по одной из фильтраций
        info(al,p.or(p1));//TODO:Hello,Bye,ok,
        //negate будет отрицать принцы проверики p1
        info(al,p1.negate());
    }
}

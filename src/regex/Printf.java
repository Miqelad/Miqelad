package regex;

public class Printf {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id=22;
        emp.name="Papa";
        emp.bonus=7777777.324324;
        //будет четыре знака, если нет то 0 заполним
        // , левые края 12 символов
        //1 после запятой
        System.out.printf("%04d \t %-12s \t %,.1f ",emp.id,emp.name,emp.bonus);
        //создастся красивый стринг по такому образу
        String s = String.format("%04d \t %-12s \t %,.1f ",emp.id,emp.name,emp.bonus);
    //0022 	 Papa         	 7 777 777,3
        String s1;
    }
}
class Employee{
    int id;
    String name;
    double bonus;

}

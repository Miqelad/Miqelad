package ref;

public class Employee {
    public int id;
    public String name;
    public String departament;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String departament, double salary) {
        this.id = id;
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Reflection7{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departament='" + departament + '\'' +
                ", salary=" + salary +
                '}';
    }

    private void changeDepartment(String newDepart) {
        departament = newDepart;
        System.out.println("New Department: " + newDepart);
    }

    public void increaseSalary() {
        salary *= 2;
    }
}


package JavaProTeach.Functional;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

//TODO:Consumer противоположность Supplier, он принимает параметры, тем самым можно изменять элементы
public class T3 {
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //Будем возвращать тот элемент, который нам поставляетс соплаер
            al.add(carSupplier.get());
        }
        return al;



    }
    public static void changeCar(Car car, Consumer<Car> carConsumer){
        carConsumer.accept(car);

    }


    public static void main(String[] args) {
        //ArrayList = методу, который возвращает АррэйЛист
        //метод get не принимает параметров, поэтому пустые скобки
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan", "brown", 1.6));
        //ПОЛНАЯ ЗАПИСЬ: //ArrayList<Car> ourCars = createThreeCars(()->{ Car c= new Car("Nissa12n", "bro32wn",1.16);return c1;});
        System.out.println("Cars:" + ourCars);
        //TODO:Cars:[Car{model='Nissan', color='brown', engine=1.6},Car{model='Nissan', color='brown', engine=1.6},Car{model='Nissan', color='brown', engine=1.6}]
        //т.е. мы изменили элементы через лямбду и метод accept  у consumer
        changeCar(ourCars.get(0),car->car.color="white");
        System.out.println(ourCars.get(0));//Car{model='Nissan', color='white', engine=1.6}
    }
}

class Car {
    String model;
    String color;
    double engine;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }
}

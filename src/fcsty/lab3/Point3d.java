package fcsty.lab3;

public class Point3d {
    // ** координата X **//
    private double xCoord;
    // ** координата Y **//
    private double yCoord;
    // ** координата Y **//
    private double zCoord;
    // ** Конструктор инициализации **//
    public Point3d ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord=z;
    }
    // ** Конструктор по умолчанию. **//
    public Point3d () {
////Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0,0);
    }
    // ** Возвращение координаты X **//
    public double getX () {
        return xCoord;
    }
    // ** Возвращение координаты Y **//
    public double getY () {
        return yCoord;
    }
    // ** Возвращение координаты Z **//
    public double getZ () {
        return yCoord;
    }
    // ** Установка значения координаты X. **//
    public void setX ( double val) {
        xCoord = val;
    }
    // ** Установка значения координаты Y. **//
    public void setY ( double val) {
        yCoord = val;

    }
    // ** Установка значения координаты Z. **//
    public void setZ ( double val) {
        zCoord = val;
}


//Метод сравнивания точек, если хоть 1 из точек равна по координатам с другой, то пишем повтор
    public static void equalsCor(Point3d o1,Point3d o2, Point3d o3){
        if (o1.getX()+o1.getY()+o1.getZ()==o2.getX()+o2.getY()+o2.getZ() || o2.getX()+o2.getY()+o2.getZ()==o3.getX()+o3.getY()+o3.getZ() ||
                o1.getX()+o1.getY()+o1.getZ()==o3.getX()+o3.getY()+o3.getZ()){
            System.out.println("You have bad coordinate, try again");
        }
    }
// метод для сравнения значений двух объектов Point3d
//Формула вычисления расстояния между двумя точками A(xa, ya, za) и B(xb, yb, zb) в пространстве:
//    AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2

    public static double distanceTO(Point3d o, Point3d o1){
       // форматирование
    return Math.sqrt(Math.pow(o1.getX()-o.getX(),2)+Math.pow(o1.getY()-o.getY(),2) +Math.pow(o1.getZ()-o.getZ(),2));
}





    }


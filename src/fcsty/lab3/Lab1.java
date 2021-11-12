package fcsty.lab3;

public class Lab1 {
    public static void main(String[] args) {
        Point3d p1 = new Point3d(1,2,3);
        Point3d p2 = new Point3d();
        Point3d p3 = new Point3d();
        Point3d.equalsCor(p1,p2,p3);
        System.out.println(computeArea(p1,p2,p3));


    }
    //Вычесление по формуле Герона
    public  static double computeArea (Point3d o1,Point3d o2, Point3d o3){
       //a b c стороны треугольника,
        double a = Point3d.distanceTO(o1,o2);
        double b = Point3d.distanceTO(o2,o3);
        double c = Point3d.distanceTO(o1,o3);
        double p = (a+b+c)/2;//полупериметр
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));//сама плозадь по формуле

    }
}

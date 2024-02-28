import java.util.Scanner;

abstract class Solid {
    abstract double getVolume();
}

class Pyramid extends Solid {
    private double a;
    private double h;

    public Pyramid(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    double getVolume() {
        return (a * a * h) / 3.0;
    }
}

class Cone extends Solid {
    private double r;
    private double h;

    public Cone(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    double getVolume() {
        return (Math.PI * r * r * h) / 3.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть довжину сторони основи піраміди: ");
        double pyramidBaseSide = scanner.nextDouble();
        System.out.print("Введіть висоту піраміди: ");
        double pyramidHeight = scanner.nextDouble();

        System.out.print("Введіть радіус основи конуса: ");
        double coneRadius = scanner.nextDouble();
        System.out.print("Введіть висоту конуса: ");
        double coneHeight = scanner.nextDouble();

        Solid pyramid = new Pyramid(pyramidBaseSide, pyramidHeight);
        Solid cone = new Cone(coneRadius, coneHeight);

        System.out.println("Об'єм піраміди: " + pyramid.getVolume());
        System.out.println("Об'єм конуса: " + cone.getVolume());
    }
}

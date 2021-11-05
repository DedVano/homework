package lesson2;

public class MathFormulas {

    public static void main(String[] args) {

        // Вычисление объема цилиндра
        double radius = 0.5; double height = 8;
        double volume = cylinderVolume(radius, height);
        if(volume != Double.NEGATIVE_INFINITY) System.out.printf("Объем цилиндра высотой %sм и радиусом %sм равен %s кубических метров\n", height, radius, volume);
        else System.out.printf("Объем цилиндра высотой %sм и радиусом %sм не может быть посчитан\n", height, radius);

        // Решение квадратного уравнения
        int a = 5; int b = 7; int c = 2;
        double[] squareRoots = quadraticEquation(a, b, c);
        if (squareRoots[0] != Double.POSITIVE_INFINITY) System.out.printf("Корни квадратного уравнения %dx^2 + %dx + %d = 0 равны %s и %s\n", a, b, c, squareRoots[0], squareRoots[1]);
        else System.out.printf("Квадратное уравнение %dx^2 + %dx + %d = 0 не имеет корней.", a, b, c);

    }

    public static double cylinderVolume(double radius, double height){
        if (radius >= 0 && height >= 0) return Math.PI * radius * radius * height;
        else  return Double.NEGATIVE_INFINITY;
    }

    public static double[] quadraticEquation(int a, int b, int c){
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (- b + Math.sqrt(d)) / 2 / a;
            double x2 = (- b - Math.sqrt(d)) / 2 / a;
            return new double[] {x1, x2};
        }
        else
            if (d == 0){
                double x = (double) -b / 2 / a;
                return new double[] {x, x};
            }
            else return new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
    }
}

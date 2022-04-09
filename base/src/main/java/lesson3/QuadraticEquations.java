package lesson3;

import java.util.Scanner;

public class QuadraticEquations {

    public static void main(String[] args) {

        // Решение квадратного уравнения
        Scanner incomingParameter = new Scanner(System.in);

        System.out.println("Давайте решим квадратное уравнение вида ax^2 + bx + c = 0.");
        System.out.print("Для начала введите коэффициент 'a': ");
        int a = incomingParameter.nextInt();
        System.out.print("Отлично! А теперь введите коэффициент 'b': ");
        int b = incomingParameter.nextInt();
        System.out.print("Супер! Ну и напоследок коэффициент 'c': ");
        int c = incomingParameter.nextInt();
        quadraticEquation(a, b, c);

        if (QuadEquationResults.aIsZero) {
            System.out.println("Никак не получается что-то вычислить для получившегося уравнения, поскольку Вы ввели " +
                    "коэффициент 'а', равный нулю.");
        } else if (QuadEquationResults.numberOfRoots == 0) {
            System.out.printf("У квадратного уравнения %dx^2 + %dx + %d = 0 отсутствуют действительные решения.\n",
                    a, b, c);
        } else if (QuadEquationResults.numberOfRoots == 1) {
            System.out.printf("У квадратного уравнения %dx^2 + %dx + %d = 0 существует один действительный корень, " +
                    "равный %s\n", a, b, c, QuadEquationResults.root1);
        } else {
            System.out.printf("Корни квадратного уравнения %dx^2 + %dx + %d = 0 равны %s и %s\n", a, b, c,
                    QuadEquationResults.root1, QuadEquationResults.root2);
        }
    }


    /**
     * Метод предназначен для решения квадратных уравнений вида ax^2 + bx + c = 0. <br>
     * В качестве аргументов принимаются целочисленные коэффициенты a, b и c.
     * Для возврата параметров получившегося уравнения используется созданный класс QuadEquationResults,
     * в который входят переменные: <br>
     * boolean aIsZero - "истина" если коэффициент 'a' равен нулю, "ложь", если нет <br>
     * int numberOfRoots - количество корней уравнения <br>
     * double root1 - значение первого корня, значение корня в случае, если корень один <br>
     * double root2 - значение второго корня в случае, если корней два.
     *
     * @param a - коэффициент 'a'
     * @param b - коэффициент 'b'
     * @param c - коэффициент 'c'
     */
    public static void quadraticEquation(int a, int b, int c) {
        if (a == 0) {
            QuadEquationResults.aIsZero = true;
        } else {
            double d = b * b - 4 * a * c;
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / 2 / a;
                double x2 = (-b - Math.sqrt(d)) / 2 / a;
                QuadEquationResults.aIsZero = false;
                QuadEquationResults.numberOfRoots = 2;
                QuadEquationResults.root1 = x1;
                QuadEquationResults.root2 = x2;
            } else if (d == 0) {
                double x = (double) -b / 2 / a;
                QuadEquationResults.aIsZero = false;
                QuadEquationResults.numberOfRoots = 1;
                QuadEquationResults.root1 = x;
            } else {
                QuadEquationResults.aIsZero = false;
                QuadEquationResults.numberOfRoots = 0;
            }
        }

    }
}

/**
 * Класс предназначен для хранения параметров решения квадратного уравнения вида ax^2 + bx + c = 0. <br>
 * Переменные, входящие в класс: <br>
 * boolean aIsZero - "истина" если коэффициент 'a' равен нулю, "ложь", если нет <br>
 * int numberOfRoots - количество корней уравнения <br>
 * double root1 - значение первого корня, значение корня в случае, если корень один <br>
 * double root2 - значение второго корня в случае, если корней два.
 */
class QuadEquationResults {

    static boolean aIsZero;
    static int numberOfRoots;
    static double root1;
    static double root2;
}
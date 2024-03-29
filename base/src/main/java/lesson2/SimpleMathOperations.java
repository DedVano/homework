package lesson2;

public class SimpleMathOperations {

    public static void main(String[] args) {

        int arg1 = 18;
        int arg2 = 4;
        int arg3 = 0;

        int resultOfAddition = add(arg1, arg2);
        System.out.printf("%d плюс %d равно %d\n", arg1, arg2, resultOfAddition);
        int resultOfSubtraction = subtract(arg1, arg2);
        System.out.printf("%d минус %d равно %d\n", arg1, arg2, resultOfSubtraction);
        long resultOfMultiplication = multiply(arg1, arg2);
        System.out.printf("%d умножить на %d равно %d\n", arg1, arg2, resultOfMultiplication);

        double resultOfDivision1 = divide(arg1, arg2);
        if ((resultOfDivision1 != Double.POSITIVE_INFINITY) && (resultOfDivision1 != Double.NEGATIVE_INFINITY))
            System.out.printf("%d разделить на %d равно %s\n", arg1, arg2, resultOfDivision1);
        else
            System.out.printf("%d нельзя делить на %d. На 0 делить нельзя. По крайней мере, нам сейчас.\n", arg1, arg2);

        double resultOfDivision2 = divide(arg1, arg3);
        if ((resultOfDivision2 != Double.POSITIVE_INFINITY) && (resultOfDivision2 != Double.NEGATIVE_INFINITY))
            System.out.printf("%d разделить на %d равно %s \n", arg1, arg3, resultOfDivision2);
        else
            System.out.printf("%d нельзя делить на %d. На 0 делить нельзя. По крайней мере, нам сейчас.\n", arg1, arg3);

    }

    public static int add(int summand1, int summand2) {
        return summand1 + summand2;
    }

    public static int subtract(int reduced, int subtracted) {
        return reduced - subtracted;
    }

    /* В методе multiply возвращаемое значение принудительно приводится к типу long,
       поскольку изначально результат умножения имеет тип int (раз оба множителя типа int),
       и в случае получения числа, выходящего за пределы типа int, результат может быть потерян.
     */
    public static long multiply(int multiplier1, int multiplier2) {
        return (long) multiplier1 * multiplier2;
    }

    /* Для метода divide тип одного из аргументов, а также возвращаемый тип определен как double,
       поскольку, во-первых, результат деления может быть и не целочисленным, а во-вторых, тип int при
       делении на 0 приведет к исключению ArithmeticException, а тип с плавающей запятой, например, double,
       при делении на 0 к исключению не приведет, а вернет число Infinity, положительное или отрицательное,
       которое мы сможем отследить в результате метода и предусмотреть для него действия программы.
     */
    public static double divide(double divisible, int divisor) {
        return divisible / divisor;
    }
}
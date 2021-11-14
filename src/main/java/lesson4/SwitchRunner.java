package lesson4;

public class SwitchRunner {
    public static void main(String[] args) {
        System.out.println(getSolutionOfSvetofor("желтый"));
        System.out.println(getSolutionOfSvetofor("зеленый"));
        System.out.println(getSolutionOfSvetofor("красный"));
        System.out.println(getSolutionOfSvetofor("брбрбр"));

    }

    public static String getSolutionOfSvetofor(String color) {
        String result;
        switch (color) {
            case "красный":
                result = "Проход запрещен";
                return result;
             // break; если нет return
            case "желтый":
                return "Будьте внимательны";
            case "зеленый":
                return "Проход разрешен";
            default:
                return "Ничего не понятно";
        }
    }
}

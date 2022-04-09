package lesson7;

public class HumanRunner {

    public static void main(String[] args) {
        Human me = new Human();
        me.name = "Ivan";
        me.surname = "Maltsev";
        me.age = 39;
        me.weight = 96;
        me.height = 187;
        me.hasQrCode = true;

        Human nataliaIvanovna = new Human();
        nataliaIvanovna.name = "Natalia";
        nataliaIvanovna.surname = "Petrova";
        nataliaIvanovna.age = 27;
        nataliaIvanovna.weight = 55;
        nataliaIvanovna.height = 165;
        nataliaIvanovna.hasQrCode = true;

        Human inkognito = new Human("Unknown", "Unknown", -1, -1, -1, null);
        Human vasyaPupkin = new Human("Vasiliy", "Pupkin", 50);

        System.out.println(me == vasyaPupkin);
        System.out.println(me == me);

        Human[] humans = new Human[] {me, nataliaIvanovna, inkognito, vasyaPupkin};
        for (Human human : humans) {
            if (Integer.valueOf(50).equals(human.age)) {
                System.out.println("Человек с именем " + human.name + " и фамилией " + human.surname + " имеет возраст 50");
            }
        }

        me.beOlder();
        System.out.println("Мне на след год исполнится " + me.age);
        me.vaccinated();
        System.out.println("Наличие кода " + me.hasQrCode);

    }
}

package lesson7;

public class Dog {
    String name;
    int age;
    boolean isAPet;
    int runDistance;
    int swimDistance;
    int countOfJumps;

    int canRunAtOneTime = 500;
    int canSwimAtOneTime = 10;
    int canJumpAtOneTime = 2;

    public Dog(String name, int age, boolean isAPet) {
        this.name = name;
        this.age = age;
        this.isAPet = isAPet;
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Dog(String name) {
        this.name = name;
    }
    public Dog(String name, int age, boolean isAPet, int runDistance, int swimDistance, int countOfJumps) {
        this.name = name;
        this.age = age;
        this.isAPet = isAPet;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.countOfJumps = countOfJumps;
    }

    public void beOlder() {
        this.age++;
    }
    public void beOlder(int howOlder) {
        this.age += howOlder;
    }
    public void run(int distance) {

    }
}

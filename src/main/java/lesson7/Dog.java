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
        System.out.printf("Собака по имени %s состарилась на год. Теперь её возраст %d лет.\n", this.name, this.age);
    }

    public void beOlder(int howOlder) {
        this.age += howOlder;
        System.out.printf("Собака по имени %s состарилась на %d лет. Теперь её возраст %d лет.\n", this.name, howOlder,
                this.age);
    }

    public void run(int distance) {
        if (distance > canRunAtOneTime) {
            this.runDistance += this.canRunAtOneTime;
            System.out.printf("Собаку по имени %s попросили пробежать %d метров, но она пробежала только %d, потому что" +
                    " дальше не умеет.\nВсего, таким образом, за свою жизнь она пробежала %d метров.\n", this.name,
                    distance, this.canRunAtOneTime, this.runDistance);
        } else {
            this.runDistance += distance;
            System.out.printf("Собака по имени %s пробежала %d метров, как её и попросили.\n" +
                    "Всего за свою жизнь она пробежала %d метров.\n", this.name, distance, this.runDistance);
        }
    }

    public void swim(int distance) {
        if (distance > canSwimAtOneTime) {
            this.swimDistance += this.canSwimAtOneTime;
            System.out.printf("Собаку по имени %s попросили проплыть %d метров, но она проплыла только %d, потому что" +
                            " дальше не умеет.\nВсего, таким образом, за свою жизнь она проплыла %d метров.\n", this.name,
                    distance, this.canSwimAtOneTime, this.swimDistance);
        } else {
            this.swimDistance += distance;
            System.out.printf("Собака по имени %s проплыла %d метров, как её и попросили.\n" +
                    "Всего за свою жизнь она проплыла %d метров.\n", this.name, distance, this.swimDistance);
        }
    }

    public void jump(int counts) {
        if (counts > canJumpAtOneTime) {
            this.countOfJumps += this.canJumpAtOneTime;
            System.out.printf("Собаку по имени %s попросили прыгнуть %d раз, но она прыгнула только %d, потому что" +
                            " больше не умеет.\nВсего, таким образом, за свою жизнь она прыгнула %d раз.\n", this.name,
                    counts, this.canJumpAtOneTime, this.countOfJumps);
        } else {
            this.countOfJumps += counts;
            System.out.printf("Собака по имени %s прыгнула %d раз, как её и попросили.\n" +
                    "Всего за свою жизнь она прыгнула %d раз.\n", this.name, counts, this.countOfJumps);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAPet() {
        return isAPet;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public int getCountOfJumps() {
        return countOfJumps;
    }

    public int getCanRunAtOneTime() {
        return canRunAtOneTime;
    }

    public int getCanSwimAtOneTime() {
        return canSwimAtOneTime;
    }

    public int getCanJumpAtOneTime() {
        return canJumpAtOneTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAPet(boolean APet) {
        isAPet = APet;
    }
}

package lesson21;

import lesson21.Calc.Calc;
import org.junit.*;

public class CalculatorTest {

    private Calc calculator;

    @BeforeClass // перед выполнением всего класса
    public static void init() {
        System.out.println("Начало выполнения тестов");
    }

    @AfterClass // после выполнения класса
    public static void destroy() {
        System.out.println("Завершение выполнения тестов");
    }

    @Before // перед каждым тестом
    public void initBeforeTest() {
        calculator = new Calc(27,3);
    }

    @After // после каждого теста
    public void DestroyAfterTest() {
        calculator = null;
    }

    @Test
    public void shouldCalculatorCanCalculateSumma() {
        Calc calc = new Calc(10, 15);
        Assert.assertEquals("Проверка выполнения суммы завершилась некорректно.",25, calc.summa());

        Calc calc2 = new Calc(-10, 15);
        Assert.assertEquals(5, calc2.summa());

        Calc calc3 = new Calc(0, 15);
        Assert.assertEquals(15, calc3.summa());

        Assert.assertEquals(30,calculator.summa());
    }

    @Test
    public void shouldCalculatorCanCalculateDivision() {
        Calc calc = new Calc(15, 3);
        Assert.assertEquals(5, calc.division());


        Calc calc3 = new Calc(49, 7);
        Assert.assertEquals(7, calc3.division());

        Assert.assertEquals(9, calculator.division());
    }

    @Test(expected = ArithmeticException.class, timeout = 1000)
    public void shouldCalculatorCanCalculateDivisionByZero() {
        Calc calc = new Calc(15, 0);
        calc.division();

        /*try {
            calc.division();
            Assert.fail();
        } catch (ArithmeticException e) {
            Assert.assertTrue(true);
        }*/
    }
}

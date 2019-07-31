import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    @org.junit.Test
    public void testSum1() {
        System.out.println("sum1 test");
        Integer x = 15;
        Integer y = 15;
        Integer expResult = 30;
        Integer result = Calculator.sum(x, y);
        assertEquals(expResult, result);
        assertEquals(null, Calculator.sum(15, null));
        assertEquals(null, Calculator.sum(null, 15));
        assertEquals(null, Calculator.sum(null, null));
    }
    @org.junit.Test
    public void testSum2() {
        System.out.println("sum2 test");
        Integer x = 25;
        Integer y = 15;
        Integer expResult = 30;
        Integer result = Calculator.sum(x, y);
        assertEquals(expResult, result);

    }
}

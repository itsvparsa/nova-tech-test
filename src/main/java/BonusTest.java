import org.junit.Test;

public class BonusTest {

    public static void main(String[] args) {
        sampleTest(1, 1);
        sampleTest(-1, 1);
        sampleTest(1, 0);
    }

    @Test
    public static void sampleTest(int x, int y) {
        if (x > 0) {
            if (y > 0) {
                System.out.println("Positive");
            }
        }
        if (x < 0) {
            System.out.println("Negative");
        }
    }
}

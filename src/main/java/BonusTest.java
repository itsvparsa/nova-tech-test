import org.junit.Test;

public class BonusTest {

    public static void main(String[] args) {
//        sampleTest(1, 1);
//        sampleTest(-1, 1);
//        sampleTest(1, 0);
        getNewStringWithoutVowels("Something");
        getNewStringWithoutVowels("It's a REALLY Cool STRING");
        getNewStringWithoutVowels("Hello World");
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


    @Test
    public static String getNewStringWithoutVowels(String name) {

        final String updatedString = name.replaceAll("[aeiouAEIOU]", "");
        System.out.println(updatedString);
        return updatedString;
    }
}

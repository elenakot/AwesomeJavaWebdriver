import org.testng.annotations.Test;

public class Day1 {

    @Test
    public void testPrintInterviewOne() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i%5!=0) System.out.println("text 1");
            else if (i % 5 == 0 && i%3!=0) System.out.println("text 2");
            else if (i % 3 == 0 && i % 5 == 0) System.out.println("text 1" + "text 2");
            else System.out.println(i);
        }
    }

}





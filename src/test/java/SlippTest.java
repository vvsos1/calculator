import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SlippTest {
    @BeforeEach
    public void setup() {
        System.out.println("setup");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
    }
}

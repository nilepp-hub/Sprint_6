import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    @Parameterized.Parameters(name = "{index}: kittensCount={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {10, 10},
                {0, 0},
                //{-1, 0}
        });
    }

    private final int inputKittensCount;
    private final int expectedKittensCount;

    public FelineTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(inputKittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}
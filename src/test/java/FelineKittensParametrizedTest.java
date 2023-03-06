import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensParametrizedTest {
    @Parameterized.Parameters(name = "{index}: kittensCount={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {10, 10},
                {0, 0},
                {-1, -1},
                {-2, -2}
        });
    }
    private final int inputKittensCount;
    private final int expectedKittensCount;
    public FelineKittensParametrizedTest(int inputKittensCount, int expectedKittensCount) {
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
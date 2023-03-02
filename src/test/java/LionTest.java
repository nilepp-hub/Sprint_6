import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionTest {

    @Parameterized.Parameters(name = "{index}: sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false},
        });
    }

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void testEmptySex() throws Exception {
        new Lion("");
    }
    @Test(expected = Exception.class)
    public void testErrorSex() throws Exception {
        new Lion("Квир");
    }
}
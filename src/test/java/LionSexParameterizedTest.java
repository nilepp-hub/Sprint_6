import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexParameterizedTest {
    @Parameterized.Parameters(name = "{index}: sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Kvir", false},
                {"", false}
        });
    }
    private final String sex;
    private final boolean hasMane;

    public LionSexParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testDoesHaveMane() throws Exception {
        if (!sex.equals("Самец") && !sex.equals("Самка")) {
            exceptionRule.expect(Exception.class);
            exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        }
        Lion lion = new Lion(sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
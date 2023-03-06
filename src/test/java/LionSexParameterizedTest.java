import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionSexParameterizedTest {
    @Parameterized.Parameters(name = "{index}: sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самей", true},
                {"самка", false},
                {"Kvir", false},
                {"", false},
                {"123", false}
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
    public void testDoesHaveManeException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        Lion lion = new Lion(sex);
    }
}
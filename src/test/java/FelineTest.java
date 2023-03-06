import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FelineTest {
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        Animal animalMock = mock(Animal.class);
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(animalMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testEmptyAnimalKind() throws Exception {
        Animal animalMock = mock(Animal.class);
        when(animalMock.getFood("")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        animalMock.getFood("");
    }
}

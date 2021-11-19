import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class TestMain {
    @Test
    @DisplayName("sample test, intended as blueprint for future tests")
    void testNothing(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        Integer sample = null;
        // ACT -> run the function you like to test here and save the output
        boolean output = Objects.isNull(sample);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isTrue();
    }
}

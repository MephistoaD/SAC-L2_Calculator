package calculators;

import code.src.main.java.calculators.AAL5Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAAL5 {

    @Test
    @DisplayName("AAL5: 800B example from the exercise")
    void test_800B_example(){
        // ARRANGE
        AAL5Calculator calculator = new AAL5Calculator();
        final int BYTES = 800;
        final int EXPECTED_BYTES = 901;
        final int EXPECTED_CELLS = 17;
        final int EXPECTED_PADDING = 8;
        // ACT
        int[] outputValues = calculator.calculate(BYTES);
        // ASSERT
        assertThat(outputValues.TOTAL_BYTES).isEqualTo(EXPECTED_BYTES);
        assertThat(outputValues.NR_PACKETS).isEqualTo(EXPECTED_CELLS);
        assertThat(outputValues.BYTES_OF_PADDING).isEqualTo(EXPECTED_PADDING);
    }
}

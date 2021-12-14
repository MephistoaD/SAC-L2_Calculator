package calculators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valueobjects.OutputValues;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAAL34 {

    @Test
    @DisplayName("AAL3/4: 800B example from the exercise")
    void test_800B_example(){
        // ARRANGE
        AAL34Calculator calculator = new AAL34Calculator();
        final int BYTES = 800;
        final int EXPECTED_BYTES = 1007;
        final int EXPECTED_CELLS = 19;
        final int EXPECTED_PADDING = 36;
        // ACT
        OutputValues outputValues = calculator.calculate(BYTES);
        // ASSERT
        assertThat(outputValues.TOTAL_BYTES).isEqualTo(EXPECTED_BYTES);
        assertThat(outputValues.NR_PACKETS).isEqualTo(EXPECTED_CELLS);
        assertThat(outputValues.BYTES_OF_PADDING).isEqualTo(EXPECTED_PADDING);
}

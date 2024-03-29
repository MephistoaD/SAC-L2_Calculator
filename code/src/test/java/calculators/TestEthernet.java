package calculators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valueobjects.OutputValues;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestEthernet {

    @Test
    @DisplayName("Ethernet: 800B example from the exercise")
    void test_800B_example() {
        // ARRANGE
        EthernetCalculator calculator = new EthernetCalculator();
        final int BYTES = 800;
        final int EXPECTED_BYTES = 818;
        final int EXPECTED_CELLS = 1;
        final int EXPECTED_PADDING = 0;
        // ACT
        OutputValues outputValues = calculator.calculate(BYTES);
        // ASSERT
        assertThat(outputValues.TOTAL_BYTES).isEqualTo(EXPECTED_BYTES);
        assertThat(outputValues.NR_PACKETS).isEqualTo(EXPECTED_CELLS);
        assertThat(outputValues.BYTES_OF_PADDING).isEqualTo(EXPECTED_PADDING);
    }
}

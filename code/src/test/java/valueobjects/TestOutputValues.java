package valueobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOutputValues {

    @Test
    @DisplayName("Test Constructor sets values correctly (1)")
    void testConstructor1() {
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final L2Protocol PROTOCOL = L2Protocol.ALL5_ATM;
        final int TOTAL_BYTES = 99;
        final int NR_PACKETS = 16;
        final int BYTES_OF_PADDING = 42;
        // ACT -> run the function you like to test here and save the output
        OutputValues outputValues = new OutputValues(PROTOCOL, TOTAL_BYTES, NR_PACKETS, BYTES_OF_PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(outputValues.PROTOCOL).isEqualTo(PROTOCOL);
        assertThat(outputValues.TOTAL_BYTES).isEqualTo(TOTAL_BYTES);
        assertThat(outputValues.NR_PACKETS).isEqualTo(NR_PACKETS);
        assertThat(outputValues.BYTES_OF_PADDING).isEqualTo(BYTES_OF_PADDING);
    }

    @Test
    @DisplayName("Test Constructor sets values correctly (2)")
    void testConstructor2() {
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final L2Protocol PROTOCOL = L2Protocol.ALL5_ATM;
        final int TOTAL_BYTES = 78;
        final int NR_PACKETS = 3;
        final int BYTES_OF_PADDING = 10000;
        // ACT -> run the function you like to test here and save the output
        OutputValues outputValues = new OutputValues(PROTOCOL, TOTAL_BYTES, NR_PACKETS, BYTES_OF_PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(outputValues.PROTOCOL).isEqualTo(PROTOCOL);
        assertThat(outputValues.TOTAL_BYTES).isEqualTo(TOTAL_BYTES);
        assertThat(outputValues.NR_PACKETS).isEqualTo(NR_PACKETS);
        assertThat(outputValues.BYTES_OF_PADDING).isEqualTo(BYTES_OF_PADDING);
    }
}

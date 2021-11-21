package valueobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestInputValues {
    @Test
    @DisplayName("Test Constructor sets values correctly GUI mode")
    void testConstructorGUI() {
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final boolean GUI = true;
        // ACT -> run the function you like to test here and save the output
        InputValues inputValues = new InputValues(GUI);
        // ASSERT -> check the output from the previous test here
        assertThat(inputValues.GUI).isTrue();
    }

    @Test
    @DisplayName("Test Constructor sets values correctly CLI mode (1)")
    void testConstructorCLI1() {
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final boolean GUI = false;
        final int BYTES = 42;
        final L2Protocol[] L2PROTOCOL = {valueobjects.L2Protocol.ETHERNET, valueobjects.L2Protocol.ALL3_4_ATM, valueobjects.L2Protocol.ALL5_ATM};
        final boolean PADDING = false;
        final boolean HELP = false;
        // ACT -> run the function you like to test here and save the output
        InputValues inputValues = new InputValues(BYTES, L2PROTOCOL, PADDING, HELP);
        // ASSERT -> check the output from the previous test here
        assertThat(inputValues.GUI).isEqualTo(GUI);
        assertThat(inputValues.BYTES).isEqualTo(BYTES);
        assertThat(inputValues.PROTOCOLS).containsOnly(L2PROTOCOL);
        assertThat(inputValues.PADDING).isEqualTo(PADDING);
        assertThat(inputValues.HELP).isEqualTo(HELP);
    }

    @Test
    @DisplayName("Test Constructor sets values correctly CLI mode (2)")
    void testConstructorCLI2() {
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final boolean GUI = false;
        final int BYTES = 6;
        final L2Protocol[] L2PROTOCOL = {valueobjects.L2Protocol.ALL3_4_ATM, valueobjects.L2Protocol.ETHERNET};
        final boolean PADDING = true;
        final boolean HELP = true;
        // ACT -> run the function you like to test here and save the output
        InputValues inputValues = new InputValues(BYTES, L2PROTOCOL, PADDING, HELP);
        // ASSERT -> check the output from the previous test here
        assertThat(inputValues.GUI).isEqualTo(GUI);
        assertThat(inputValues.BYTES).isEqualTo(BYTES);
        assertThat(inputValues.PROTOCOLS).containsOnly(L2PROTOCOL);
        assertThat(inputValues.PADDING).isEqualTo(PADDING);
        assertThat(inputValues.HELP).isEqualTo(HELP);
    }
}


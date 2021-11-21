import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valueobjects.L2Protocol;
import valueobjects.OutputValues;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class TestMain {

    @Test
    @DisplayName("Assure that command line arguments with errors are handled")
    void testInputValuesIsNull(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        String[] args = {"some", "sample", "values"};
        // ACT -> run the function you like to test here and save the output
        int returnValue = Main.run(args);
        // ASSERT -> check the output from the previous test here
        assertThat(returnValue).isEqualTo(1);
    }

    @Test
    @Disabled
    @DisplayName("Assure that gui mode is handled")
    void testGuiMode(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        String[] args = {"--gui"};
        // ACT -> run the function you like to test here and save the output
        int returnValue = Main.run(args);
        // ASSERT -> check the output from the previous test here
        assertThat(returnValue).isEqualTo(0);
    }

    @Test
    @Disabled
    @DisplayName("Assure that proper arguments are handled")
    void testRunCLI(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        String[] args = {"-B", "800B", "-L2", "AAL5-ATM", "Ethernet", "-P"};
        // ACT -> run the function you like to test here and save the output
        int returnValue = Main.run(args);
        // ASSERT -> check the output from the previous test here
        assertThat(returnValue).isEqualTo(0);
    }

    @Test
    @DisplayName("Test Print Output Values with padding")
    void testPrintOutputValuesPad(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.AAL5_ATM, 901, 17, 8);
        final boolean PADDING = true;
        final String EXPECTED = "AAL5-ATM\n" +
                "901 Bytes\n" +
                "17 cells\n" +
                "8 bytes of padding\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = Main.printOutputValues(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }

    @Test
    @DisplayName("Test Print Output Values without padding")
    void testPrintOutputValuesNoPad(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.ETHERNET, 818, 1, 0);
        final boolean PADDING = false;
        final String EXPECTED = "Ethernet\n" +
                "818 Bytes\n" +
                "1 frames\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = Main.printOutputValues(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }

    @Test
    @DisplayName("Test Print Output Values with AAL3/4-ATM")
    void testPrintOutputValuesAAL3_4_ATM(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.AAL3_4_ATM, 818, 1, 0);
        final boolean PADDING = true;
        final String EXPECTED = "AAL3/4-ATM\n" +
                "818 Bytes\n" +
                "1 cells\n" +
                "0 bytes of padding\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = Main.printOutputValues(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }
}

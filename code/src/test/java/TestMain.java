import calculators.Calculator;
import cli.CLIInterpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.stubbing.Answer;
import valueobjects.InputValues;
import valueobjects.L2Protocol;
import valueobjects.OutputValues;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMain {
    Main m;
    CLIInterpreter cli;
    Calculator ethernet, aal5, aal34;

    @BeforeEach
    void prepareTests(){
        cli = mock(CLIInterpreter.class);
        ethernet = mock(Calculator.class);
        aal5 = mock(Calculator.class);
        aal34 = mock(Calculator.class);
        m = new Main(cli, ethernet, aal5, aal34);
    }

    @Test
    @DisplayName("Assure that command line arguments with errors are handled")
    void testInputValuesIsNull(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final String[] ARGS = {"some", "sample", "values"};
        when(cli.convertArguments(ARGS)).then(null);
        // ACT -> run the function you like to test here and save the output
        int returnValue = m.run(ARGS);
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
        int returnValue = m.run(args);
        // ASSERT -> check the output from the previous test here
        assertThat(returnValue).isEqualTo(0);
    }

    @Test
    @Disabled
    @DisplayName("Assure that proper arguments are handled")
    void testRunCLI(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final String[] ARGS = {"-B", "800B", "-L2", "AAL5-ATM", "Ethernet", "-P"};
        final L2Protocol[] PROTOCOLS = {L2Protocol.AAL5_ATM, L2Protocol.ETHERNET};
        final InputValues EXPECTED_INPUTVALUES = new InputValues(800, PROTOCOLS, true, false);
        when(cli.convertArguments(ARGS)).then((Answer<?>) EXPECTED_INPUTVALUES);
        // ACT -> run the function you like to test here and save the output
        int returnValue = m.run(ARGS);
        // ASSERT -> check the output from the previous test here
        assertThat(returnValue).isEqualTo(0);
    }

    @Test
    @DisplayName("Test get Output text with padding")
    void testGetOutputTextPad(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.AAL5_ATM, 901, 17, 8);
        final boolean PADDING = true;
        final String EXPECTED = "AAL5-ATM\n" +
                "901 Bytes\n" +
                "17 cells\n" +
                "8 bytes of padding\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = m.getOutputText(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }

    @Test
    @DisplayName("Test Get Output text without padding")
    void testGetOutputTextNoPad(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.ETHERNET, 818, 1, 0);
        final boolean PADDING = false;
        final String EXPECTED = "Ethernet\n" +
                "818 Bytes\n" +
                "1 frames\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = m.getOutputText(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }

    @Test
    @DisplayName("Test Get Output Text with AAL3/4-ATM")
    void testGetOutputTextAAL3_4_ATM(){
        // ARRANGE -> prepare the environment here (mocks, stubs, objects, variables)
        final OutputValues OUTPUT_VALUES = new OutputValues(L2Protocol.AAL3_4_ATM, 818, 1, 0);
        final boolean PADDING = true;
        final String EXPECTED = "AAL3/4-ATM\n" +
                "818 Bytes\n" +
                "1 cells\n" +
                "0 bytes of padding\n\n";
        // ACT -> run the function you like to test here and save the output
        String output = m.getOutputText(OUTPUT_VALUES, PADDING);
        // ASSERT -> check the output from the previous test here
        assertThat(output).isEqualTo(EXPECTED);
    }
}

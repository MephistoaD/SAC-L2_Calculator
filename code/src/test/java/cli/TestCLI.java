package cli;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valueobjects.InputValues;
import valueobjects.L2Protocol;

import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.mockito.Mockito.mock;

public class TestCLI {

    @Test
    @DisplayName("Testing the CLI inplut from the exercise")
    void test_cli_input_from_exercise(){
        // ARRANGE
        final String[] ARGS = {"-B", "800B", "-L2", "AAL5-ATM", "Ethernet", "-P"};
        final int BYTES = 800;
        final L2Protocol[] PROTOCOLS = {L2Protocol.AAL5_ATM, L2Protocol.ETHERNET};
        final boolean PADDING = true;
        CLIInterpreter cliInterpreter = CLIInterpreter.create();
        // ACT
        InputValues inputValues = cliInterpreter.convertArguments(ARGS);
        // ASSERT
        assertThat(inputValues.BYTES).isEqualTo(BYTES);
        assertThat(inputValues.PROTOCOLS).isEqualTo(PROTOCOLS);
        assertThat(inputValues.PADDING).isEqualTo(PADDING);
    }

    @Test
    @DisplayName("Testing the CLI inplut to start the GUI")
    void test_cli_input_GUI(){
        // ARRANGE
        final String[] ARGS = {"--gui"};
        final boolean GUI = true;
        CLIInterpreter cliInterpreter = CLIInterpreter.create();
        // ACT
        InputValues inputValues = cliInterpreter.convertArguments(ARGS);
        // ASSERT
        assertThat(inputValues.GUI).isEqualTo(GUI);
    }

    @Test
    @Disabled
    @DisplayName("Testing the CLI inplut for help")
    void test_cli_input_for_help(){
        // ARRANGE
        final String[] ARGS = {"?"};
        final boolean HELP = true;
        CLIInterpreter cliInterpreter = CLIInterpreter.create();
        // ACT
        InputValues inputValues = cliInterpreter.convertArguments(ARGS);
        // ASSERT
        assertThat(inputValues.HELP).isEqualTo(HELP);
    }
}

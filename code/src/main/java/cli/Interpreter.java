import org.apache.commons.cli.*;

import java.io.OutputStream;

package cli;


public class Interpreter implements CLIInterpreter{

        OutputStream      output  = null;
        CommandLineParser parser  = null;
        CommandLine       cmdLine = null;

    @Override
    public InputValues readArgs(String[] args) {
        ///////////////////////////////////////////////////////////////////////
        // Configuramos las opciones de validación de entrada.
        ///////////////////////////////////////////////////////////////////////
        Options options = new Options();
        options.addOption("B", true, "introduce the number of bytes that are send");
        options.addOption("L2", true, "set the L2 protocols for the calculations. Protocols AAL5-ATM, AAL3/4-ATM and Ethernet must be separated by a space");
        options.addOption("P", true, "set that padding bytes must be included in the results too");
        options.addOption("?", true, "show the parameters that can be used to execute the program ");


        // No pueden aparecen las dos opciones simultáneamente.
        OptionGroup group = new OptionGroup();
        group.addOption(new Option("err", "Salida estándar de errores"));
        group.addOption(new Option("console", "Salida estándar"));
        options.addOptionGroup(group);


        try {

            parser = new BasicParser();
            cmdLine = parser.parse(options, args);

            if (cmdLine.hasOption("?")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos;
            System.out.println ("B = number of bytes that are send");
            System.out.println ("L2 = n2 protocols for the calculations");
            System.out.println ("P = adding bytes");


            }


            if (cmdLine.hasOption("B")) {

            }

            if (cmdLine.getOptionValue("L2")) {

            }

            if (cmdLine.hasOption("P")) {

            }



            if (cmdLine.hasOption("console")) {
                output = System.out;
            } else if (cmdLine.hasOption("err")) {
                output = System.err;
            } else {
                output = null;
            }

            // ..............................................................
            // Aquí irían las tareas que tuviera que realizar la aplicación
            // ..............................................................

            System.out.println("OK");

        } catch (org.apache.commons.cli.ParseException ex) {
            System.out.println(ex.getMessage());

            new HelpFormatter().printHelp(CommonsCliApp.class.getCanonicalName(), options);    // Error, imprimimos la ayuda
        } catch (java.lang.NumberFormatException ex) {
            new HelpFormatter().printHelp(CommonsCliApp.class.getCanonicalName(), options);    // Error, imprimimos la ayuda
        }
    }
}
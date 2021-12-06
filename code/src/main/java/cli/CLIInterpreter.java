package cli;

import valueobjects.InputValues;

// TODO: Write an interpreter class which takes the String array and
//  - extracts the given values from this array, even if it's unordered
//  - creates a value object of type InputValues with the read values (calling the classes constructor)
//  - returns the InputValues Object for further handling
//  .
//  The program must check
//  - that the number of L3 Bytes is a natural and positive number and
//  - that at least one protocol has been selected.
//  If any of those conditions is not fulfilled a message must appear to indicate the action needed to get the results. and null is returned
//  .
//  If there are uninterpretable arguments given there should appear a message identifiying the argument and telling it is not known.
//  If there are doubled arguments, there should appear a message identifying the doubled argument and indicating which one of both is used.
//  .
//  PLEASE: make the interpretation of the parameters case insensitive
//  PLEASE: remember the input of bytes also contains it's unit
//  PLEASE: consider the attributes of any object from the Package valueobjects as immutable
//  PLEASE: make the Interpreter class package-private.
//  HINT: take the CLI Output as dependency-injected parameter of type PrintStream. This simplifies the testing process
//  IMPORTANT: Do not touch this interface!
//             Use unittests instead to evaluate the quality of the code!

public interface CLIInterpreter {
    public static InputValues readArgs(String[] args){
        return null; // new Interpreter(System.out).convertArguments(args);
    }
    InputValues convertArguments(String[] args);
}


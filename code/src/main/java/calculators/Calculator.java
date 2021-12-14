package code.src.main.java.calculators;

// TODO: one class for each protocol implementing this interface
//  and having exactly one package-private method which is calculate()
//  (the other methods may be private)
//  The following classes should be implemented:
//  - EthernetCalculator
//  - ALL5ATMCalculator
//  - ALL34ATMCalculator
//  PLEASE: make them package-private.
//  PLEASE: consider the attributes of any object from the Package valueobjects as immutable
//  IMPORTANT: Do not touch this interface!
//             Use unittests instead to evaluate the quality of the code!

import code.src.main.java.calculators.AAL34Calculator;
import code.src.main.java.calculators.AAL5Calculator;

public interface Calculator {
    public static Calculator createEhernetCalculator(){
        return new EthernetCalculator();
    }
    public static Calculator createAAL5Calculator(){
        return (Calculator) new AAL5Calculator();
    }
    public static Calculator createAAL34Calculator(){return (Calculator) new AAL34Calculator();}
    int[] calculate(int bytes);
}

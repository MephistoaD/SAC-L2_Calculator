package calculators;

import valueobjects.OutputValues;

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

public interface Calculator {
    public static Calculator createEhernetCalculator(){
        return new EthernetCalculator();
    }
    public static Calculator createAAL5Calculator(){
        return new AAL5Calculator();
    }
    public static Calculator createAAL34Calculator(int bytes){
        return new AAL34Calculator();

    }
    OutputValues calculate(int bytes);
}

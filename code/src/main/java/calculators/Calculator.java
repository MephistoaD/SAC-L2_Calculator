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
    public static OutputValues calculateEthernet(int bytes){
        return null; // new EthernetCalculator().calculate(bytes);
    }
    public static OutputValues calculateALL5ATM(int bytes ){
        return null; // new AAL5Calculator().calculate(bytes);
    }
    public static OutputValues calculateALL34ATM(int bytes){
        return null; // new ALL34Calculator().calculate(bytes);

    }
    OutputValues calculate(int bytes);
}

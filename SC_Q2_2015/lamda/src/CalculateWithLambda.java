/**
 * Created by imusiievych on 5/19/15.
 */
public class CalculateWithLambda {
    static ArithmeticOperation addition=(first, second) -> {
        double result = first + second;
        System.out.println("" + first + " + " +
                second + " = " + result);
        return result;
    };
    public static double calculate(ArithmeticOperation whatToDo, double a, double b ){

        return whatToDo.performOperation(a,b);
    }

    public static void main(String[] args) {

        calculate(addition, 3.55, 50.00);

    }
}

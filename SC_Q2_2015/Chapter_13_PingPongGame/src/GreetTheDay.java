/**
 * Created by imusiievych on 6/9/15.
 */
public class GreetTheDay {

    public static void main(String[] args) {

        greet(Day.SATURDAY);
    }
    static void greet(Day day){
        switch (day) {
            case MONDAY:
                System.out.println("This is the start of the weekend");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Hello Weekend");
                break;
            default:
                System.out.println("Hello Midweek");
                break;
        }
    }
}

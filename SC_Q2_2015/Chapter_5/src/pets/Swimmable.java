package pets;

/**
 * Created by imusiievych on 5/19/15.
 */
public interface Swimmable {

    static final int MAX_DEPTH = 10; // in feet

    public void swim(int howFar);

    public default void dive(int howDeep){
        if (howDeep > MAX_DEPTH){
            System.out.println("Can't dive, sorry");
        }
    };
}

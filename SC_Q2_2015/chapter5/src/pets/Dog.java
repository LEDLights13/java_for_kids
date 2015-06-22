package pets;

/**
 * Created by imusiievych on 5/19/15.
 */
public class Dog extends Pet implements Swimmable, Talkative {

    public Dog(String petName) {
        super(petName);
    }

    public void talk(){
        System.out.println("Bark! I am " + petname);
    };

    public void swim(int howFar){
        System.out.println("Will swim this distance: " + howFar);
    };

}

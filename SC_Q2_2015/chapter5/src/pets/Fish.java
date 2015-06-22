package pets;

/**
 * Created by imusiievych on 5/19/15.
 */
public class Fish extends  Pet implements Swimmable, Talkative {

    public Fish(String petName) {
        super(petName);
    }

    public void talk(){
        System.out.println("I am a very beautiful fish " + petname);
    }

    public void swim(int howFar) {
        System.out.println("I can swim " + howFar + " meters, because i am a fish");
    }

    public void dive(int howDeep){
        System.out.println("I also can dive, because i am fish: " + howDeep);
    }

}

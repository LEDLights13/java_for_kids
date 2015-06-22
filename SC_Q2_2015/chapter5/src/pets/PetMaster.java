package pets;

/**
 * Created by imusiievych on 5/19/15.
 */
public class PetMaster {

    public static void main(String[] args) {
        Dog firstDog = new Dog("Dolly Musiievych");
        Fish firstFish = new Fish("Jolie");

        firstDog.talk();
        firstDog.swim(10);

        firstFish.talk();
        firstFish.dive(14);
        firstDog.dive(17);

        firstFish.swim(20);

    }



}

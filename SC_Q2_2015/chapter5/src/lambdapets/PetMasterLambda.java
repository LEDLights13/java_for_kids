package lambdapets;

import lambdapets.Talkative;

/**
 * Created by imusiievych on 5/20/15.
 */
public class PetMasterLambda {

    public static void main(String[] args) {
        Talkative dogtalkrules = (petName_) -> {
            return "I am a dog. My name is " + petName_;
        };

        Talkative parrottalkrules= (petName_) -> {
            return "I am a parrot. my name is " + petName_;
        };
         Pet x = new Pet(dogtalkrules, "X");

        Pet dog = new Pet(dogtalkrules, "Dolly");
        Pet parrot = new Pet(parrottalkrules,"Kesha");

        System.out.println(dog.speakup());
        System.out.println(parrot.speakup());

    }
}

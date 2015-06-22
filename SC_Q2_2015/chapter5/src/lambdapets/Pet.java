package lambdapets;

/**
 * Created by imusiievych on 5/20/15.
 */
public class Pet {
    Talkative talkingRules_;
    String petName_;

    public Pet(Talkative talkingRules, String petName){
        talkingRules_ = talkingRules;
        this.petName_ = petName;
    }

    public String speakup(){
        return talkingRules_.talk(petName_);

    }
}

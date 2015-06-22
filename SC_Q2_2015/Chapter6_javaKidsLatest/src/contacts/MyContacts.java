package contacts;

/**
 * Created by imusiievych on 5/14/15.
 */
import java.util.ArrayList;

public class MyContacts {
    public static void main(String[] args) {
        ArrayList<ContactDetail> friends = new ArrayList<ContactDetail>();

        ContactDetail friend1 = new ContactDetail();
        friend1.setFullName("Inna");
        friend1.setFacebookID("innaznayda_facebook");
        friend1.setEmail("iz@gmail.com");
        friend1.setPhone("0931112233");

        ContactDetail friend2 = new ContactDetail();
        friend2.setFullName("Ira");
        friend2.setFacebookID("iramatusevich_facebook");
        friend2.setEmail("imat@gmail.com");
        friend2.setPhone("0930000033");

        friends.add( friend1);
        friends.add(friend2);

        for (ContactDetail friend:friends){
            System.out.println(friend);
        }

    }

}

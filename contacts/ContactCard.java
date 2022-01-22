package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactCard {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + phoneNumber;
    }

    public ContactCard(){
    }

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public void setLastName(String lastName) { this.lastName = lastName;}

    public void setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            this.phoneNumber = phoneNumber;
        }else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }
}

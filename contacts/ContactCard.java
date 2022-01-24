package contacts;

public class ContactCard {
    public Person person;
    public Organization organization;
    String type;

    public ContactCard(String type, Person person) {
        this.type = type;
        this.person = person;
    }
    public ContactCard(String type, Organization organization) {
        this.type = type;
        this.organization = organization;
    }

    @Override
    public String toString() {
        if (type.equals("person")) {
            return person.toString();
        }
        return organization.toString();
    }
}

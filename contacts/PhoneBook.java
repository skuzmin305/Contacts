package contacts;
import java.util.*;

public class PhoneBook {
    private final List<ContactCard> phoneBook = new ArrayList<>();

    public List<ContactCard> getPhoneBook() {

        return phoneBook;
    }

    public int getSize() {

        return phoneBook.size();
    }

    void addContact(ContactCard contact) {
        phoneBook.add(contact);
    }

    ContactCard getContactCard(int index) {
        return phoneBook.get(index);
    }

    void removeContact(int id) {

        phoneBook.remove(id);
    }
}
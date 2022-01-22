package contacts;
import java.util.Scanner;

public class Main extends Exception{
    static PhoneBook phoneBook = new PhoneBook();
    static Scanner scan;

    public static void main(String[] args) {
        ContactCard contact;

        while (true) {
            scan = new Scanner(System.in);
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            String selector = scan.next();
            if (selector.equals("exit")) { break; }
            if (selector.equals("add")) {
                contact = new ContactCard();
                addContact(contact);
            }
            if (selector.equals("remove")) {
                removeContact();
            }
            if (selector.equals("edit")) {
                editContact();
            }
            if (selector.equals("count")) {
                System.out.println("The Phone Book has "
                        + phoneBook.getSize() + " records.");
            }
            if (selector.equals("list")) {
                printPhoneBook(phoneBook);
            }
        }
    }

    static void printPhoneBook(PhoneBook phoneBook){
        int line = 1;
        for(ContactCard contactCard : phoneBook.getPhoneBook()) {
            System.out.println(line + ". " + contactCard);
            line++;
        }
    }
    public static void addContact(ContactCard contact) {
        scan = new Scanner(System.in);

        System.out.print("Enter the name: ");
        contact.setFirstName(scan.nextLine());
        System.out.print("Enter the surname: ");
        contact.setLastName(scan.nextLine());
        System.out.print("Enter the number: ");
        contact.setPhoneNumber(scan.nextLine());

        phoneBook.addContact(contact);
    }
    public static void removeContact() {
        scan = new Scanner(System.in);
        if (phoneBook.getSize() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        printPhoneBook(phoneBook);
        System.out.print("Select a record: ");
        phoneBook.removeContact(scan.nextInt()-1);
        System.out.println("The record removed!");
    }
    public static void editContact() {
        scan = new Scanner(System.in);

        if (phoneBook.getSize() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        printPhoneBook(phoneBook);

        System.out.print("Select a record: ");
        int recordPosition = Integer.parseInt(scan.nextLine())-1;
        System.out.print("Select a field (name, surname, number): ");
        String field = scan.nextLine();
        if (field.equals("name")) {
            System.out.print("Enter name");
            String name = scan.nextLine();
            phoneBook.getContactCard(recordPosition).setFirstName(name);
        }
        if (field.equals("surname")) {
            System.out.print("Enter surname");
            String surname = scan.nextLine();
            phoneBook.getContactCard(recordPosition).setLastName(surname);
        }
        if (field.equals("number")) {
            System.out.print("Enter number");
            String number = scan.nextLine();
            phoneBook.getContactCard(recordPosition).setPhoneNumber(number);
        }
        System.out.println("The record updated!");
    }
}
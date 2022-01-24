package contacts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Exception{
    static PhoneBook phoneBook = new PhoneBook();
    static Scanner scan;
    static SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    public static void main(String[] args) {

        String selector;
        while (true) {
            scan = new Scanner(System.in);
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            selector = scan.nextLine();
            if (selector.equals("exit")) {
                break;
            }
            if (selector.equals("add")) {
                addContact();
                System.out.println("The record added.");
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
            if (selector.equals("info")) {
                printShort();
                System.out.print("Enter index to show info: ");
                String index = scan.nextLine();
                System.out.println(
                        phoneBook.getContactCard(Integer.parseInt(index)-1)
                );
            }
            System.out.println();
    }
    }

    static void printShort(){
        int index = 1;
        for(ContactCard contactCard : phoneBook.getPhoneBook()) {
            if (contactCard.type.equals("person")){
                System.out.println(
                        index + ". " + contactCard.person.toLine()
                );
            }else{
                System.out.println(
                        index + ". " + contactCard.organization.toLine()
                );
            }
            index++;
        }
    }
    public static void addContact() {
        scan = new Scanner(System.in);

        System.out.print("Enter the type (person, organization): ");
        String type = scan.nextLine();
        if (type.equals("person")) {
            phoneBook.addContact(addPerson(type));
        }else if (type.equals("organization")){
            phoneBook.addContact(addOrganization(type));
        }


    }

    public static ContactCard addPerson(String type) {
        System.out.print("Enter the name: ");
        String name = scan.nextLine();

        System.out.print("Enter the surname: ");
        String surname = scan.nextLine();

        System.out.print("Enter the birth date: ");
        String birthDate = scan.nextLine();
        if (birthDate.isEmpty()) {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }

        System.out.print("Enter the gender (M, F): ");
        String gender = scan.nextLine();
        if (!gender.toLowerCase(Locale.ROOT).equals("m") ||
                !gender.toLowerCase(Locale.ROOT).equals("f") ) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }

        System.out.print("Enter the number: ");
        String phoneNumber = scan.nextLine();
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            System.out.println("Wrong number format!");
            phoneNumber = "[no number]";
        }

        Person contact  = new Person.Builder()
                .setName(name)
                .setSurName(surname)
                .setBirthDate(birthDate)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateCreated()
                .setDataUpdates()
                .setType(type)
                .build();
        return new ContactCard(type, contact);
    }

    public static ContactCard addOrganization(String type) {
        System.out.print("Enter the organization name: ");
        String name = scan.nextLine();
        System.out.print("Enter the address: ");
        String address = scan.nextLine();
        System.out.print("Enter the number: ");
        String phoneNumber = scan.nextLine();

        Organization org = new Organization.Builder()
                .setName(name)
                .setAddress(address)
                .setDateCreate()
                .setDateUpdates()
                .setPhoneNumber(phoneNumber)
                .setType(type)
                .build();
        return new ContactCard(type, org);
    }

    public static void removeContact() {
        scan = new Scanner(System.in);
        if (phoneBook.getSize() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        printShort();
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
        printShort();

        System.out.print("Select a record: ");
        int index = Integer.parseInt(scan.nextLine())-1;
        if (phoneBook.getContactCard(index).type.equals("person")) {
            editPerson(index);
        }
        if (phoneBook.getContactCard(index).type.equals("organization")) {
            editOrganization(index);
        }
            System.out.println("The record updated!");
    }

    public static void editPerson(int index) {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scan.nextLine();
        if (field.equals("name")) {
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            phoneBook.getContactCard(index).person.setName(name);
        }
        if (field.equals("surname")) {
            System.out.print("Enter surname: ");
            String surname = scan.nextLine();
            phoneBook.getContactCard(index).person.setSurname(surname);
        }
        if (field.equals("number")) {
            System.out.print("Enter number: ");
            String number = scan.nextLine();
            phoneBook.getContactCard(index).person.setPhoneNumber(number);
        }
        if (field.equals("birth")) {
            System.out.print("Enter birth date: ");
            String birthDate = scan.nextLine();
            phoneBook.getContactCard(index).person.setBirthDate(birthDate);
        }
        if (field.equals("gender")) {
            System.out.print("Enter gender: ");
            String gender = scan.nextLine();
            phoneBook.getContactCard(index).person.setGender(gender);
        }
        phoneBook.getContactCard(index).person.setDateUpdates(date.format(new Date()));
    }
    public static void editOrganization(int index) {
        System.out.print("Select a field (name, address, number): ");
        String field = scan.nextLine();
        if (field.equals("name")) {
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            phoneBook.getContactCard(index).organization.setName(name);
        }
        if (field.equals("address")) {
            System.out.print("Enter address: ");
            String address = scan.nextLine();
            phoneBook.getContactCard(index).organization.setAddress(address);
        }
        if (field.equals("number")) {
            System.out.print("Enter number");
            String number = scan.nextLine();
            phoneBook.getContactCard(index).organization.setPhoneNumber(number);
        }
    }
}
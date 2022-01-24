package contacts;

import java.util.*;

public class Person extends BaseContactInformation{
    private static final Map<String, String> person = new LinkedHashMap<>();
    private static String name;
    private static String surName;
    private static String birthDate;
    private static String gender;

    public Person(String name, String surName, String birthDate, String gender, String phoneNumber, String type) {
        super(phoneNumber, type);
        Person.name = name;
        Person.surName = surName;
        Person.birthDate = birthDate;
        Person.gender = gender;

        person.put("Name", name);
        person.put("Surname", surName);
        person.put("Birth date", birthDate);
        person.put("Gender", gender);
        person.put("Number", phoneNumber);
        person.put("Time created", dateCreated);
        person.put("Time last edit", dateUpdates);
    }

    @Override
    public String toString() {
        StringBuilder contactToStr = new StringBuilder();
        for (var field : person.entrySet()) {
            contactToStr.append(field.getKey()).append(": ").append(field.getValue()).append("\n");
        }
        return contactToStr.toString();
    }

    public String toLine() {
        return person.get("Name") + " " + person.get("Surname");
    }

    public static class Builder {
        Builder() {}

        Builder setName(String name) {
            Person.name = name;
            return this;
        }

        Builder setSurName(String surName) {
            Person.surName = surName;
            return this;
        }

        Builder setBirthDate(String birthDate) {
            Person.birthDate = birthDate;
            return this;
        }

        Builder setGender(String gender) {
            Person.gender = gender;
            return this;
        }

        Builder setPhoneNumber(String phoneNumber) {
            Person.phoneNumber = phoneNumber;
            return this;
        }

        Builder setType(String type) {
            Person.type = type;
            return this;
        }

        Builder setDateCreated() {
            return this;
        }

        Builder setDataUpdates() {
            return this;
        }

        Person build(){
            return new Person(name, surName, birthDate, gender, phoneNumber, type);
        }
    }

    public void setName(String name) {
        person.put("Name", name);
        Person.name = name;
    }

    public void setSurname(String surName) {
        person.put("Surname", surName);
        Person.surName = surName;
    }

    public void setBirthDate(String birthDate) {
        person.put("Birth date", birthDate);
        Person.birthDate = birthDate;
    }

    public void setGender(String gender) {
        person.put("Gender", gender);
        Person.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        person.put("Number", phoneNumber);
        Person.phoneNumber = phoneNumber;
    }
}

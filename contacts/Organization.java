package contacts;

import java.util.LinkedHashMap;
import java.util.Map;

public class Organization extends BaseContactInformation{
    private static final Map<String, String> organization = new LinkedHashMap<>();
    private static String name;
    private static String address;

    public Organization(String name, String address, String phoneNumber, String type) {
        super(phoneNumber, type);
        Organization.name = name;
        Organization.address = address;

        organization.put("Organization name", name);
        organization.put("Address", address);
        organization.put("Number", phoneNumber);
        organization.put("Time created", dateCreated);
        organization.put("Time last edit", dateUpdates);
    }

    @Override
    public String toString() {
        StringBuilder orgToStr = new StringBuilder();
        for (var field : organization.entrySet()) {
            orgToStr.append(field.getKey()).append(": ").append(field.getValue()).append("\n");
        }
        return orgToStr.toString();
    }

    public String toLine() {
        return organization.get("Organization name");
    }

    public static class Builder {
        Builder() {}

        Builder setName(String name) {
            Organization.name = name;
            return this;
        }

        Builder setAddress(String address) {
            Organization.address = address;
            return this;
        }

        Builder setPhoneNumber(String phoneNumber) {
            Organization.phoneNumber = phoneNumber;
            return this;
        }

        Builder setDateCreate() {
            return this;
        }

        Builder setDateUpdates() {
            return this;
        }

        Builder setType(String type) {
            Organization.type = type;
            return this;
        }

        Organization build() {
            return new Organization(name, address, phoneNumber, type);
        }
    }

    public void setName(String name) {
        organization.put("Organization name", name);
        Organization.name = name;
    }

    public void setAddress(String address) {
        organization.put("Address", address);
        Organization.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        organization.put("Number", phoneNumber);
        Organization.phoneNumber = phoneNumber;
    }
}

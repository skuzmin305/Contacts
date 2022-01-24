package contacts;

import java.util.Date;
import java.text.SimpleDateFormat;

public class BaseContactInformation {
    protected static String phoneNumber;
    protected static String type;
    protected static String dateCreated;
    protected static String dateUpdates;

    public BaseContactInformation(String phoneNumber, String type) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        BaseContactInformation.phoneNumber = phoneNumber;
        BaseContactInformation.type = type;
        dateCreated = date.format(new Date());
        dateUpdates = date.format(new Date());
    }

    public void setPhoneNumber(String phoneNumber) {
        BaseContactInformation.phoneNumber = phoneNumber;
    }
    public void setDateUpdates(String dateUpdates) {
        BaseContactInformation.dateUpdates = dateUpdates;
    }
}
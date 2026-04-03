package model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private final List<PhoneNumber> phoneNumbers;
    private final List<EmailAddress> emailAddresses;

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = new ArrayList<>();
        this.emailAddresses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void addEmailAddress(EmailAddress emailAddress) {
        emailAddresses.add(emailAddress);
    }

    public String toJson() {
        return "{"
                + "\"firstName\":\"" + JsonUtils.escape(firstName) + "\","
                + "\"lastName\":\"" + JsonUtils.escape(lastName) + "\","
                + "\"company\":\"" + JsonUtils.escape(company) + "\","
                + "\"jobTitle\":\"" + JsonUtils.escape(jobTitle) + "\","
                + "\"phoneNumbers\":" + JsonUtils.toJsonArray(phoneNumbers, PhoneNumber::toJson) + ","
                + "\"emailAddresses\":" + JsonUtils.toJsonArray(emailAddresses, EmailAddress::toJson)
                + "}";
    }
}

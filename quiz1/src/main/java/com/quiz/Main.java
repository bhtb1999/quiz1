package com.quiz;

import model.Contact;
import model.EmailAddress;
import model.PhoneNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Contact[] contacts = createSampleContacts();

        Arrays.sort(contacts, Comparator.comparing(Contact::getLastName)
                .thenComparing(Contact::getFirstName));

        System.out.println(toJson(contacts));
    }

    private static Contact[] createSampleContacts() {
        Contact david = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");
        david.addPhoneNumber(new PhoneNumber("240-133-0011", "Home"));
        david.addPhoneNumber(new PhoneNumber("240-112-0123", "Mobile"));
        david.addEmailAddress(new EmailAddress("dave.sang@gmail.com", "Home"));
        david.addEmailAddress(new EmailAddress("dsanger@argos.com", "Work"));

        Contact carlos = new Contact("Carlos", "Jimenez", "Zappos", "Director");

        Contact ali = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
        ali.addPhoneNumber(new PhoneNumber("412-116-9988", "Work"));
        ali.addEmailAddress(new EmailAddress("ali@bmi.com", "Work"));

        return new Contact[]{david, carlos, ali};
    }

    private static String toJson(Contact[] contacts) {
        StringBuilder json = new StringBuilder("[\n");

        for (int index = 0; index < contacts.length; index++) {
            json.append("  ").append(contacts[index].toJson());
            if (index < contacts.length - 1) {
                json.append(",");
            }
            json.append("\n");
        }

        json.append("]");
        return json.toString();
    }
}

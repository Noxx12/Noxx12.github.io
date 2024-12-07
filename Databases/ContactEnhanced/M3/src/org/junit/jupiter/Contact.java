package org.junit.jupiter;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Validation Methods
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.trim().isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null, non-empty, and up to 10 characters.");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must be non-null, non-empty, and up to 10 characters.");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must be non-null, non-empty, and up to 10 characters.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be a 10-digit numeric string.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.trim().isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null, non-empty, and up to 30 characters.");
        }
    }
}

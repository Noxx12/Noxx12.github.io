package org.junit.jupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        // Arrange
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");

        // Assert
        Assertions.assertAll("Valid Contact Creation",
            () -> Assertions.assertEquals("1", contact.getContactId(), "Contact ID mismatch"),
            () -> Assertions.assertEquals("Kelly", contact.getFirstName(), "First Name mismatch"),
            () -> Assertions.assertEquals("Perez", contact.getLastName(), "Last Name mismatch"),
            () -> Assertions.assertEquals("1234567890", contact.getPhone(), "Phone mismatch"),
            () -> Assertions.assertEquals("10 Main St", contact.getAddress(), "Address mismatch")
        );
    }

    @Test
    public void testInvalidFirstName() {
        Assertions.assertAll("Invalid First Name",
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("2", "TestingANameLongerThanTenCharacters", "Perez", "1234567890", "10 Main St"),
                "Expected exception for first name longer than 10 characters"),
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("3", null, "Perez", "1234567890", "456 Elm St"),
                "Expected exception for null first name")
        );
    }

    @Test
    public void testInvalidLastName() {
        Assertions.assertAll("Invalid Last Name",
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("4", "Kelly", "TestingANameLongerThanTenCharacters", "1234567890", "456 Elm St"),
                "Expected exception for last name longer than 10 characters"),
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("5", "Kelly", null, "1234567890", "789 Oak St"),
                "Expected exception for null last name")
        );
    }

    @Test
    public void testInvalidPhone() {
        Assertions.assertAll("Invalid Phone Number",
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("6", "Kelly", "Perez", "12a45b7890", "456 Elm St"),
                "Expected exception for non-numeric phone number"),
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("7", "Kelly", "Perez", "123456789", "456 Elm St"),
                "Expected exception for phone number shorter than 10 digits"),
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("8", "Kelly", "Perez", "12345678901", "456 Elm St"),
                "Expected exception for phone number longer than 10 digits")
        );
    }

    @Test
    public void testInvalidAddress() {
        Assertions.assertAll("Invalid Address",
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("9", "Kelly", "Perez", "1234567890", "5142 TestingAddressThatsLongerThanThirtyCharacters"),
                "Expected exception for address longer than 30 characters"),
            () -> Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Contact("10", "Kelly", "Perez", "1234567890", null),
                "Expected exception for null address")
        );
    }
}

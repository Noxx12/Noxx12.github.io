package org.junit.jupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);

        // Retrieve the added contact
        Contact addedContact = contactService.getContact("1");

        // Validate the fields
        Assertions.assertNotNull(addedContact);
        Assertions.assertEquals("1", addedContact.getContactId());
        Assertions.assertEquals("Kelly", addedContact.getFirstName());
        Assertions.assertEquals("Perez", addedContact.getLastName());
        Assertions.assertEquals("1234567890", addedContact.getPhone());
        Assertions.assertEquals("10 Main St", addedContact.getAddress());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("1");

        // Ensure the contact no longer exists
        Contact deletedContact = contactService.getContact("1");
        Assertions.assertNull(deletedContact);
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "Kelly", "Perez", "1234567890", "10 Main St");
        contactService.addContact(contact);

        // Update the contact
        Contact updatedContactData = new Contact("1", "Kelly", "Perez", "9876543210", "456 Elm St");
        contactService.updateContact(updatedContactData);

        // Retrieve the updated contact
        Contact updatedContact = contactService.getContact("1");

        // Validate the updated fields
        Assertions.assertNotNull(updatedContact);
        Assertions.assertEquals("1", updatedContact.getContactId());
        Assertions.assertEquals("Kelly", updatedContact.getFirstName());
        Assertions.assertEquals("Perez", updatedContact.getLastName());
        Assertions.assertEquals("9876543210", updatedContact.getPhone());
        Assertions.assertEquals("456 Elm St", updatedContact.getAddress());
    }
}

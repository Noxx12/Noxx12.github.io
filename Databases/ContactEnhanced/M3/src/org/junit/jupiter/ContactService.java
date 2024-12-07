package org.junit.jupiter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactService {

    private static final Logger logger = Logger.getLogger(ContactService.class.getName());

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public void addContact(Contact contact) {
        String query = "INSERT INTO contacts (contact_id, first_name, last_name, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, contact.getContactId());
            preparedStatement.setString(2, contact.getFirstName());
            preparedStatement.setString(3, contact.getLastName());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.setString(5, contact.getAddress());
            preparedStatement.executeUpdate();

            logger.log(Level.INFO, "Contact added successfully: ID={0}", new Object[]{contact.getContactId()});

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add contact: ID=" + contact.getContactId(), e);
        }
    }

    public Contact getContact(String contactId) {
        String query = "SELECT * FROM contacts WHERE contact_id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, contactId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Contact(
                        resultSet.getString("contact_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to retrieve contact: ID=" + contactId, e);
        }
        logger.log(Level.WARNING, "Contact not found: ID={0}", new Object[]{contactId});
        return null;
    }

    public void updateContact(Contact contact) {
        String query = "UPDATE contacts SET first_name = ?, last_name = ?, phone = ?, address = ? WHERE contact_id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getPhone());
            preparedStatement.setString(4, contact.getAddress());
            preparedStatement.setString(5, contact.getContactId());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                logger.log(Level.INFO, "Contact updated successfully: ID={0}", new Object[]{contact.getContactId()});
            } else {
                logger.log(Level.WARNING, "No contact found to update: ID={0}", new Object[]{contact.getContactId()});
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update contact: ID=" + contact.getContactId(), e);
        }
    }

    public void deleteContact(String contactId) {
        String query = "DELETE FROM contacts WHERE contact_id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, contactId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                logger.log(Level.INFO, "Contact deleted successfully: ID={0}", new Object[]{contactId});
            } else {
                logger.log(Level.WARNING, "No contact found to delete: ID={0}", new Object[]{contactId});
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to delete contact: ID=" + contactId, e);
        }
    }
}

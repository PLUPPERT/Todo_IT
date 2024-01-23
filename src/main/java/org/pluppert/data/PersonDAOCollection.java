package org.pluppert.data;

import org.pluppert.db.MyJDBC;
import org.pluppert.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PersonDAOCollection implements PersonDAO {
    private static final PersonDAO INSTANCE;
    private static Connection connection;

    static {
        INSTANCE = new PersonDAOCollection();
        connection = MyJDBC.getConnection();
    }

    static PersonDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Person create(Person person) {
        if (person == null) throw new NullPointerException("person is null");
        String insertQuery = "INSERT INTO person (first_name, last_name) VALUES(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Person created successfully!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedPersonId = generatedKeys.getInt(1);
                    person.setId(generatedPersonId);
                    System.out.println("generatedPersonId = " + generatedPersonId);
                } else {
                    System.out.println("No key were generated");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        return null;
    }
    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public Collection<Person> findByName(String name) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}

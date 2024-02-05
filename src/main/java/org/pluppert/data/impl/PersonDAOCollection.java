package org.pluppert.data.impl;

import org.pluppert.data.PersonDAO;
import org.pluppert.db.MyJDBC;
import org.pluppert.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {
    private static final PersonDAO INSTANCE;
    private static final Connection connection;

    static {
        INSTANCE = new PersonDAOCollection();
        connection = MyJDBC.getConnection();
    }

    public static PersonDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Person create(Person person) {
        if (person == null) throw new NullPointerException("person is null");
        String insertQuery = "INSERT INTO person (first_name, last_name) VALUES(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Person created successfully!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedPersonId = generatedKeys.getInt(1);
                    person.updateId(person, generatedPersonId);
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
        List<Person> persons = new ArrayList<>();

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM person")
        ) {
            while (resultSet.next()) {
                //ColumnLabel
                int personId = resultSet.getInt("person_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                persons.add(new Person(personId, firstName, lastName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person findById(int id) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE person_id = ?")
        ) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Person(
                            resultSet.getInt("person_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No person with id \"" + id + "\" found in database");
    }

    @Override
    public Collection<Person> findByName(String name) {
        List<Person> persons = new ArrayList<>();

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        """
                                SELECT * FROM person
                                WHERE UPPER(first_name) LIKE ?
                                OR UPPER(last_name) LIKE ?
                                """
                )
        ) {
            preparedStatement.setString(1, "%" + name.toUpperCase() + "%");
            preparedStatement.setString(2, "%" + name.toUpperCase() + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int personId = resultSet.getInt("person_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");

                    persons.add(new Person(personId, firstName, lastName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
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

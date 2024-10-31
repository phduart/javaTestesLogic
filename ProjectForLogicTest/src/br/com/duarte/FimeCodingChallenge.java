package br.com.duarte;

import java.util.*;
import java.util.concurrent.*;
import java.sql.*;
import java.util.stream.*;

public class FimeCodingChallenge {

    // Sample entity class for the challenge
    public static class User {
        private int id;
        private String name;
        private String email;

        public User(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
        }
    }

    public static class InvalidUserException extends Exception {
        public InvalidUserException(String message) {
            super(message);
        }
    }

    // Main method to execute the coding challenge
    public static void main(String[] args) {
        // Sample data to simulate a database or external source
        List<User> users = Arrays.asList(
            new User(1, "John Doe", "john.doe@example.com"),
            new User(2, "Jane Smith", "jane.smith@example.com"),
            new User(3, "Alice Johnson", "alice.johnson@example.com")
        );

        System.out.println("=== Part 1: OOP ===");

        // Task 1: Create a new User object and print its details
        try {
            User newUser = createUser(4, "Bob Brown", "bob.brown@example.com");
            System.out.println("Created new user: " + newUser);
        } catch (InvalidUserException e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
        System.out.println("\n=== Part 2: Simulated Web Application Interaction ===");

        // Task 2: Find a user by email and print the result
        String userEmail = "alice.johnson@example.com";
        User user = findUserByEmail(users, userEmail);
        if (user != null) {
            System.out.println("Found user by email (" + userEmail + "): " + user);
        } else {
            System.out.println("User not found with email: " + userEmail);
        }

        System.out.println("\n=== Part 3: Simulated Database Interaction ===");
        String dbUrl = "jdbc:mysql://localhost:3306/fime";
        String dbUser = "root";
        String dbPassword = "password";
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connected to the database.");
            // Task 3: Fetch users from the database and print the results
            Future<List<User>> futureUsers = executor.submit(() -> fetchUsersFromDatabase(connection));
            List<User> dbUsers = futureUsers.get();
            System.out.println("Users fetched from database: " + dbUsers);
        } catch (SQLException | InterruptedException | ExecutionException e) {
            System.err.println("Database operation failed: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

        System.out.println("\n=== Part 4: Exception Handling ===");
        // Task 4: Handle a potential exception when creating a user with invalid data
        try {
            User invalidUser = createUser(-1, "", "");
            System.out.println("Created invalid user: " + invalidUser);
        } catch (InvalidUserException e) {

            System.err.println("Failed to create user: " + e.getMessage());
        }

        System.out.println("\n=== Part 5: Concurrency ===");
        // Task 5: Execute tasks concurrently and handle results
        List<Callable<String>> tasks = Arrays.asList(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );
        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            for (Future<String> result : results) {
                System.out.println("Task result: " + result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task execution failed: " + e.getMessage());
        }
    }

    // Task 1: Method to create a new user (Part 1)
    public static User createUser(int id, String name, String email) throws InvalidUserException {

        if(name.trim().equals("")) {
            throw  new InvalidUserException(("NAME CANNOT BE NULL"));
        }

        if(email.trim().equals("")) {
            throw  new InvalidUserException(("EMAIL CANNOT BE NULL"));
        }

        if(id >= 0){
            throw new InvalidUserException("ID. CANNOT BE UNDER THE 0 (ZERO) ");
        }

        return new User(id, name, email);
    }

    // Task 2: Method to find a user by email (Part 2)
    public static User findUserByEmail(List<User> users, String email) {
        for(User user : users) {
            if(user.email.equals(email)) {
                return user;
            }
        }
		return null;
    }

    // Task 3: Simulated method to fetch users from a database (Part 3)
    public static List<User> fetchUsersFromDatabase(Connection connection) throws SQLException {
        // Task: Implement the logic to fetch users from the database
		return null;
    }
}

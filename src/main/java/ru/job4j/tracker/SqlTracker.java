package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() throws SQLException {
        init();
    }

    public SqlTracker(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO items(created, item_name) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1, Timestamp.valueOf(item.getCreated()));
            statement.setString(2, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int rowsAffected = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE items SET created = ?, item_name = ? WHERE id = ?")) {
            statement.setTimestamp(1, Timestamp.valueOf(item.getCreated()));
            statement.setString(2, item.getName());
            statement.setInt(3, id);
            rowsAffected = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new LinkedList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items")) {

            while (resultSet.next()) {
                Item nextItem = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("item_name")
                );
                nextItem.setCreated(
                        resultSet.getTimestamp("created").toLocalDateTime()
                );
                items.add(nextItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new LinkedList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE item_name = '" + key + "'")) {

            while (resultSet.next()) {
                Item nextItem = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("item_name")
                );
                nextItem.setCreated(
                        resultSet.getTimestamp("created").toLocalDateTime()
                );
                items.add(nextItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE id = " + id)) {

            if (resultSet.next()) {
                item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("item_name")
                );
                item.setCreated(
                        resultSet.getTimestamp("created").toLocalDateTime()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }
}

package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
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

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("newItem");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(newItem.getName());
    }

    @Test
    public void whenDeleteItemAndFindByGeneratedIdNotFound() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindAllItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemTask = new Item("Task");
        tracker.add(item);
        tracker.add(itemTask);
        assertThat(tracker.findAll()).contains(item, itemTask);
    }

    @Test
    public void whenFindByNameWhereNameNotFound() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemTask = new Item("Task");
        tracker.add(item);
        tracker.add(itemTask);
        assertThat(tracker.findByName("Task1")).hasSize(0);
    }

    @Test
    public void whenFindByName() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemTask = new Item("Task");
        tracker.add(item);
        tracker.add(itemTask);
        assertThat(tracker.findByName("Task")).contains(itemTask);
    }

    @Test
    public void whenFindById() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemTask = new Item("Task");
        tracker.add(item);
        tracker.add(itemTask);
        assertThat(tracker.findById(itemTask.getId()).getName()).isEqualTo(itemTask.getName());
    }
}
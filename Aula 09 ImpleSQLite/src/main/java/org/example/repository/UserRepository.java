package org.example.repository;

import org.example.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements EntityRepository<User>{
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User entity) {
        String query = "INSERT INTO products VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, entity.getUuid().toString());
            stmt.setString(2, entity.getName());
            stmt.setString(3, entity.getEmail());
            stmt.setString(4, entity.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional findById(UUID id) {
        String query = "SELECT * FROM user WHERE uuid = ?";
        try {

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}

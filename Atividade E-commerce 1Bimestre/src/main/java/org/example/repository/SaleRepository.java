package org.example.repository;

import org.example.entities.Product;
import org.example.entities.Sale;

import java.sql.*;
import java.util.*;

public class SaleRepository implements EntityRepository<Sale> {
    private final Connection connection;

    public SaleRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Sale sale) {
        try {
            // Inserir na tabela sales
            String saleQuery = "INSERT INTO sales (id, user_id, payment_method) VALUES (?, ?, ?)";
            PreparedStatement saleStmt = connection.prepareStatement(saleQuery);
            saleStmt.setString(1, sale.getUuid().toString());
            saleStmt.setString(2, sale.getUserId().toString());
            saleStmt.setString(3, sale.getPaymentMethod());
            saleStmt.executeUpdate();

            // Inserir na tabela sale_products
            String saleProductQuery = "INSERT INTO sale_products (sale_id, product_id) VALUES (?, ?)";
            PreparedStatement saleProductStmt = connection.prepareStatement(saleProductQuery);
            for (Product product : sale.getProducts()) {
                saleProductStmt.setString(1, sale.getUuid().toString());
                saleProductStmt.setString(2, product.getUuid().toString());
                saleProductStmt.addBatch();
            }
            saleProductStmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar venda: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Sale> findById(UUID id) {
        throw new UnsupportedOperationException("findById ainda não implementado para Sale.");
    }

    @Override
    public List<Sale> findAll() {
        throw new UnsupportedOperationException("findAll ainda não implementado para Sale.");
    }

    @Override
    public void deleteById(UUID id) {
        throw new UnsupportedOperationException("deleteById ainda não implementado para Sale.");
    }
}
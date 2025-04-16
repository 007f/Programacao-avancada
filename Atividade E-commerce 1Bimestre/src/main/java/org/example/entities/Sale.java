package org.example.entities;

import org.example.paymentMethods.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Sale extends Entity {
    private UUID userId;
    private List<Product> products;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    // Construtor padrão para nova venda
    public Sale(UUID user, List<Product> products, PaymentMethod paymentMethod) {
        super();
        this.userId = user;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.date = LocalDateTime.now(); // ou deixe nulo se quiser setar depois
    }

    // Construtor para carregar do banco
    public Sale(UUID uuid, User user, List<Product> products, PaymentMethod paymentMethod, LocalDateTime date) {
        super(uuid);
        this.userId = user.getUuid();
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    // Getters e setters

    public UUID getUserId() {
        return userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getPaymentMethod() {
        return paymentMethod.getType();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
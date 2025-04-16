package org.example.paymentMethods;

public class PaymentMethodFactory {

    public static PaymentMethod create(PaymentType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo.");
        }

        return switch (type) {
            case CARTAO -> new CreditCardPayment();
            case BOLETO -> new BoletoPayment();
            case PIX -> new PixPayment();
        };
    }
}
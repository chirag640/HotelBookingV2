package edu.sabanciuniv.hotelbookingapp.model;

import edu.sabanciuniv.hotelbookingapp.model.enums.Currency;
import edu.sabanciuniv.hotelbookingapp.model.enums.PaymentMethod;
import edu.sabanciuniv.hotelbookingapp.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import com.paypal.api.payments.Payer;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @CreationTimestamp
    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

//    @PrePersist
//    protected void onCreate() {
//        this.transactionId = UUID.randomUUID().toString();
//    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", paymentDate=" + paymentDate +
                ", booking=" + booking +
                ", totalPrice=" + totalPrice +
                ", paymentStatus=" + paymentStatus +
                ", paymentMethod=" + paymentMethod +
                ", currency=" + currency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(transactionId, payment.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId);
    }

    public void setIntent(String intent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIntent'");
    }

    public void setPayer(Payer payer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPayer'");
    }

    public void setTransactions(List<Transaction> singletonList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTransactions'");
    }

    public void setRedirectUrls(RedirectUrls redirectUrls) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRedirectUrls'");
    }

    public com.paypal.api.payments.Payment create(APIContext apiContext) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

}

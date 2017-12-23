package com.budgete.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author imuliar
 * 01.10.2017
 */
@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    /**
     * Amount of money that should be paid
     */
    private BigDecimal dueAmount;

    /**
     * The date when the dueAmount should be paid
     */
    private LocalDate dueDate;

    /**
     * The amount that already have been paid. Zero - by default.
     */
    private BigDecimal paidAmount = BigDecimal.ZERO;

    /**
     * Payment Item to which this payment belongs
     */
    private CustomDatePayItem payItem;

    /*
    * Constructors
    */
    public Payment() {
    }

    public Payment(BigDecimal dueAmount, LocalDate dueDate) {
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
    }
}

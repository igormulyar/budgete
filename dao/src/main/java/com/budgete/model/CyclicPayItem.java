package com.budgete.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
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
public class CyclicPayItem {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    /**
     * <p>Represents the frequent point on time line that triggers the payment</p>
     * @see ChronoField
     */
    private ChronoField frequentDatePoint;

    /**
     * <p>The date from which the sequent payment cycle starts</p>
     */
    private LocalDate inceptionDate;

    /**
     * <p>The date of ending the cycle</p>
     */
    private LocalDate endDate;

    /**
     * <p>Money to pay every cycle on due date</p>
     */
    private BigDecimal amount;

    /*
     * Constructors
     */
    public CyclicPayItem() {
    }

    public CyclicPayItem(ChronoField frequentDatePoint, BigDecimal amount) {
        this.frequentDatePoint = frequentDatePoint;
        this.inceptionDate = LocalDate.now();
        this.amount = amount;
    }

    public CyclicPayItem(ChronoField frequentDatePoint, LocalDate inceptionDate, BigDecimal amount) {
        this.frequentDatePoint = frequentDatePoint;
        this.inceptionDate = inceptionDate;
        this.amount = amount;
    }

    public CyclicPayItem(Long id, ChronoField frequentDatePoint, LocalDate inceptionDate, LocalDate endDate, BigDecimal amount) {
        this.id = id;
        this.frequentDatePoint = frequentDatePoint;
        this.inceptionDate = inceptionDate;
        this.endDate = endDate;
        this.amount = amount;
    }
}

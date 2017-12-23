package com.budgete.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author imuliar
 * 01.10.2017
 */
@Entity
@Data
public class CustomDatePayItem {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    /**
     * The set of all payments for this pay item.
     */
    @OneToMany
    private Set<Payment> payments;
}

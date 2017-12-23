package com.budgete.beans;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author imuliar
 * 23.11.2017
 */

@Component
@SessionScope
public class DutiesBean {

    private static Set<String> duties = initDuties();

    private static Set<String> initDuties(){
        duties = new HashSet<>();
        for (int i = 0; i < 20; i++){
            duties.add("Duty # " + i + "!");
        }
        return duties;
    }

    public Set<String> getDuties() {
        return duties;
    }

    public void setDuties(Set<String> duties) {
        this.duties = duties;
    }
}

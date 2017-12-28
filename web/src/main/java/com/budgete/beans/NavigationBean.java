package com.budgete.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author imuliar
 * 23.11.2017
 */

@Component
@SessionScope
public class NavigationBean {

    private String page = "content/dashboard.xhtml";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}

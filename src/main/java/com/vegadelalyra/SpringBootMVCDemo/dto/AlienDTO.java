package com.vegadelalyra.SpringBootMVCDemo.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AlienDTO {
    private int aid;
    private String aname;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "AlienDTO{" +
                "aid=" + aid +
                ", name='" + aname + '\'' +
                '}';
    }
}

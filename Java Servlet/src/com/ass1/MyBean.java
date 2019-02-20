package com.ass1;

import java.io.Serializable;
//Java class used for bean
public class MyBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String skid="";
    private String efficiency="";
    private String surface="";
    //empty constructor
    public MyBean() {
    }
    //setters and getters
    public String getSkid() {
        return skid;
    }
    public void setSkid(String skid) {
        this.skid = skid;
    }
    public String getEfficiency() {
        return efficiency;
    }
    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
    public String getSurface() {
        return surface;
    }
    public void setSurface(String surface) {
        this.surface = surface;
    }
}

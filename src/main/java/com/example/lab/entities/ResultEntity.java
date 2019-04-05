package com.example.lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id = 1;
    @JsonIgnore
    private String sessionid = "";
    private Point point;
    private boolean match = false;


    private double r;

    public ResultEntity(){
        super();
    }

    public ResultEntity(String sessionid, Point point, double r){
        this.sessionid = sessionid;
        this.point = point;
        this.r = r;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }
}

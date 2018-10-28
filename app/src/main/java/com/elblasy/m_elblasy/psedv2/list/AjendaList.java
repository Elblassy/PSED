package com.elblasy.m_elblasy.psedv2.list;

public class AjendaList {

    private String name;
    private String time;
    private String date;
    private String event;

    public AjendaList(String name, String time, String date, String event) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author psn
 */   
public class Conflict {
    
    
    private String id;
    
    private String iso;
    
    private String event_date;
    
    private String event_type;
    
    private String sub_event_type;
    
    private String actor1;

    private String assoc_actor1;
    
    private String actor2;
    
    private String assoc_actor2;
    
    private String interaction;
    
    private String region;
    
    private String country;
    
    private String admin1;
    
    private String admin2;
    
    private String location;
    
    private String source;
    
    private String notes;
    
    private String fatalities;
    
    private List<String> searchKeys;
    

    public Conflict() {
    }

    public Conflict(String[] s) {
        this.id = s[0];
        this.iso = s[1];
        this.event_date = s[2];
        this.event_type = s[3];
        this.sub_event_type = s[4];
        this.actor1 = s[5];
        this.assoc_actor1 = s[6];
        this.actor2 = s[7];
        this.assoc_actor2 = s[8];
        this.interaction = s[9];
        this.region = s[10];
        this.country = s[11];
        this.admin1 = s[12];
        this.admin2 = s[13];
        this.location = s[14];
        this.source = s[15];
        this.notes = s[16];
        this.fatalities = s[17];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getSub_event_type() {
        return sub_event_type;
    }

    public void setSub_event_type(String sub_event_type) {
        this.sub_event_type = sub_event_type;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getAssoc_actor1() {
        return assoc_actor1;
    }

    public void setAssoc_actor1(String assoc_actor1) {
        this.assoc_actor1 = assoc_actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getAssoc_actor2() {
        return assoc_actor2;
    }

    public void setAssoc_actor2(String assoc_actor2) {
        this.assoc_actor2 = assoc_actor2;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdmin1() {
        return admin1;
    }

    public void setAdmin1(String admin1) {
        this.admin1 = admin1;
    }

    public String getAdmin2() {
        return admin2;
    }

    public void setAdmin2(String admin2) {
        this.admin2 = admin2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFatalities() {
        return fatalities;
    }

    public void setFatalities(String fatalities) {
        this.fatalities = fatalities;
    }

    public boolean isViolent(){
        searchKeys = new ArrayList<>();
        searchKeys.add("battles");
        searchKeys.add("riots");
        searchKeys.add("explosions/remote violence");
        if ( searchKeys.contains(event_type.toLowerCase()) ) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    @Override
    public String toString() {
        return "Conflict{" + "id=" + id + ", iso=" + iso + ", event_date=" + event_date + ", event_type=" + event_type + ", sub_event_type=" + sub_event_type + ", actor1=" + actor1 + ", assoc_actor1=" + assoc_actor1 + ", actor2=" + actor2 + ", assoc_actor2=" + assoc_actor2 + ", interaction=" + interaction + ", region=" + region + ", country=" + country + ", admin1=" + admin1 + ", admin2=" + admin2 + ", location=" + location + ", source=" + source + ", notes=" + notes + ", fatalities=" + fatalities + '}';
    }
    
    
    
    
}

package com.miage.app.Entity;

import java.util.Date;

public class Exhibition {
    private int idExhibition;
    private String name;
    private Date startDate;
    private Date endDate;
    private String place;
    private int maxVisitorNb;
    private String rooms;

    //Constructeur
    public Exhibition(int id,String name,Date start,Date end,String pl,int nbrMax,String rooms){
        this.idExhibition=id;
        this.name=name;
        this.startDate=start;
        this.endDate=end;
        this.place=pl;
        this.maxVisitorNb=nbrMax;
        this.rooms=rooms;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDateStart(Date start){
        this.startDate=start;
    }
    public void setEndDate(Date end){
        this.endDate=end;
    }
    public void setPlace(String place){
        this.place=place;
    }

    public void setNbrMax(int max){
        this.maxVisitorNb=max;
    }

    public void setRooms(String rooms){
        this.rooms=rooms;
    }

    public int getIdExhibition(){
        return this.idExhibition;
    }
    public String getName(){
        return this.name;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public String getPlace(){
        return this.place;
    }

    public int getMaxVisitorNb(){
        return this.maxVisitorNb;
    }

    public String getRooms(){
        return this.rooms;
    }

}

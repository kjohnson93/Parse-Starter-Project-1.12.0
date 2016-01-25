package com.parse.starter;

/**
 * Created by wolf on 1/23/2016.
 */
public class Information {


    String title;
    String company;
    String description;
    //Date dateStart, dateEnd;
    String dateStart, dateEnd;
    int category;
    String id;

    public Information() {


    }

    Information(String id, String title, String company, String description, String dateStart, String dateEnd, int category) {

        this.id = id;
        this.title = title;
        this.company = company;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.category = category;


    }

    public String getTitle() {
        return title;
    }


    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public int getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }
}

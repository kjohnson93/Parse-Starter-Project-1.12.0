package com.parse.starter;

/**
 * Created by wolf on 1/23/2016.
 */
public class Information {

    String title, company, description;
    //Date dateStart, dateEnd;
    String dateStart, dateEnd;
    int category;
    String id;

    public Information(){


    }

    Information(String id, String title, String company, String description, String dateStart, String dateEnd, int category){

        this.id = id;
        this.title = title;
        this.company = company;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.category = category;


    }
}

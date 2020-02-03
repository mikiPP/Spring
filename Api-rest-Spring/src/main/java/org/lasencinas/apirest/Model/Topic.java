package org.lasencinas.apirest.Model;


public class Topic {

    private String id;
    private String name;
    private  String description;



    /*--------------------------------------------------Builders------------------------------------------------------*/


    public Topic(){}


    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    /*--------------------------------------------------Getters------------------------------------------------------*/

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }




    /*--------------------------------------------------Setters------------------------------------------------------*/


    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }


}

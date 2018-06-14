package com.example.ahmed.geologicdatabase;

public class pdfclass {
    private String name,title,url;
    public pdfclass(String name,String title,String url)
    {

        this.name = name;
        this.title = title;
        this.url = url;
    }
    pdfclass(){

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

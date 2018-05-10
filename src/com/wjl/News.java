package com.wjl;

public class News {
    private String title;
    private String url;
    private String date;
    private String text;

    public News(){}

    public News(String title, String url, String date, String text){
        this.title = title;
        this.url = url;
        this.date = date;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}'+"/r/n";
    }
}

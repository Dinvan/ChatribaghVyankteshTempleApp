package models;

/**
 * Created by dbagv_000 on 6/26/2016.
 */
public class Events {

    private int eventid;
    private String eventtitle;
    private String eventdiscription;
    private String thumbnillpath;
    private String eventdatetime;


    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventdiscription() {
        return eventdiscription;
    }

    public void setEventdiscription(String eventdiscription) {
        this.eventdiscription = eventdiscription;
    }

    public String getThumbnillpath() {
        return thumbnillpath;
    }

    public void setThumbnillpath(String thumbnillpath) {
        this.thumbnillpath = thumbnillpath;
    }

    public String getEventdatetime() {
        return eventdatetime;
    }

    public void setEventdatetime(String eventdatetime) {
        this.eventdatetime = eventdatetime;
    }
}

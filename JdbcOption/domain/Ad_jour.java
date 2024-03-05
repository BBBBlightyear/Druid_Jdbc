package JdbcOption.domain;

import java.sql.Timestamp;

public class Ad_jour {

    private String Event_content;
    private Timestamp Event_time;
    private String EID;

    public Ad_jour() {
    }

    public Ad_jour(String event_content, Timestamp event_time, String EID) {
        Event_content = event_content;
        Event_time = event_time;
        this.EID = EID;
    }

    public String getEvent_content() {
        return Event_content;
    }

    public void setEvent_content(String event_content) {
        Event_content = event_content;
    }

    public Timestamp getEvent_time() {
        return Event_time;
    }

    public void setEvent_time(Timestamp event_time) {
        Event_time = event_time;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    @Override
    public String toString() {
        return "Ad_jour{" +
                "Event_content='" + Event_content + '\'' +
                ", Event_time=" + Event_time +
                ", EID='" + EID + '\'' +
                '}';
    }


/*
    create table link_team.adm_journal
(
    Event_content varchar(500)                        not null,
    Event_time    timestamp default CURRENT_TIMESTAMP not null,
    EID           varchar(10)                         not null
        primary key
);


     */
}

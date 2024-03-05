package JdbcOption.domain;
import java.sql.Timestamp;

public class User_jour {

    private String Event_ID;
    private String launcherID;
    private String receiverID;
    private String Event_content;
    private Timestamp Event_Time;

    public User_jour() {
    }

    public User_jour(String event_ID, String launcherID, String receiverID, String event_content, Timestamp event_Time) {
        Event_ID = event_ID;
        this.launcherID = launcherID;
        this.receiverID = receiverID;
        Event_content = event_content;
        Event_Time = event_Time;
    }

    public String getEvent_ID() {
        return Event_ID;
    }

    public void setEvent_ID(String event_ID) {
        Event_ID = event_ID;
    }

    public String getLauncherID() {
        return launcherID;
    }

    public void setLauncherID(String launcherID) {
        this.launcherID = launcherID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public String getEvent_content() {
        return Event_content;
    }

    public void setEvent_content(String event_content) {
        Event_content = event_content;
    }

    public Timestamp getEvent_Time() {
        return Event_Time;
    }

    public void setEvent_Time(Timestamp event_Time) {
        Event_Time = event_Time;
    }

    @Override
    public String toString() {
        return "User_jour{" +
                "Event_ID='" + Event_ID + '\'' +
                ", launcherID='" + launcherID + '\'' +
                ", receiverID='" + receiverID + '\'' +
                ", Event_content='" + Event_content + '\'' +
                ", Event_Time=" + Event_Time +
                '}';
    }


    /*
    create table link_team.user_journal
(
    Event_ID      varchar(10)                         not null
        primary key,
    launcherID    varchar(10)                         not null,
    receiverID    varchar(10)                         not null,
    Event_content varchar(100)                        not null,
    Event_Time    timestamp default CURRENT_TIMESTAMP not null,
    constraint User_journal_Event_ID_uindex
        unique (Event_ID)
);


     */
}

package JdbcOption.domain;

public class Group {

    private String TID;
    private String UID;
    private String Work_labor;
    private String CID;


    public Group() {
    }

    public Group(String TID, String UID, String work_labor, String CID) {
        this.TID = TID;
        this.UID = UID;
        Work_labor = work_labor;
        this.CID = CID;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getWork_labor() {
        return Work_labor;
    }

    public void setWork_labor(String work_labor) {
        Work_labor = work_labor;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    @Override
    public String toString() {
        return "Group{" +
                "TID='" + TID + '\'' +
                ", UID='" + UID + '\'' +
                ", Work_labor='" + Work_labor + '\'' +
                ", CID='" + CID + '\'' +
                '}';
    }

    /*
    create table link_team.group_table
(
    TID        varchar(10)  not null,
    UID        varchar(10)  not null,
    Work_labor varchar(500) null,
    CID        varchar(20)  null,
    primary key (TID, UID),
    constraint TID
        unique (TID)
);


     */
}

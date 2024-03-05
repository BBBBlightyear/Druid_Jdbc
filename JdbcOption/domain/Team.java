package JdbcOption.domain;


public class Team {
    private String TID;
    private String TName;
    private String Introduction;
    private String Start_time;
    private String End_time;
    private int Max_Num;
    private int Exist_num;
    private Boolean complete;
    private String UID_leader;

    public Team(){}

    public Team(String TName, String introduction, String start_time, int exist_num, String UID_leader) {
        this.TName = TName;
        Introduction = introduction;
        Start_time = start_time;
        Exist_num = exist_num;
        this.UID_leader = UID_leader;
    }

    public Team(String TID, String TName, String introduction, String start_time, String end_time, int max_Num, int exist_num, Boolean complete, String UID_leader) {
        this.TID = TID;
        this.TName = TName;
        Introduction = introduction;
        Start_time = start_time;
        End_time = end_time;
        Max_Num = max_Num;
        Exist_num = exist_num;
        this.complete = complete;
        this.UID_leader = UID_leader;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getStart_time() {
        return Start_time;
    }

    public void setStart_time(String start_time) {
        Start_time = start_time;
    }

    public String getEnd_time() {
        return End_time;
    }

    public void setEnd_time(String end_time) {
        End_time = end_time;
    }

    public int getMax_Num() {
        return Max_Num;
    }

    public void setMax_Num(int max_Num) {
        Max_Num = max_Num;
    }

    public int getExist_num() {
        return Exist_num;
    }

    public void setExist_num(int exist_num) {
        Exist_num = exist_num;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getUID_leader() {
        return UID_leader;
    }

    public void setUID_leader(String UID_leader) {
        this.UID_leader = UID_leader;
    }

    @Override
    public String toString() {
        return "Team{" +
                "TID='" + TID + '\'' +
                ", TName='" + TName + '\'' +
                ", Introduction='" + Introduction + '\'' +
                ", Start_time=" + Start_time +
                ", End_time=" + End_time +
                ", Max_Num=" + Max_Num +
                ", Exist_num=" + Exist_num +
                ", complete=" + complete +
                ", UID_leader='" + UID_leader + '\'' +
                '}';
    }

    /*
    create table link_team.team_table
(
    TID          varchar(10)          not null
        primary key,
    TName        varchar(30)          null,
    Introduction varchar(500)         null,
    Start_time   datetime             not null,
    End_time     datetime             not null,
    Max_Num      int                  not null,
    Exist_num    int        default 1 not null,
    complete     tinyint(1) default 0 not null,
    UID_leader   varchar(10)          not null,
    constraint team_table_TID_uindex
        unique (TID)
);



    */
}

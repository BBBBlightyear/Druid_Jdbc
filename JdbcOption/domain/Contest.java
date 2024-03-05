package JdbcOption.domain;

public class Contest {
    private String CID;
    private String C_name;
    private String C_level;
    private String C_class;

    public Contest() {
    }

    public Contest(String CID, String c_name, String c_level, String c_class) {
        this.CID = CID;
        C_name = c_name;
        C_level = c_level;
        C_class = c_class;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getC_level() {
        return C_level;
    }

    public void setC_level(String c_level) {
        C_level = c_level;
    }

    public String getC_class() {
        return C_class;
    }

    public void setC_class(String c_class) {
        C_class = c_class;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "CID='" + CID + '\'' +
                ", C_name='" + C_name + '\'' +
                ", C_level='" + C_level + '\'' +
                ", C_class='" + C_class + '\'' +
                '}';
    }

    /*
    create table link_team.contest_info
(
    CID     varchar(20) not null
        primary key,
    C_name  varchar(20) null,
    C_level varchar(10) null comment 'A类B类C类',
    C_class varchar(10) null comment '学科分类，物理，数学'
);


     */
}

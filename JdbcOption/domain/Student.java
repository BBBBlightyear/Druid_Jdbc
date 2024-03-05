package JdbcOption.domain;

public class Student {
    private String UID;
    private String password;
    private String UName;
    private String Student_ID;
    private String Student_Name;
    private String Tel;
    private String requirement;
    private String Strong_point;
    private String Grade;
    private String Major;
    private String state;

    private String registration_time;

    public String getUID() {
        return UID;
    }

    public Student(String student_ID, String student_Name, String major, String state) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Major = major;
        this.state = state;
    }

    public Student(String student_ID, String student_Name, String tel, String strong_point, String major) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Tel = tel;
        Strong_point = strong_point;
        Major=major;
    }


    public String getRegistration_time() {
        return registration_time;
    }

    public Student(String student_ID, String student_Name, String tel, String strong_point, String grade, String major) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Tel = tel;
        Strong_point = strong_point;
        Grade = grade;
        Major = major;
    }

    public Student(String UName, String student_ID, String student_Name, String tel, String strong_point,String grade, String major, String registration_time,String state) {
        this.UName = UName;
        Student_ID = student_ID;
        Student_Name = student_Name;
        Tel = tel;
        Strong_point=strong_point;
        Grade = grade;
        Major = major;
       this.registration_time= registration_time;
       this.state=state;
    }

    public Student(String UID, String password, String UName, String student_ID, String student_Name, String tel, String requirement, String strong_point, String grade, String major) {
        this.UID = UID;
        this.password = password;
        this.UName = UName;
        Student_ID = student_ID;
        Student_Name = student_Name;
        Tel = tel;
        this.requirement = requirement;
        Strong_point = strong_point;
        Grade = grade;
        Major = major;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getStrong_point() {
        return Strong_point;
    }

    public void setStrong_point(String strong_point) {
        Strong_point = strong_point;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "UID='" + UID + '\'' +
                ", password='" + password + '\'' +
                ", UName='" + UName + '\'' +
                ", Student_ID='" + Student_ID + '\'' +
                ", Student_Name='" + Student_Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", requirement='" + requirement + '\'' +
                ", Strong_point='" + Strong_point + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Major='" + Major + '\'' +
                '}';
    }

    /*
        create table link_team.student_info
                (
        UID               varchar(10)                         not null
        primary key,
        password          varchar(10)                         not null,
        UName             varchar(30)                         not null,
        Student_ID        varchar(10)                         null,
        Student_Name      varchar(30)                         null,
        Tel               varchar(20)                         null,
        requirement       varchar(500)                        null,
        Strong_point      varchar(500)                        null,
        Grade             varchar(5)                          null,
        Major             varchar(10)                         null,
        Registration_time timestamp default CURRENT_TIMESTAMP not null comment 'CURRENT_TIMESTAMP',
        constraint Student_base_UID_uindex
        unique (UID)
    );
    */
    public void seek(){

    }
}

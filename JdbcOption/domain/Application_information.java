package JdbcOption.domain;

public class Application_information {
    public String time;
    public Student student;

    public Application_information(String time, Student student) {
        this.time = time;
        this.student = student;
    }

    public String getTime() {
        return time;
    }

    public Student getStudent() {
        return student;
    }
}

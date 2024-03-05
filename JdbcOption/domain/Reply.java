package JdbcOption.domain;

public class Reply {
    //定义消息发出的时间
    public String time;
    //定义发出消息的用户学号
    public String  send_id;
    //定义消息的内容
    public String message;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reply(String time, String send_id, String message) {
        this.time = time;
        this.send_id = send_id;
        this.message = message;
    }
}

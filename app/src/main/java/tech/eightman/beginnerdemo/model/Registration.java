package tech.eightman.beginnerdemo.model;

/**
 * Created by gilzhaiek on 2016-04-20.
 */
public class Registration {
    private long regid = -1;
    private String email;
    private String password;
    private String mobile;

    public long getRegID() {
        return regid;
    }

    public void setRegID(long regid) {
        this.regid = regid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}

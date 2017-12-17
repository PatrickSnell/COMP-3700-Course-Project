public class User {
    private String userID;
    private String userName;
    private String password;
    private String picture;
    private String isManager;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String isManager() {
        return isManager;
    }

    public void setManager(String manager) {
        this.isManager = manager;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.isManager = picture;
    }

}

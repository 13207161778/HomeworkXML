package com.lanou3g;

public class Peson {
    private UserInter userInter;
    private String userName;
    private String user;
    private String userpassword;
    private String profession;

    public UserInter getUserInter() {
        return userInter;
    }
    public void setUserInter(UserInter userInter) {
        this.userInter = userInter;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public Peson() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Peson(String userName, String user, String userpassword, String profession) {
        super();
        this.userName = userName;
        this.user = user;
        this.userpassword = userpassword;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Peson{" +
                "userName='" + userName + '\'' +
                ", user='" + user + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }

    public void onLine() {
        this.userInter.onLine();
    }
    public void offLine() {
        this.userInter.offLine();
    }
}


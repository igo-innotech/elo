package com.example.elo.model;

public class AcceptTask {
    String userName;
    String userTask;
    int id;

    public AcceptTask(String userName, String userTask, int id)  {
        this.userName = userName;
        this.userTask = userTask;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTask() {
        return userTask;
    }

    public void setUserTask(String userTask) {
        this.userTask = userTask;
    }
}

package edu.cmu.sportsmatching.ui.home;

public class Chat {

    private String targetUser;
    private String content;

    public Chat(String targetUser, String content) {
        this.targetUser = targetUser;
        this.content = content;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
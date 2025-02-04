package com.example.miniproject2todolist;

public class Task {
    private String title;
    private String assignee;
    private int priority;
    private String status;

    // 기본 생성자
    public Task() {}

    // 매개변수를 받는 생성자
    public Task(String title, String assignee, int priority, String status) {
        this.title = title;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    // Getter와 Setter 메서드
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                '}';
    }
}

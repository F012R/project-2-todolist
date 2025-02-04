package kr.or.f012r.todo;

import java.time.LocalDateTime;

public class TodoDto {
    private long id;
    private String title;
    private String name;
    private int sequence;
    private String type;
    private LocalDateTime regDate;

    public TodoDto() {
    }

    public TodoDto(long id, String title, String name, int sequence, String type, LocalDateTime regDate) {
        id = id;
        title = title;
        name = name;
        sequence = sequence;
        type = type;
        regDate = regDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        regDate = regDate;
    }

    @Override
    public String toString() {
        return "TodoDto [id=" + id + ", title=" + title + ", name=" + name + 
               ", sequence=" + sequence + ", type=" + type + ", regDate=" + regDate + "]";
    }
}
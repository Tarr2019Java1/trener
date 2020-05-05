package pl.sda.todoapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean completed;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date closeDate;

    public Todo() {
        createDate = new Date();
    }

    public Todo(String name, boolean completed) {
        this();
        this.name = name;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {

        if (this.completed) {
            return;
        }

        this.completed = completed;

        if (completed) {
            this.closeDate = new Date();
        }
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }
}

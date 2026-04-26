package com.sabtok.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="INCOMING_LOG")
//@SequenceGenerator(name = "log_seq", sequenceName = "log_seq_id", allocationSize = 1)
@Data
public class IncomingLog implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "SOURCE")
    private String source;

    public IncomingLog() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

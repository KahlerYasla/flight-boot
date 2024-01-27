package com.vafaill.flightboot.dao.base;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.vafaill.flightboot.dao.Status;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDAO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status = Status.ACTIVE;

    public BaseDAO(Long id) {
        this.id = id;
        this.status = Status.ACTIVE;
    }

    // #region Getters and Setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // #endregion
}

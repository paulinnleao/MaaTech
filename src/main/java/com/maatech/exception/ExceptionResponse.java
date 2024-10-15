package com.maatech.exception;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String description;
    private String message;
    private Date timestamp;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String description) {
        this.description = description;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResponse that = (ExceptionResponse) o;
        return Objects.equals(description, that.description) && Objects.equals(message, that.message) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, message, timestamp);
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "description='" + description + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

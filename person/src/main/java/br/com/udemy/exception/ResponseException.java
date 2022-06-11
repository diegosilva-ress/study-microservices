package br.com.udemy.exception;

import java.io.Serializable;
import java.util.Date;

public class ResponseException implements Serializable {

    private static final long serialVersionUID = -5111028120529417477L;

    private Date timestamp;
    private String msg;
    private String details;

    public ResponseException(Date timestamp, String msg, String details) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public String getDetails() {
        return details;
    }
}

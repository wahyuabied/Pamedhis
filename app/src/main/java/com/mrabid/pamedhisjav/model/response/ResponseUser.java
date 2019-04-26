package com.mrabid.pamedhisjav.model.response;

import com.mrabid.pamedhisjav.model.Resep;
import com.mrabid.pamedhisjav.model.User;

import java.io.Serializable;

public class ResponseUser implements Serializable {
    private Boolean status;
    private String message;
    private User data;

    public ResponseUser(ResponseUser x) {
        this.status = x.getStatus();
        this.message = x.getMessage();
        this.data = x.getData();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}

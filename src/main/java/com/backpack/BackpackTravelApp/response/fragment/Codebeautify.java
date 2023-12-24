package com.backpack.BackpackTravelApp.response.fragment;

public class Codebeautify {
    private String status;
    private String requestId;
    Message MessageObject;
    Data DataObject;


    // Getter Methods

    public String getStatus() {
        return status;
    }

    public String getRequestId() {
        return requestId;
    }

    public Message getMessage() {
        return MessageObject;
    }

    public Data getData() {
        return DataObject;
    }

    // Setter Methods

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setMessage(Message messageObject) {
        this.MessageObject = messageObject;
    }

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }
}

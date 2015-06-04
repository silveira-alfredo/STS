package com.android.bibi.utils;

/**
 * Created by jsalgado on 04/06/15.
 */
enum DialogMessageType {
    ALERT("A"), ERROR("E"), INFORMATIVE("I"), OTHER("O");

    private String messageType;

    private DialogMessageType(String s) {
        messageType = s;
    }

    public String getMessageType() {
        return messageType;
    }

}

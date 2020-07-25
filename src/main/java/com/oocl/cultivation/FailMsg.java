package com.oocl.cultivation;

public enum FailMsg {
    FAIL_MSG(""), MANAGER_MSG("");
    private String msg;

    FailMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

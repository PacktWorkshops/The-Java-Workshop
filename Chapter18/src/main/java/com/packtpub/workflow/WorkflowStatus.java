package com.packtpub.workflow;

public class WorkflowStatus {
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";

    private String id;
    private String status = OK;


    public WorkflowStatus(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public boolean isOk() {
        if (OK.equals(status)) {
            return true;
        }
        return false;
    }
}

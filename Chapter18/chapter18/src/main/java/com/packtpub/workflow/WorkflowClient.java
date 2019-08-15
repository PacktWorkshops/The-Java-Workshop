package com.packtpub.workflow;

public class WorkflowClient {

    public WorkflowStatus getStatus(String id) {
        // This would use HTTP to get the status.
        return new WorkflowStatus(id, WorkflowStatus.OK);
    }
}

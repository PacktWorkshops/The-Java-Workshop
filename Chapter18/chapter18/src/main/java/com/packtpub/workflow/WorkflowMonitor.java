package com.packtpub.workflow;

public class WorkflowMonitor {
    private EmailNotifier emailNotifier;
    private WorkflowClient workflowClient;

    public WorkflowMonitor(EmailNotifier emailNotifier,
                           WorkflowClient workflowClient) {
        this.emailNotifier = emailNotifier;
        this.workflowClient = workflowClient;
    }

    public void checkStatus(String id) {
        WorkflowStatus workflowStatus = workflowClient.getStatus(id);

        if (!workflowStatus.isOk()) {
            emailNotifier.sendFailureEmail(workflowStatus);
        }
    }
}

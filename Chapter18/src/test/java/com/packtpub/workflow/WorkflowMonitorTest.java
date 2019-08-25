package com.packtpub.workflow;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkflowMonitorTest {
    private EmailNotifier emailNotifier;
    private WorkflowClient workflowClient;
    private WorkflowMonitor workflowMonitor;

    @BeforeAll
    public void setUpMocks() {
        emailNotifier = mock(EmailNotifier.class);
        workflowClient = mock(WorkflowClient.class);

        workflowMonitor =
                new WorkflowMonitor(emailNotifier, workflowClient);
    }


    @Test
    public void testSuccess() {
        String id = "WORKFLOW-1";
        WorkflowStatus workflowStatus =
                new WorkflowStatus(id, WorkflowStatus.OK);

        when(workflowClient.getStatus(id)).thenReturn(workflowStatus);

        workflowMonitor.checkStatus(id);

        verify(emailNotifier, times(0)).sendFailureEmail(workflowStatus);
    }

    @Test
    public void testFailure() {
        String id = "WORKFLOW-1";
        WorkflowStatus workflowStatus =
                new WorkflowStatus(id, WorkflowStatus.ERROR);

        when(workflowClient.getStatus(anyString())).thenReturn(workflowStatus);

        workflowMonitor.checkStatus(id);

        verify(emailNotifier).sendFailureEmail(workflowStatus);
    }
}

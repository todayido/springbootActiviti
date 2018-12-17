package com.example.demo.task;

import com.example.demo.loader.StartConfig;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendEmail implements JavaDelegate {
    private static final Log logger = LogFactory.getLog(SendEmail.class);

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.debug("Vacaton Approved, sending an mail to the user who applied for.");
    }
}

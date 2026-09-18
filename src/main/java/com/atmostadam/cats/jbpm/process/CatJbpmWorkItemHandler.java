package com.atmostadam.cats.jbpm.process;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CatJbpmWorkItemHandler implements WorkItemHandler {
    public static final Logger logger = LoggerFactory.getLogger(CatJbpmWorkItemHandler.class);

    private KieSession ksession;

    public CatJbpmWorkItemHandler(KieSession ksession) {
        this.ksession = ksession;
    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        logger.info("[{}:{}]", workItem.getName(), "executeWorkItem");
        manager.completeWorkItem(workItem.getId(), Map.of());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        logger.info("[{}:{}]", workItem.getName(), "abortWorkItem");
    }
}

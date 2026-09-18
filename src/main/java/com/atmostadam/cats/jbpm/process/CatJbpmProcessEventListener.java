package com.atmostadam.cats.jbpm.process;

import org.kie.api.event.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatJbpmProcessEventListener implements ProcessEventListener {
    public static final Logger logger = LoggerFactory.getLogger(CatJbpmProcessEventListener.class);

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        logger.info("[{}:{}] {}",
                "beforeProcessStarted",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId());
    }

    @Override
    public void afterProcessStarted(ProcessStartedEvent event) {
        logger.info("[{}:{}] {}",
                "afterProcessStarted",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId());
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        logger.info("[{}:{}] {}",
                "beforeProcessCompleted",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId());
    }

    @Override
    public void afterProcessCompleted(ProcessCompletedEvent event) {
        logger.info("[{}:{}] {}",
                "afterProcessCompleted",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId());
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        logger.info("[{}:{}] {} {}",
                "beforeNodeTriggered",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        logger.info("[{}:{}] {} {}",
                "afterNodeTriggered",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        logger.info("[{}:{}] {} {}",
                "beforeNodeLeft",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        logger.info("[{}:{}] {} {}",
                "afterNodeLeft",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getNodeInstance().getNodeName());
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        logger.info("[{}:{}] {} {} {}",
                "beforeVariableChanged",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getVariableId(),
                event.getOldValue(),
                event.getNewValue());
    }

    @Override
    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        logger.info("[{}:{}] {} {} {}",
                "afterVariableChanged",
                event.getProcessInstance().getProcessId(),
                event.getProcessInstance().getId(),
                event.getVariableId(),
                event.getOldValue(),
                event.getNewValue());
    }

    @Override
    public void beforeSLAViolated(SLAViolatedEvent event) {
        ProcessEventListener.super.beforeSLAViolated(event);
    }

    @Override
    public void afterSLAViolated(SLAViolatedEvent event) {
        ProcessEventListener.super.afterSLAViolated(event);
    }

    @Override
    public void onSignal(SignalEvent event) {
        ProcessEventListener.super.onSignal(event);
    }

    @Override
    public void onMessage(MessageEvent event) {
        ProcessEventListener.super.onMessage(event);
    }

    @Override
    public void onAsyncNodeScheduledEvent(ProcessAsyncNodeScheduledEvent event) {
        ProcessEventListener.super.onAsyncNodeScheduledEvent(event);
    }
}

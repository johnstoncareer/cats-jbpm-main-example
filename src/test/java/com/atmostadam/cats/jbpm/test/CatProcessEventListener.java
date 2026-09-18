package com.atmostadam.cats.jbpm.test;

import org.kie.api.event.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static com.atmostadam.cats.jbpm.test.CatProcessEvent.EventType.*;

public class CatProcessEventListener implements ProcessEventListener {
    Logger logger = LoggerFactory.getLogger(CatProcessEventListener.class);

    private final List<CatProcessEvent> events = new LinkedList<>();
    private int position = -1;

    public CatProcessEvent nextEvent() {
        position++;
        return events.get(position);
    }

    public void skipEvent() {
        position++;
    }

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        events.add(new CatProcessEvent(BEFORE_PROCESS_STARTED, event));
    }

    @Override
    public void afterProcessStarted(ProcessStartedEvent event) {
        events.add(new CatProcessEvent(AFTER_PROCESS_STARTED, event));
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        events.add(new CatProcessEvent(BEFORE_PROCESS_COMPLETED, event));
    }

    @Override
    public void afterProcessCompleted(ProcessCompletedEvent event) {
        events.add(new CatProcessEvent(AFTER_PROCESS_COMPLETED, event));
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        events.add(new CatProcessEvent(BEFORE_NODE_TRIGGERED, event));
    }

    @Override
    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        events.add(new CatProcessEvent(AFTER_NODE_TRIGGERED, event));
    }

    private void addEvent(CatProcessEvent.EventType type, ProcessEvent event) {
        CatProcessEvent catEvent = new CatProcessEvent(type, event);
        logger.info("EVENT CAPTURED: " + event);
        events.add(catEvent);
    }

    private void addNodeEvent(CatProcessEvent.EventType type, ProcessNodeEvent event) {
        events.add(new CatProcessEvent(type, event));
    }

    private void addVariableEvent(CatProcessEvent.EventType type, ProcessVariableChangedEvent event) {
        events.add(new CatProcessEvent(type, event));
    }

    private void logEvent(CatProcessEvent event) {

    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        events.add(new CatProcessEvent(BEFORE_NODE_LEFT, event));
    }

    @Override
    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        events.add(new CatProcessEvent(AFTER_NODE_LEFT, event));
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        events.add(new CatProcessEvent(BEFORE_VARIABLE_CHANGED, event));
    }

    @Override
    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        events.add(new CatProcessEvent(AFTER_VARIABLE_CHANGED, event));
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

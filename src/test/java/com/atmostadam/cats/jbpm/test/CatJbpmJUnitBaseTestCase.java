package com.atmostadam.cats.jbpm.test;

import com.atmostadam.cats.jbpm.process.CatJbpmWorkItemHandler;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;

public abstract class CatJbpmJUnitBaseTestCase extends JbpmJUnitBaseTestCase {
    protected RuntimeManager runtimeManager;
    protected RuntimeEngine runtimeEngine;
    protected KieSession ksession;
    protected String processName;
    protected CatProcessEventListener eventListener = new CatProcessEventListener();

    public CatJbpmJUnitBaseTestCase() {
        super(false, false);
    }

    public void fireProcess(String processName) {
        ksession = runtimeEngine.getKieSession();

        ksession.getWorkItemManager().registerWorkItemHandler("CatTask", new CatJbpmWorkItemHandler(ksession));

        ksession.addEventListener(eventListener);

        ProcessInstance processInstance = ksession.startProcess(processName);

        assertProcessInstanceNotActive(processInstance.getId(), ksession);
    }
}

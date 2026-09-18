package com.atmostadam.cats.jbpm.bpmn;

import com.atmostadam.cats.jbpm.process.CatJbpmWorkItemHandler;
import com.atmostadam.cats.jbpm.test.CatJbpmJUnitBaseTestCase;
import com.atmostadam.cats.jbpm.test.CatProcessEventListener;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

import static com.atmostadam.cats.jbpm.test.CatProcessEventAsserts.*;

public class OnboardCatUnitTest extends CatJbpmJUnitBaseTestCase {
    private static final String ONBOARD_CAT = "onboard_cat";

    @Test
    void onboardCat() {
        runtimeManager = createRuntimeManager("onboard_cat.bpmn2");

        runtimeEngine = getRuntimeEngine();

        KieSession ksession = runtimeEngine.getKieSession();

        ksession.getWorkItemManager().registerWorkItemHandler("CatTask", new CatJbpmWorkItemHandler(ksession));

        CatProcessEventListener listener = new CatProcessEventListener();
        ksession.addEventListener(listener);

        ProcessInstance processInstance = ksession.startProcess(ONBOARD_CAT);

        assertProcessInstanceNotActive(processInstance.getId(), ksession);

        fireProcess(ONBOARD_CAT);

        assertBeforeProcessStarted(listener, ONBOARD_CAT);

        //assertAfterProcessStarted(listener);

        // TODO: Assert Nodes

        assertBeforeProcessCompleted();

        assertAfterProcessCompleted();

        assertNodeTriggered(processInstance.getId(),
                "Start",
                "Microchip Number Lookup",
                "Register New Cat",
                "Find Foster With Availability",
                "List Cat on Petfinder",
                "List Cat on Adopt-a-Pet",
                "End");
    }
}

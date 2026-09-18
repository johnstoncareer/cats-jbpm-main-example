package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.exception.CatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CatJbpmService {
    Logger logger = LoggerFactory.getLogger(CatJbpmService.class);

    public static final String SRC_DIR = "./src";

    public static final String JBPM_EXT = ".bpmn2";

    @Autowired
    private BuildProperties buildProperties;
        /*

    @Autowired
    private KieServer kieServer;

    //@Autowired
    //private DeploymentService deploymentService;


    @PostConstruct
    public void setup() {
        String containerId = "cats-kjar:0.0.42";
        ReleaseId releaseId = new ReleaseId(buildProperties.getGroup(), buildProperties.getArtifact(),
                buildProperties.getVersion());
        KieContainerResource container =
                new KieContainerResource(containerId, releaseId, KieContainerStatus.STARTED);
        ServiceResponse<KieContainerResource> response  = kieServer.createContainer(containerId, container);

    }


    @Autowired
    private CatKieService kieService;

    private KieContainer kieContainer;
*/

    @PostConstruct
    protected void setupOther() throws CatException {
    /*
        KieServices ks = KieServices.Factory.get();
        Map<String, Resource> kieFiles = kieService.loadKieFiles(SRC_DIR, JBPM_EXT);
        logger.info("Kie Maven dependency found [{}] bpmn2 files", kieFiles.size());
        if (kieFiles.size() == 0) {
            throw new IllegalStateException(
                    "Illegal State in Classloader. Kie Maven dependency found zero bpmn2 files.");
        }
        KieFileSystem kfs = kieService.writeResources(ks, kieFiles);
        ks.newKieBuilder(kfs).buildAll();
        kieContainer = ks.newKieContainer(ks.newReleaseId(
                buildProperties.getGroup(),
                buildProperties.getArtifact(),
                buildProperties.getVersion()));
     */
    }

}

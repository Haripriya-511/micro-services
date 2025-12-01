package com.demo.configclient.info;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BuildInfoController {
    private final BuildInfo buildInfo;
    public BuildInfoController(BuildInfo buildInfo){
        this.buildInfo=buildInfo;
    }
    @GetMapping("/build-info")
    public String getBuildInfo() {
        return "Build ID: " + buildInfo.getId() + ", Version: " + buildInfo.getVersion() + ", Name: " + buildInfo.getName()+", Type: "+buildInfo.getType()+", Date: "+buildInfo.getDate();
    }
}
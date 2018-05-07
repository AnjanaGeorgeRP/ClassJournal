package com.myapplicationdev.android.classjournal;

public class Module {
    private String module;
    private String moduleCode;
    private String moduleLink;

    public Module(String module, String moduleCode, String moduleLink) {
        this.module = module;
        this.moduleCode = moduleCode;
        this.moduleLink = moduleLink;
    }

    public String getModule() {
        return module;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleLink() {
        return moduleLink;
    }
}

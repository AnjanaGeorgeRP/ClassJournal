package com.myapplicationdev.android.classjournal;

public class DailyCA {
    String dgGrade;
    String moduleCode;
    int week;

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public void setDgGrade(String dgGrade) {
        this.dgGrade = dgGrade;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}

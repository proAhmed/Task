package com.ahmed.testforapp.util.convertor;

import java.util.List;

public class OrgFact {
    private List<String> OrgFactList;

    public OrgFact(List<String> orgFactList) {
        this.OrgFactList = orgFactList;
    }

    public List<String> getOrgFact() {
        return OrgFactList;
    }

    public void setOrgFact(List<String> orgFactList) {
        this.OrgFactList = orgFactList;
    }
}

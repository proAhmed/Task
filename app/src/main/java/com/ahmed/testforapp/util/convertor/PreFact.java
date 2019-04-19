package com.ahmed.testforapp.util.convertor;

import java.util.List;

public class PreFact {
    private List<String> preFactList;

    public PreFact(List<String> preFactList) {
        this.preFactList = preFactList;
    }

    public List<String> getOrgFact() {
        return preFactList;
    }

    public void setOrgFact(List<String> preFactList) {
        this.preFactList = preFactList;
    }
}

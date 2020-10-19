package com.interview.coding.challenge.steps;

import com.interview.coding.challenge.GlobalHooks;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseUtil;

public class Hooks {
    protected static String browser;
    private GlobalHooks globalHooks;
    private BaseUtil base;

    public Hooks(BaseUtil base, GlobalHooks globalHooks) {
        this.globalHooks = globalHooks;
        this.base = base;
    }

    @Before(order = 0)
    public void setUp(Scenario scenario) throws Exception {
        globalHooks.setUP(scenario, base);
    }

    @After
    public void tearDown(Scenario scenario) throws Exception{
        globalHooks.tearDown(scenario, base);
    }

}

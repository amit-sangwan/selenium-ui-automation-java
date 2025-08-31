package tests;

import base.BaseTest;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void test() {
        driver.get(baseUrl);
    }
}

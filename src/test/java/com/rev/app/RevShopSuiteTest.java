package com.rev.app;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("RevShop Full Application Test Suite")
@SelectPackages("com.rev.app")
public class RevShopSuiteTest {
}
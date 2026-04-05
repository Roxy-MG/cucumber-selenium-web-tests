package com.goosying.cucumber.runner;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
// 使用cucumber执行测试
@IncludeEngines("cucumber")
// feature在classpath的位置
@SelectClasspathResource("features")
// 报告生成的目录
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/cucumber.html, json:target/cucumber-reports/cucumber.json")
// steps位置
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.goosying.cucumber.steps")
// 并行开关
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true")
// 并行策略，若要使用动态策略，将value设置为dynamic
@ConfigurationParameter(key = "cucumber.execution.parallel.config.strategy", value = "fixed")
// 固定策略下的目标线程数
@ConfigurationParameter(key = "cucumber.execution.parallel.config.fixed.parallelism", value = "2")
// 固定策略下的最大线程数
@ConfigurationParameter(key = "cucumber.execution.parallel.config.fixed.max-pool-size", value = "2")
// 并行执行模式
@ConfigurationParameter(key = "cucumber.execution.execution-mode", value = "concurrent")
public class RunCucumberTest {

}

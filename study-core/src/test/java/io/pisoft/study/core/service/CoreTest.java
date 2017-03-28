package io.pisoft.study.core.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"classpath:beans.xml", "classpath:beans-jpa-h2.xml"})
public class CoreTest extends AbstractTestNGSpringContextTests {
	
}

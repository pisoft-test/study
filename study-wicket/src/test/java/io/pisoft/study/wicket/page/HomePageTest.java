package io.pisoft.study.wicket.page;

import org.testng.annotations.Test;

import com.ttdev.wicketpagetest.WebPageTestContext;
import com.ttdev.wicketpagetest.WicketSeleniumDriver;

public class HomePageTest {

	@Test
	public void testCurrentDisplay() {

		WicketSeleniumDriver ws = WebPageTestContext.getWicketSelenium();
		ws.openNonBookmarkablePage(HomePage.class);

		assert ws.isElementPresent("//submitOrder");
		assert ws.isElementPresent("//queryOrder");
		assert ws.isElementPresent("//sendOrReceive");
	}
}

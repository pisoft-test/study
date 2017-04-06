package io.pisoft.study.wicket.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {

		add(new Link<Void>("submitOrder") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(SubmitOrderPage.class);
			}
		});

		add(new Link<Void>("queryOrder") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(QueryOrderPage.class);
			}
		});
		
		add(new Link<Void>("sendOrReceive") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(SendOrReceivePage.class);
			}
		});
	}

}

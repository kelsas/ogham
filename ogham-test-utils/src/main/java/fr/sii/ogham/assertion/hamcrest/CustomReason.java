package fr.sii.ogham.assertion.hamcrest;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class CustomReason<T> extends BaseMatcher<T> implements DecoratorMatcher<T> {
	private final String reason;
    private final Matcher<T> matcher;
    
	public CustomReason(String reason, Matcher<T> matcher) {
		super();
		this.reason = reason;
		this.matcher = matcher;
	}

	@Override
	public boolean matches(Object item) {
		return matcher.matches(item);
	}

	@Override
	public void describeTo(Description description) {
		matcher.describeTo(description);
	}
	
	public String getReason() {
		return reason;
	}
	
	public Matcher<T> getDecoree() {
		return matcher;
	}
	
}
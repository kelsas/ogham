package fr.sii.ogham.assertion.sms;

import java.util.Collection;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.jsmpp.bean.SubmitSm;

public class ReceivedSmsAssert {
	/**
	 * List of received messages
	 */
	private final List<SubmitSm> actual;

	public ReceivedSmsAssert(List<SubmitSm> actual) {
		this.actual = actual;
	}

	/**
	 * Access fluent API to write assertions on a particular received message.
	 * 
	 * If you want to make assertions on several messages, you may prefer using:
	 * 
	 * <pre>
	 * .receivedMessages().message(0)
	 *                       .content(is("foobar"))
	 *                    .and()
	 *                    .message(1)
	 *                       .content(is("bar"))
	 * </pre>
	 * 
	 * @param index
	 *            the index of the received message
	 * @return the fluent API for assertions on the particular message
	 */
	public SmsAssert<ReceivedSmsAssert> receivedMessage(int index) {
		return new SmsAssert<>(actual.get(index), this);
	}

	/**
	 * Fluent API to write assertions on received messages.
	 * 
	 * You can write assertions for all messages or a particular message.
	 * 
	 * For example, for writing assertion on a single message, you can write:
	 * 
	 * <pre>
	 * .receivedMessages().message(0)
	 *                       .content(is("foobar"))
	 * </pre>
	 * 
	 * For writing assertions that are applied on every received message, you
	 * can write:
	 * 
	 * <pre>
	 * .receivedMessages().forEach()
	 *                       .content(is("foobar"))
	 * </pre>
	 * 
	 * Will check that content of every message is "foobar".
	 * 
	 * <p>
	 * You can use this method to factorize several assertions on a message and
	 * then make dedicated assertions on some messages:
	 * 
	 * <pre>
	 * .receivedMessages().forEach()
	 *                       .content(is("foobar"))
	 *                    .and()
	 *                    .message(0)
	 *                       .from().number(is("+33102030405"))
	 * </pre>
	 * 
	 * Will check that content of every message is "foobar" and that phone
	 * nuumber of sender of first received message is "+33102030405".
	 * 
	 * @return the fluent API for assertions on messages
	 */
	public SmsListAssert<ReceivedSmsAssert> receivedMessages() {
		return new SmsListAssert<>(actual, this);
	}

	/**
	 * Fluent API to write assertions on received messages.
	 * 
	 * Make an assertion on received messages list (JavaMail message).
	 * 
	 * For example, for writing assertion on a single message, you can write:
	 * 
	 * <pre>
	 * .receivedMessages(is(Matchers.&lt;Message&gt;empty()))
	 * </pre>
	 * 
	 * @param matcher
	 *            the assertion to apply on message list
	 * @return the fluent API for assertions on messages
	 */
	public SmsListAssert<ReceivedSmsAssert> receivedMessages(Matcher<Collection<? extends SubmitSm>> matcher) {
		MatcherAssert.assertThat(actual, matcher);
		return receivedMessages();
	}

}

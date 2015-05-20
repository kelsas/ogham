package fr.sii.notification.core.message.content;

import fr.sii.notification.core.template.context.BeanContext;
import fr.sii.notification.core.template.context.Context;

/**
 * Content that points to a template. The template contains variables. The
 * template will be evaluated with the provided context (variable values).
 * 
 * @author Aurélien Baudet
 *
 */
public class TemplateContent implements Content {
	/**
	 * The path to the template
	 */
	private String path;

	/**
	 * The context (variable values)
	 */
	private Context context;

	/**
	 * Initialize the content with the template and the context.
	 * 
	 * @param path
	 *            the path to the template
	 * @param context
	 *            the context (variable values)
	 */
	public TemplateContent(String path, Context context) {
		super();
		this.path = path;
		this.context = context;
	}

	/**
	 * Shortcut for directly using any object as source for variable
	 * substitutions.
	 * 
	 * @param path
	 *            the path to the template
	 * @param bean
	 *            the object that contains the variable values
	 */
	public TemplateContent(String path, Object bean) {
		this(path, new BeanContext(bean));
	}

	public String getPath() {
		return path;
	}

	public Context getContext() {
		return context;
	}
}

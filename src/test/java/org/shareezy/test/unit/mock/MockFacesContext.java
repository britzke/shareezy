/**
 * 
 */
package org.shareezy.test.unit.mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;

/**
 * Ein FacesContext, er es im Nachhinein ermöglicht festzustellen, ob ein
 * FacesMessage hinzugefügt wurde.
 * 
 * @author burghard.britzke mailto:bubi@charmides.in-berlin.de
 */
public class MockFacesContext extends FacesContext {

	private final List<FacesMessage> messages;

	/**
	 * Erzeugt einen neuen MockFacesContext. Initalisiert die Liste der
	 * Hinweise.
	 */
	public MockFacesContext() {
		messages = new ArrayList<FacesMessage>();
	}

	@Override
	public void addMessage(String clientId, FacesMessage message) {
		messages.add(message);
	}

	@Override
	public Iterator<FacesMessage> getMessages() {
		return messages.iterator();
	}

	@Override
	public Application getApplication() {
		return null;
	}

	@Override
	public Iterator<String> getClientIdsWithMessages() {
		return null;
	}

	@Override
	public ExternalContext getExternalContext() {
		return null;
	}

	@Override
	public Severity getMaximumSeverity() {
		return null;
	}

	@Override
	public Iterator<FacesMessage> getMessages(String clientId) {
		return null;
	}

	@Override
	public RenderKit getRenderKit() {
		return null;
	}

	@Override
	public boolean getRenderResponse() {
		return false;
	}

	@Override
	public boolean getResponseComplete() {
		return false;
	}

	@Override
	public ResponseStream getResponseStream() {
		return null;
	}

	@Override
	public ResponseWriter getResponseWriter() {
		return null;
	}

	@Override
	public UIViewRoot getViewRoot() {
		return null;
	}

	@Override
	public void release() {
	}

	@Override
	public void renderResponse() {
	}

	@Override
	public void responseComplete() {
	}

	@Override
	public void setResponseStream(ResponseStream responseStream) {
	}

	@Override
	public void setResponseWriter(ResponseWriter responseWriter) {
	}

	@Override
	public void setViewRoot(UIViewRoot root) {
	}
}

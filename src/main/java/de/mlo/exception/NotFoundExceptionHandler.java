package de.mlo.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class NotFoundExceptionHandler.
 */
public class NotFoundExceptionHandler implements AccessDeniedHandler {
	
	/** The logger. */
	static Logger logger = LoggerFactory
			.getLogger(NotFoundExceptionHandler.class);

	/** The error page. */
	private String errorPage;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
	 */
	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response, AccessDeniedException arg2)
			throws IOException, ServletException {

		logger.debug(String.format("### NotFoundExceptionHandler: URL [%s] ",
				request.getServletPath()));
		logger.debug("### Error page: [" + errorPage + "]");
		// response.sendRedirect(getErrorPage());
		request.getRequestDispatcher(errorPage).forward(request, response);
	}

	/**
	 * Gets the error page.
	 *
	 * @return the error page
	 */
	public String getErrorPage() {
		return errorPage;
	}

	/**
	 * Sets the error page.
	 *
	 * @param errorPage the new error page
	 */
	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}
}

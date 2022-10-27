package github.com.julivanmeridius.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception personalizada. 
 * 
 * @author Julivan Silva
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {

	/** UID **/
	private static final long serialVersionUID = 57270328606043670L;
	
}

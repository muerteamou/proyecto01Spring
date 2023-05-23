package cf.iesguara.proyecto01Spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resource;
	private String field;
	private Object value;

	public RecursoNoEncontradoException(String resource, String field, Object value) {
		super(String.format("%s no encontrado. Campo %s: '%s'", resource, field, value));
		this.resource = resource;
		this.field = field;
		this.value = value;
	}

	public String getResource() {
		return resource;
	}

	public String getField() {
		return field;
	}

	public Object getValue() {
		return value;
	}

}

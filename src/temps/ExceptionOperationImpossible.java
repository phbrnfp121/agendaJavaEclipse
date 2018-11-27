package temps;

/**
 * ExceptionOperationImpossible représente une erreur sur le temps
 *
 * @author LICINFO20182019
 * @version 1
 */
@SuppressWarnings("serial")
public class ExceptionOperationImpossible extends Exception {
	public ExceptionOperationImpossible(String message) {
		super(message);
	}
}

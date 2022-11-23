package email_connector.implementation;

public class OAuthException extends Exception {

    public OAuthException() { super(); }
    public OAuthException(String message) { super(message); }
    public OAuthException(Exception exception) { super(exception); }
    public OAuthException(String message, Exception exception) { super(message, exception); }

}

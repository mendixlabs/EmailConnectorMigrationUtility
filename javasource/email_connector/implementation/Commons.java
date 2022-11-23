package email_connector.implementation;

import com.mendix.datahub.connector.email.model.FetchStrategy;
import com.mendix.datahub.connector.email.model.Protocol;
import email_connector.proxies.ENUM_AttachmentPosition;
import email_connector.proxies.ENUM_IncomingProtocol;
import email_connector.proxies.ENUM_MessageHandling;

public class Commons {

    private Commons() {
    }

    public static Protocol getProtocol(email_connector.proxies.ENUM_IncomingProtocol protocol) {
        if (protocol.name().equals("IMAPS"))
            return Protocol.IMAPS;
        if (protocol.name().equals("IMAP"))
            return Protocol.IMAP;
        else if (protocol.name().equals("POP3"))
            return Protocol.POP3;
        else
            return Protocol.POP3S;
    }

    public static ENUM_IncomingProtocol getIncomingProxyProtocol(Protocol protocol) {
        if (protocol.name().equals("IMAPS"))
            return ENUM_IncomingProtocol.IMAPS;
        if (protocol.name().equals("IMAP"))
            return ENUM_IncomingProtocol.IMAP;
        else if (protocol.name().equals("POP3"))
            return ENUM_IncomingProtocol.POP3;
        else
            return ENUM_IncomingProtocol.POP3S;
    }

    public static ENUM_AttachmentPosition getPosition(String attachmentPosition) {
        if (attachmentPosition.equalsIgnoreCase("attachment"))
            return ENUM_AttachmentPosition.Attachment;
        else
            return ENUM_AttachmentPosition.Inline;
    }

    public static String getHandling(ENUM_MessageHandling messageHandling) {
        if (messageHandling.equals(ENUM_MessageHandling.DeleteMessage))
            return "DeleteMessage";
        else if (messageHandling.equals(ENUM_MessageHandling.MoveMessage))
            return "MoveMessage";
        else
            return "NoHandling";
    }

    public static FetchStrategy getFetchStrategy(email_connector.proxies.ENUM_FetchStrategy fetchStrategy) {
        if (fetchStrategy.name().equalsIgnoreCase("Latest"))
            return FetchStrategy.LATEST;
        else
            return FetchStrategy.OLDEST;
    }
}

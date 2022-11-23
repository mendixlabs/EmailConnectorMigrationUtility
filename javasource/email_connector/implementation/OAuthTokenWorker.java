package email_connector.implementation;

import com.mendix.core.Core;
import com.mendix.datahub.connector.email.service.IMendixWorker;
import com.mendix.datahub.connector.email.utils.MendixWorkerException;
import email_connector.proxies.EmailAccount;
import email_connector.proxies.microflows.Microflows;

public class OAuthTokenWorker implements IMendixWorker<String> {
    EmailAccount emailAccount;
    public OAuthTokenWorker(EmailAccount emailAccount)
    {
        this.emailAccount = emailAccount;
    }
    @Override
    public String doWork(Object... params) throws MendixWorkerException {
        if(emailAccount ==null)
            throw new MendixWorkerException("Email account cannot be empty");
        var context = Core.createSystemContext();
        return Microflows.aCT_GetOrRenewToken(context, emailAccount);
    }
}

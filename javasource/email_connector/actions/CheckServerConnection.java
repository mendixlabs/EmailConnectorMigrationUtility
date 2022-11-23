// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package email_connector.actions;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.datahub.connector.email.model.ReceiveEmailAccount;
import com.mendix.datahub.connector.email.model.SendEmailAccount;
import com.mendix.datahub.connector.email.service.EmailServiceWorker;
import com.mendix.datahub.connector.email.utils.ReceiveMailsException;
import com.mendix.datahub.connector.email.utils.SendMailsException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import email_connector.implementation.MxMailMapper;
import email_connector.proxies.IncomingEmailConfiguration;
import email_connector.proxies.OutgoingEmailConfiguration;
import email_connector.proxies.constants.Constants;
import encryption.proxies.microflows.Microflows;
import static email_connector.implementation.Commons.getProtocol;

public class CheckServerConnection extends CustomJavaAction<java.lang.Void>
{
	private IMendixObject __EmailAccount;
	private email_connector.proxies.EmailAccount EmailAccount;

	public CheckServerConnection(IContext context, IMendixObject EmailAccount)
	{
		super(context);
		this.__EmailAccount = EmailAccount;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		this.EmailAccount = __EmailAccount == null ? null : email_connector.proxies.EmailAccount.initialize(getContext(), __EmailAccount);

		// BEGIN USER CODE
		if (this.EmailAccount == null) {
			throw new ReceiveMailsException("EmailAccount cannot be null.");
		}
		var finalErrorMsg = new StringBuilder();

		var isIncomingServerConnected = checkIncomingServerConnection(finalErrorMsg);
		var isOutgoingServerConnected = checkOutgoingServerConnection(finalErrorMsg);

		if (!isIncomingServerConnected || !isOutgoingServerConnected)
		{
			throw new CoreException(finalErrorMsg.toString());
		}
		return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "CheckServerConnection";
	}

	// BEGIN EXTRA CODE
	private boolean checkIncomingServerConnection(StringBuilder finalErrorMsg) throws ReceiveMailsException, CoreException {
		var isIncomingServerConnected = false;
		var incomingEmailAccounts = Core.retrieveByPath(getContext(), this.EmailAccount.getMendixObject(), IncomingEmailConfiguration.MemberNames.IncomingEmailConfiguration_EmailAccount.toString());
		if(Boolean.TRUE.equals(this.EmailAccount.getisIncomingEmailConfigured()) && !incomingEmailAccounts.isEmpty()) {

			var incomingEmailAccount = IncomingEmailConfiguration.initialize(getContext(),incomingEmailAccounts.get(0));
			var account = new ReceiveEmailAccount(getProtocol(incomingEmailAccount.getIncomingProtocol()), incomingEmailAccount.getServerHost(), incomingEmailAccount.getServerPort(), this.EmailAccount.getUsername(), Microflows.decrypt(getContext(), this.EmailAccount.getPassword()));			try
			{
				MxMailMapper.setReceiveAccountConfigurations(this.EmailAccount, account);
				var emailServiceWorker = new EmailServiceWorker(account);
				isIncomingServerConnected = emailServiceWorker.isConnected();
				if(!isIncomingServerConnected)
					finalErrorMsg.append("Connection with incoming server is failed. ");
			}
			catch (ReceiveMailsException | SendMailsException e) {
				finalErrorMsg.append(String.format("Connection with incoming server is failed with error %s ", e.getMessage()));
				Core.getLogger(Constants.getLogNode()).error("Error while connecting incoming server" , e);
			}

		}
		else
			isIncomingServerConnected = true;

		return isIncomingServerConnected;
	}

	private boolean checkOutgoingServerConnection(StringBuilder finalErrorMsg) throws ReceiveMailsException, CoreException {
		var isOutgoingServerConnected = false;
		var outgoingEmailAccounts = Core.retrieveByPath(getContext(), this.EmailAccount.getMendixObject(), OutgoingEmailConfiguration.MemberNames.OutgoingEmailConfiguration_EmailAccount.toString());
		if(Boolean.TRUE.equals(this.EmailAccount.getisOutgoingEmailConfigured()) && !outgoingEmailAccounts.isEmpty()) {
			var outgoingEmailAccount = OutgoingEmailConfiguration.initialize(getContext(),outgoingEmailAccounts.get(0));
			var account = new SendEmailAccount(outgoingEmailAccount.getServerHost(), outgoingEmailAccount.getServerPort(), this.EmailAccount.getUsername(), Microflows.decrypt(getContext(), this.EmailAccount.getPassword()));			try
			{
				MxMailMapper.setSendAccountConfigurations(this.EmailAccount, account,null,null,context());
				var emailServiceWorker = new EmailServiceWorker(account);
				isOutgoingServerConnected = emailServiceWorker.isConnected();
				if(!isOutgoingServerConnected)
					finalErrorMsg.append("Connection with outgoing server is failed.");
			}
			catch (ReceiveMailsException | SendMailsException e) {
				finalErrorMsg.append(String.format("Connection with outgoing server is failed with error %s ", e.getMessage()));
				Core.getLogger(Constants.getLogNode()).error("Error while connecting outgoing server" , e);
			}
		}
		else
			isOutgoingServerConnected = true;

		return isOutgoingServerConnected;
	}
	// END EXTRA CODE
}
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
import com.mendix.datahub.connector.eventtracking.Metrics;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import email_connector.proxies.ENUM_IncomingProtocol;
import email_connector.proxies.EmailAccount;
import email_connector.proxies.IncomingEmailConfiguration;

public class CalculateIncomingAccountMetrics extends CustomJavaAction<java.lang.Void>
{
	public CalculateIncomingAccountMetrics(IContext context)
	{
		super(context);
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		for (var protocol : ENUM_IncomingProtocol.values())
		{
			var query = "SELECT "+ EmailAccount.entityName +"/"+ EmailAccount.MemberNames.isOAuthUsed.toString() +" FROM "
					+ IncomingEmailConfiguration.entityName +" INNER JOIN "
					+ IncomingEmailConfiguration.entityName +"/"+IncomingEmailConfiguration.MemberNames.IncomingEmailConfiguration_EmailAccount.toString() +"/"+ EmailAccount.entityName
					+ " WHERE " + IncomingEmailConfiguration.MemberNames.IncomingProtocol.toString() + "='" + protocol.getCaption() + "';";
			var request = Core.createOQLTextGetRequest();
			request.setQuery(query);
			var dataTable = Core.retrieveOQLDataTable(getContext(), request);
			var oauthAccCnt=0;
			var basicAccCnt=0;
			if (dataTable.getRowCount() > 0) {
				for (com.mendix.systemwideinterfaces.connectionbus.data.IDataRow row : dataTable) {
					if((boolean) row.getValue(getContext(), 0))
						oauthAccCnt++;
					else
						basicAccCnt++;
				}
			}
			Metrics.createGauge("dnl_connectors_ec_account_configuration")
				.addTag("type", protocol.getCaption())
				.addTag("auth_method",  "basic")
				.addTag("setup", "incoming")
				.setDescription("User sets up account configuration")
				.build()
				.recordValue(basicAccCnt);
			Metrics.createGauge("dnl_connectors_ec_account_configuration")
				.addTag("type", protocol.getCaption())
				.addTag("auth_method",  "oauth")
				.addTag("setup", "incoming")
				.setDescription("User sets up account configuration")
				.build()
				.recordValue(oauthAccCnt);
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
		return "CalculateIncomingAccountMetrics";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

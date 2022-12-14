// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package migrationutility.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the MigrationUtility module
	public static email_connector.proxies.EmailAccount aCT_CreateEmailAccountFromEmailSettings(IContext context, java.lang.String _userName, java.lang.String _password, java.lang.String _server, java.lang.Long _port, java.lang.String _fromAddress, java.lang.String _fromDisplayName, boolean _useSSL, boolean _useTLS, java.lang.Long _maxAttempts, boolean _useSSLCheckServerIdentity, boolean _isOAuthUsed)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("UserName", _userName);
		params.put("Password", _password);
		params.put("Server", _server);
		params.put("Port", _port);
		params.put("FromAddress", _fromAddress);
		params.put("FromDisplayName", _fromDisplayName);
		params.put("UseSSL", _useSSL);
		params.put("UseTLS", _useTLS);
		params.put("MaxAttempts", _maxAttempts);
		params.put("UseSSLCheckServerIdentity", _useSSLCheckServerIdentity);
		params.put("isOAuthUsed", _isOAuthUsed);
		IMendixObject result = (IMendixObject)Core.microflowCall("MigrationUtility.ACT_CreateEmailAccountFromEmailSettings").withParams(params).execute(context);
		return result == null ? null : email_connector.proxies.EmailAccount.initialize(context, result);
	}
	public static email_connector.proxies.OAuthProvider aCT_CreateOAuthProvider(IContext context, email_connector.proxies.EmailAccount _mappingParent, java.lang.String _clientID, java.lang.String _clientSecret)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("MappingParent", _mappingParent == null ? null : _mappingParent.getMendixObject());
		params.put("ClientID", _clientID);
		params.put("ClientSecret", _clientSecret);
		IMendixObject result = (IMendixObject)Core.microflowCall("MigrationUtility.ACT_CreateOAuthProvider").withParams(params).execute(context);
		return result == null ? null : email_connector.proxies.OAuthProvider.initialize(context, result);
	}
	public static void aCT_DeleteBeforeStats(IContext context, migrationutility.proxies.DataStats_Before _dataStats_Before)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("DataStats_Before", _dataStats_Before == null ? null : _dataStats_Before.getMendixObject());
		Core.microflowCall("MigrationUtility.ACT_DeleteBeforeStats").withParams(params).execute(context);
	}
	public static void aCT_MigrateEmailAccounts(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MigrationUtility.ACT_MigrateEmailAccounts").withParams(params).execute(context);
	}
	public static boolean aCT_MigrateEmailTemplates(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("MigrationUtility.ACT_MigrateEmailTemplates").withParams(params).execute(context);
	}
	public static void aCT_MigrateErrorLog(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MigrationUtility.ACT_MigrateErrorLog").withParams(params).execute(context);
	}
	public static void aCT_StartMigration(IContext context, migrationutility.proxies.MigrationConfig _migrationConfig)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("MigrationConfig", _migrationConfig == null ? null : _migrationConfig.getMendixObject());
		Core.microflowCall("MigrationUtility.ACT_StartMigration").withParams(params).execute(context);
	}
	public static java.lang.String cVRT_TruncateEmailLogMessage(IContext context, java.lang.String _message)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Message", _message);
		return (java.lang.String) Core.microflowCall("MigrationUtility.CVRT_TruncateEmailLogMessage").withParams(params).execute(context);
	}
	public static migrationutility.proxies.ECDataStats_After dS_AfterStats(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MigrationUtility.DS_AfterStats").withParams(params).execute(context);
		return result == null ? null : migrationutility.proxies.ECDataStats_After.initialize(context, result);
	}
	public static migrationutility.proxies.DataStats_Before dS_BeforeStats(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MigrationUtility.DS_BeforeStats").withParams(params).execute(context);
		return result == null ? null : migrationutility.proxies.DataStats_Before.initialize(context, result);
	}
	public static migrationutility.proxies.MigrationConfig dS_MigrationConfig(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MigrationUtility.DS_MigrationConfig").withParams(params).execute(context);
		return result == null ? null : migrationutility.proxies.MigrationConfig.initialize(context, result);
	}
}
// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package migrationutility.proxies.constants;

import com.mendix.core.Core;

public class Constants
{
	// These are the constants for the MigrationUtility module

	public static java.lang.String getLogNode()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MigrationUtility.LogNode");
	}

	public static java.lang.String getMigrationUtility_Version()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MigrationUtility.MigrationUtility_Version");
	}
}
// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package emailtemplate.proxies;

public class OAuthProviderDetails
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject oAuthProviderDetailsMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "EmailTemplate.OAuthProviderDetails";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Provider("Provider"),
		ClientID("ClientID"),
		ClientSecret("ClientSecret"),
		TenantID("TenantID");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public OAuthProviderDetails(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "EmailTemplate.OAuthProviderDetails"));
	}

	protected OAuthProviderDetails(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject oAuthProviderDetailsMendixObject)
	{
		if (oAuthProviderDetailsMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("EmailTemplate.OAuthProviderDetails", oAuthProviderDetailsMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a EmailTemplate.OAuthProviderDetails");

		this.oAuthProviderDetailsMendixObject = oAuthProviderDetailsMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'OAuthProviderDetails.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static emailtemplate.proxies.OAuthProviderDetails initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return emailtemplate.proxies.OAuthProviderDetails.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static emailtemplate.proxies.OAuthProviderDetails initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new emailtemplate.proxies.OAuthProviderDetails(context, mendixObject);
	}

	public static emailtemplate.proxies.OAuthProviderDetails load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return emailtemplate.proxies.OAuthProviderDetails.initialize(context, mendixObject);
	}

	public static java.util.List<emailtemplate.proxies.OAuthProviderDetails> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<emailtemplate.proxies.OAuthProviderDetails> result = new java.util.ArrayList<emailtemplate.proxies.OAuthProviderDetails>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//EmailTemplate.OAuthProviderDetails" + xpathConstraint))
			result.add(emailtemplate.proxies.OAuthProviderDetails.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * Set value of Provider
	 * @param provider
	 */
	public final emailtemplate.proxies.SupportedOAuthProvider getProvider()
	{
		return getProvider(getContext());
	}

	/**
	 * @param context
	 * @return value of Provider
	 */
	public final emailtemplate.proxies.SupportedOAuthProvider getProvider(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Provider.toString());
		if (obj == null)
			return null;

		return emailtemplate.proxies.SupportedOAuthProvider.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Provider
	 * @param provider
	 */
	public final void setProvider(emailtemplate.proxies.SupportedOAuthProvider provider)
	{
		setProvider(getContext(), provider);
	}

	/**
	 * Set value of Provider
	 * @param context
	 * @param provider
	 */
	public final void setProvider(com.mendix.systemwideinterfaces.core.IContext context, emailtemplate.proxies.SupportedOAuthProvider provider)
	{
		if (provider != null)
			getMendixObject().setValue(context, MemberNames.Provider.toString(), provider.toString());
		else
			getMendixObject().setValue(context, MemberNames.Provider.toString(), null);
	}

	/**
	 * @return value of ClientID
	 */
	public final java.lang.String getClientID()
	{
		return getClientID(getContext());
	}

	/**
	 * @param context
	 * @return value of ClientID
	 */
	public final java.lang.String getClientID(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ClientID.toString());
	}

	/**
	 * Set value of ClientID
	 * @param clientid
	 */
	public final void setClientID(java.lang.String clientid)
	{
		setClientID(getContext(), clientid);
	}

	/**
	 * Set value of ClientID
	 * @param context
	 * @param clientid
	 */
	public final void setClientID(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String clientid)
	{
		getMendixObject().setValue(context, MemberNames.ClientID.toString(), clientid);
	}

	/**
	 * @return value of ClientSecret
	 */
	public final java.lang.String getClientSecret()
	{
		return getClientSecret(getContext());
	}

	/**
	 * @param context
	 * @return value of ClientSecret
	 */
	public final java.lang.String getClientSecret(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ClientSecret.toString());
	}

	/**
	 * Set value of ClientSecret
	 * @param clientsecret
	 */
	public final void setClientSecret(java.lang.String clientsecret)
	{
		setClientSecret(getContext(), clientsecret);
	}

	/**
	 * Set value of ClientSecret
	 * @param context
	 * @param clientsecret
	 */
	public final void setClientSecret(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String clientsecret)
	{
		getMendixObject().setValue(context, MemberNames.ClientSecret.toString(), clientsecret);
	}

	/**
	 * @return value of TenantID
	 */
	public final java.lang.String getTenantID()
	{
		return getTenantID(getContext());
	}

	/**
	 * @param context
	 * @return value of TenantID
	 */
	public final java.lang.String getTenantID(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.TenantID.toString());
	}

	/**
	 * Set value of TenantID
	 * @param tenantid
	 */
	public final void setTenantID(java.lang.String tenantid)
	{
		setTenantID(getContext(), tenantid);
	}

	/**
	 * Set value of TenantID
	 * @param context
	 * @param tenantid
	 */
	public final void setTenantID(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String tenantid)
	{
		getMendixObject().setValue(context, MemberNames.TenantID.toString(), tenantid);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return oAuthProviderDetailsMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final emailtemplate.proxies.OAuthProviderDetails that = (emailtemplate.proxies.OAuthProviderDetails) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "EmailTemplate.OAuthProviderDetails";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
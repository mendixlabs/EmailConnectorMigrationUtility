package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(email_connector.actions.CalculateIncomingAccountMetrics.class);
    registrator.registerUserAction(email_connector.actions.CalculateOutgoingAccountMetrics.class);
    registrator.registerUserAction(email_connector.actions.CheckServerConnection.class);
    registrator.registerUserAction(email_connector.actions.ConvertHTMLBodyToPlainText.class);
    registrator.registerUserAction(email_connector.actions.CopyAttachmentContent.class);
    registrator.registerUserAction(email_connector.actions.CreateEmailFromTemplate.class);
    registrator.registerUserAction(email_connector.actions.EndTransaction.class);
    registrator.registerUserAction(email_connector.actions.GenerateOAuthNonce.class);
    registrator.registerUserAction(email_connector.actions.GetAppRootURL.class);
    registrator.registerUserAction(email_connector.actions.GetAutoConfig.class);
    registrator.registerUserAction(email_connector.actions.GetBaseDNList.class);
    registrator.registerUserAction(email_connector.actions.GetFolderNames.class);
    registrator.registerUserAction(email_connector.actions.GetMendixID.class);
    registrator.registerUserAction(email_connector.actions.GetPayloadFromJWT.class);
    registrator.registerUserAction(email_connector.actions.RetrieveEmailMessages.class);
    registrator.registerUserAction(email_connector.actions.SendEmail.class);
    registrator.registerUserAction(email_connector.actions.SendEmailWithTemplate.class);
    registrator.registerUserAction(email_connector.actions.SubscribeToIncomingEmail.class);
    registrator.registerUserAction(email_connector.actions.UnsubscribeFromIncomingEmail.class);
    registrator.registerUserAction(emailtemplate.actions.ConvertHTMLBodyToPlainText.class);
    registrator.registerUserAction(emailtemplate.actions.CopyAttachmentContent.class);
    registrator.registerUserAction(emailtemplate.actions.GetEmailSettingsByID.class);
    registrator.registerUserAction(emailtemplate.actions.OAuthRequestsHandler.class);
    registrator.registerUserAction(emailtemplate.actions.ReplaceCustomToken.class);
    registrator.registerUserAction(emailtemplate.actions.ReplaceEmailTemplateTokens.class);
    registrator.registerUserAction(emailtemplate.actions.SendEmail.class);
    registrator.registerUserAction(encryption.actions.DecryptString.class);
    registrator.registerUserAction(encryption.actions.EncryptString.class);
    registrator.registerUserAction(encryption.actions.GeneratePGPKeyRing.class);
    registrator.registerUserAction(encryption.actions.PGPDecryptDocument.class);
    registrator.registerUserAction(encryption.actions.PGPEncryptDocument.class);
    registrator.registerUserAction(encryption.actions.ValidatePrivateKeyRing.class);
    registrator.registerUserAction(mxmodelreflection.actions.ReplaceToken.class);
    registrator.registerUserAction(mxmodelreflection.actions.SyncObjects.class);
    registrator.registerUserAction(mxmodelreflection.actions.TestThePattern.class);
    registrator.registerUserAction(mxmodelreflection.actions.ValidateTokensInMessage.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}

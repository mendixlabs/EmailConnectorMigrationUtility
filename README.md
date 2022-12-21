# EmailConnectorMigrationUtility

This utility will assist you in migrating only data from the [Email with template](https://marketplace.mendix.com/link/component/259) to the new [Email Connector](https://marketplace.mendix.com/link/component/120739).

## Considerations
### Dependencies 
- Latest [Email with template](https://marketplace.mendix.com/link/component/259) module.
- [Email Connector](https://marketplace.mendix.com/link/component/120739) version 3.0.0 module.
- Latest [Encryption](https://marketplace.mendix.com/link/component/1011) module.
- Latest [Mx Reflection](https://marketplace.mendix.com/link/component/69) module.

### Pre-rerequisites 
- This utility will help migrate only data.
- App on MX 7 should first migrate to MX 8 LTS 
- App should be on at least Mendix 8 LTS
- The app should have the most recent version of the Email with Template Module.
- The app should have the most recent Mx Model reflection module. 
- The app should have the most recent Encryption module.
- Import the migration utility and troubleshoot any Atlas UI issues that may arise depending on your Studio Pro version.
- There should be no customization in the domain model of Email with template module in the app, for example:
    - Changes to any entity's properties 
    - Changes to attributes, associations, validation rules, event handlers, indexes, and access rules

## What data will be migrated

### Email Account
- Email accounts with basic authentication.
    - Will migrate all data.
- Email accounts with OAuth provider details.
    - Email accounts will be migrated.
    - OAuth provider’s Client ID and Client secrete will be migrated.
    - OAuth provider’s callback URL will not be migrated. 
### Email templates
- Tokens associated with email template will be migrated.
- Attachments associated with email template will be migrated.
### Email Messages
- Email messages with attachments will be migrated.
### Error logs 
- Will migrate all data but will not be associated with the email account; this must be addressed after migration.
### Associations
- Associations that exist in both modules will only be migrated.
- Email Connector-specific associations must be configured after/during migration.
### Data loss
- Because Email Connector does not support custom mail headers, data from the 'Header' entity will not be migrated.
- It is not possible to associate 'EmailMessage' with 'EmailAccount,' so messages with the status Queued, Sent, Failed, Error, Received will not be listed. Such 'EmailMessage' will be dormant until the user establishes the association after/during migration.


## Following things will not be migrated 

- Users must change 'import-export' mappings to make this possible when the app has Domain Model customization around Email with template entities.
- Microflows/Nanoflows are not migrated.
- UI pages are not migrated.
- Module level securities will not be migrated.
- Schedulers for sending queued emails will not be migrated.

## Possibilities for pro-customers with advanced Mendix knowledge
- Modify `import-export` mapping document 
    - To support their domain model customization 
    - To set associations

## Migration Steps

1. Make a backup/snapshot of the data in the email template module.
2. The application should have the most recent versions of the Email template and Email connector modules.
3. Import the migration utility and troubleshoot any Atlas UI issues that may arise depending on your Studio Pro version.
4. To begin migration, configure and launch 'ETToEC Overview' from your app navigation.
5. Read through the prerequisites and migration steps on migration overview page.
6. Press the Next button.
7. Check the existing statistics of both modules under before migration information. You may make a note of it for future reference.
8. Choose the data to be migrated, read the description of each option for more information, and check the relevant checkboxes.
9. Select 'Start Migration'.
10. Wait for the message 'Migration completed!' Message, then check the console logs for more information.
11. Examine the email connector module's 'After Migration' statistics.
    1. Validate the data in email connector entities, or else. Open the overview page for the email connector.
    2. Validate the templates that were migrated.
    3. Validate email messages, to view email messages, create an association with an email account.
    4. Validate Error Logs, if necessary, create an association with an email account to view them from the Account Settings page.
    5. Validate account and verify send email works for accounts migrated with basic authentication.
17. In the case of Oauth, update the Oauth provider details, but wait for additional steps before re-authorizing and making it work.
18. If you are good with the data uninstall the email template module.
19. Delete the migration utility module.
20. Remove all email template module jars from the app/Userlib folder.
21. Delete the deployment directory.
22. Start the app.
23. Re-authorize Oauth accounts and test the send email functionality.
24. You may choose to delete the email template module data backup/snapshot.

## Known Issues

If in Email with template module a template has a plain text which is manually entered (not generated by using "Copy from html text" action button) then it has a additional "<p>" element, this issue is due to Rich Text widget. So, such plain text will be migrated as it is in Email Connector.

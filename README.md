# EmailConnectorMigrationUtility

This utility will help to migrate data from [Email with template](https://marketplace.mendix.com/link/component/259) to new [Email Connector](https://marketplace.mendix.com/link/component/120739).


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
12. Validate the data in email connector entities, or else. Open the overview page for the email connector.
13. Validate the templates that were migrated.
14. Validate email messages, to view email messages, create an association with an email account.
15. Validate Error Logs, if necessary, create an association with an email account to view them from the Account Settings page.
16. Validate account and verify send email works for accounts migrated with basic authentication.
17. In the case of Oauth, update the Oauth provider details, but wait for additional steps before re-authorizing and making it work.
18. If you are good with the data uninstall the email template module.
19. Delete the migration utility module.
20. Remove all email template module jars from the app/Userlib folder.
21. Delete the deployment directory.
22. Start the app.
23. Re-authorize Oauth accounts and test the send email functionality.
24. You may choose to delete the email template module data backup/snapshot.


## Considerations

### App prerequisites 
    - App on MX 7 should first migrate to MX 8 LTS
    - App should be on LTS 8
    - App should have latest version of Email with template module
    - App should have latest Mx Model reflection module
    - App should have latest Encryption module
    - App should not have any customization in domain model of Email with template module, For example:
        - Modification to properties any entity
        - Addition/Modification to attributes, associations, validation rules, event handlers, indexes and access rules
        
### Email Account
- Email accounts with basic authentication
    - Will migrate all data
- Email accounts with OAuth provider details
    - Email accounts will be migrated
    - OAuth provider’s Client ID and Client secrete will be migrated
    - OAuth provider’s callback URL will not be migrated. 
    
### Email templates
    - with tokens will be migrated
    - with attachments will be migrated
### Email Messages
    - with attachments will be migrated
### Error logs 
    - Will migrate all data but will not be associated with the email account
### Associations
    - Associations which is present in both the modules will be considered
    - Email Connector specific associations need to be set after/during migration
### Data loss
    - As custom mail header functionality is not available with Email Connector hence data from `Header` entity will not be migrated
    - Not possible to set `EmailMessage` to `EmailAccount` association, hence messages with status Queued, Sent, Failed, Error, Received will not be listed. such `EmailMessage` will be remain dormant till the time user sets the association after/during migration


## Following things will not be migrated 

- When app has Domain Model customization around Email with template entities will not be migrated, users have to change `import-export` mappings to make this possible
- Microflows/Nanoflows are not migrated
- UI pages are not migrated
- Module level securities will not be migrated
- Schedulers for sending queued emails will not be migrated

## Possibilities for pro-customers with advanced Mendix knowledge
- Modify `import-export` mapping document 
    - To support their domain model customization 
    - To set associations


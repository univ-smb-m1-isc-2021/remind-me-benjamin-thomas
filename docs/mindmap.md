@startmindmap
+ RemindME
++ HomePage
+++ Displayed for connected users only
++++ Check for session var (cookie)
++++ Check for the current google account
+++ Show incoming notifications (ordered by time left)
++++ Sync the local memory with the remote one associated to the logged account
+++ Parameters
++++ Languages
+++++ FULL LOCAL
++++++ Stored in cookie or env var
+++++ REMOTE
++++++ Stored in DB - Table User Preferences
++++ Dark Mode
+++++ FULL LOCAL
++++++ Stored in cookie or env var
+++++ REMOTE
++++++ Stored in DB - Table User Preferences
++++ Pemissions
+++++ Asked for each devices
++++++ Notification
++++++ Access to local files
++++++ STORED BY USER'S PHONE/BROWSER
++++++ ...
+++++ Asked once for the entire account
++++++ RGPD
++++++ STORED DB
++++ Notification canals managment
+++++ Table canal
++++++ userid
++++++ type
++++++ canal_data
++++ Account managment
+++++ Edit
++++++ password
++++++ name
++++++ mail
++++++ phone number
++++++ accessible only for non social accounts
++++ Third app link managment
+++++ Google Contacts
+++++ Facebook
+++++ Phone contacts
+++++ Add/Edit/Remove
++ Notification viewer
+++ Spec
++++ Event id
++++ Timestamp
++++ Activated
+++ Edit
+++ Calendar View
+++ Validate notification
-- Connection Page
--- Connection methods
---- Google
---- Phone
---- Email
-- Creation Page
--- Creation methods
---- Google
---- Phone
---- Email
-- Create Event
--- Spec
---- Self id
---- User id
---- Name
---- Date
---- Notification number
---- First notification before ...
@endmindmap

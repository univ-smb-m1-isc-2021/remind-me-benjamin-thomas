@startmindmap
+[#lightblue] RemindME
++ HomePage
+++ Displayed for connected users only
++++[#Orange] Check for session var (cookie)
++++[#Orange] Check for the current google account
+++ Show incoming notifications (ordered by time left)
++++[#Orange] Sync the local memory with the remote one associated to the logged account
+++ Parameters
++++ Languages
+++++[#Orange] FULL LOCAL
++++++[#Orange] Stored in cookie or env var
+++++[#Orange] REMOTE
++++++[#Orange] Stored in DB - Table User Preferences
++++ Dark Mode
+++++[#Orange] FULL LOCAL
++++++[#Orange] Stored in cookie or env var
+++++[#Orange] REMOTE
++++++[#Orange] Stored in DB - Table User Preferences
++++ Permissions
+++++[#Orange] Asked for each devices
++++++[#Orange] Notification
++++++[#Orange] Access to local files
++++++[#Orange] STORED BY USER'S PHONE/BROWSER
++++++[#Orange] ...
+++++[#Orange] Asked once for the entire account
++++++[#Orange] RGPD
++++++[#Orange] STORED DB
++++ Notification canals managment
+++++[#Orange] Table canal
++++++[#Orange] userid
++++++[#Orange] type
++++++[#Orange] canal_data
++++ Account managment
+++++[#Orange] Edit
++++++[#Orange] password
++++++[#Orange] name
++++++[#Orange] mail
++++++[#Orange] phone number
++++++[#Orange] accessible only for non social accounts
++++ Third app link managment
+++++ Google Contacts
+++++ Facebook
+++++ Phone contacts
+++++[#Orange] Add/Edit/Remove
++ Notification viewer
+++[#Orange] Spec
++++[#Orange] Event id
++++[#Orange] Timestamp
++++[#Orange] Activated
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
---[#Orange] Spec
----[#Orange] Self id
----[#Orange] User id
----[#Orange] Name
----[#Orange] Date
----[#Orange] Notification number
----[#Orange] First notification before ...
@endmindmap

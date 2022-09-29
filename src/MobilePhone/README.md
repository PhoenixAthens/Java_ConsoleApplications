# Date: 29th of September 2022
### This file is to log the recent changes!
#### Class: Contacts
> ### Methods: 
> #### equals(Object obj):boolean
> This method compares two contact objects on the basis of PhoneNumber,
> If you are thinking, why not first or last Name, you are not wrong!
> However, for instance imagine surfing through a telephone directory, there can be tens and thousands
> of people who have the same name, the requirement however is that the PhoneNumber should not be the same!
> #### toString():String
> To print the contact object as LastName FirstName: PhoneNumber
> #### compareTo(Contacts contact):int
> This method is to allow easy sorting of customers in some structure like a telephone directory.

#### Class: MobilePhone
> ### Methods:
> #### AddContacts(String firstName, String lastName, long PhoneNumber):boolean
> the method has been updated to include lastName as parameter when creating a new contacts instance
> #### FindContactsWithName(String firstName):void
> The method prints to the console the contacts that have the same firstName as the parameter firstName
> #### FindContactsWithContactNumber(long PhoneNumber):void
> The method prints to the console the contact with the contact number equivalent to the parameter
> #### removeContact(String Name):boolean
> The method allows the user to see which contacts have the same first name as the parameter, and then remove the
> appropriate contact accordingly
> #### inputTaker():Contacts
> centralizes the task of taking inputs required for the creation of Contacts object
> #### ModifyContact():boolean
> Allows the user to modify contact details, either on the basis of Name or PhoneNumber
> #### modifyContactOnTheBasisOfName(String name):void
> This method is internally called by ModifyContact() and allows the user to find contact on the basis of name
> and then modify the appropriate contact
> #### modifyContactsOnTheBasisOfPhoneNumber(long PhoneNumber):void
> This method is internally called by ModifyContact() and allows the user to find contact on the basis of PhoneNumber
> and then modify the appropriate contact
> #### MainProcedure(int count):void
> Both ModifyContactsOnTheBasisOfName and ModifyContactOnTheBasisOfPhoneNumber internally perform the same procedure to 
> modify the contact details, this method centralises that functionality required for modification
> #### PrintOptionsForModification():void
> This method gives user the options for modification
> #### modification(Contact contact):boolean
> This method performs the actual modification using the following three methods, on the basis of user's choice of action
> The methods are:
> ##### changeFirstName(Contact contact):void
> ##### changeLastName(Contact contact):void
> ##### changePhoneNumber(Contact contact):void
> #### PrintAllContacts():void
> Prints all contacts to the console
> 
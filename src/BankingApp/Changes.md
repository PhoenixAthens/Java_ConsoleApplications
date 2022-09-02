# Changes Made on 9/2/2022
### New Method :
    > Class: Customer
        1)compareTo
        2)getNameOfCustomer
        3)setNameOfCustomer
        4)getCustomerID
        5)toString()
    > Class: Branch
        1)Automatic Sort
        2)checkOutAParticularCustomer
### New Attributes
    > Class: Customer
        1)Customer ID
## Changes made in implementation
    > Class: Customer
        1) equals Method no longer compares Customer on the basis of name,transaction, initial Transaction,
        rather it now compares Customer using customer ID, customerName
    > Class: Branch
        1)Add Customer method no longer asks for user to enter intial transactions when creating new Customer Object 
        the initial transaction is hard Coded
        2)show Transaction, internally uses Search Customer Method to find customers with same name,then uses method
        checkOutParticularCustomer to print details specific to a customer.
## Thoughts
    > Class: Branch
        1)in showTransaction method, check is listObtained has length 1, if so disable functionality from line 32::40
        2)Go through showTransaction once again to check for any remaining unattended changes.
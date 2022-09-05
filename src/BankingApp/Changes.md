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
### Changes made in implementation
    > Class: Customer
        1) equals Method no longer compares Customer on the basis of name,transaction, initial Transaction,
            rather it now compares Customer using customer ID, customerName
    > Class: Branch
        1)Add Customer method no longer asks for user to enter intial transactions when creating new Customer Object 
            the initial transaction is hard Coded
        2)show Transaction, internally uses Search Customer Method to find customers with same name,then uses method
            checkOutParticularCustomer to print details specific to a customer.
### Thoughts
    > Class: Branch
        1)in showTransaction method, check if listObtained has length 1, if so disable functionality from line 32::40
        2)Go through showTransaction once again to check for any remaining unattended changes.

# Changes Made on 9/5/2022
### New Method
    > Class: Branch
        1) method compareTo(Branch b): int has been added to class Branch so that the list branches in class Bank can be 
            sorted with a natural sort order on using .sort()
        2) Functionality from thoughts on 9/2/2022 about showTransactions() implemented!

### Changes made in Implementation
    > Class: Customer
        1) Method compareTo was outdated, comparison was being done on the basis of name, transaction; with the new 
            the comparison is done on the basis of name and customer ID
    > Class: Branch
        1) Method addTransactions, implementation completed!
        2) Unnecessary else control structure removed from method SearchCustomer method
    > Class: Main
        Implementation for functionalities of all sorts required in class Main has been moved to class Bank
        Thus all method in class Main have been simplified
### Thoughts
    > Class: Main
        Functionality provided for some methods is still not fail-fast, this can result in bugs in particularly crucial 
        moments
        
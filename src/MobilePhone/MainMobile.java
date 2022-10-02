package MobilePhone;
public class MainMobile {
    private static boolean flag=false;
    private static final MobilePhone phone=new MobilePhone();
    public static void main(String... args){
        MobileStart();
        while(flag){
            System.out.println("Enter you choice (1-8)");
            if(MobilePhone.scan.hasNextInt()){
                int scan = MobilePhone.scan.nextInt();
                MobilePhone.scan.nextLine();
                switch (scan) {
                    case 1 -> PrintContacts();
                    case 2 -> AddContact();
                    case 3 -> ModifyContacts();
                    case 4 -> RemoveContact();
                    case 5 -> Find_SearchContacts();
                    case 6-> Find_SearchContactsUsingNumber();
                    case 7 -> PrintOptions();
                    case 8 -> flag = false;
                    default -> {
                        System.out.println("\n=======================================");
                        System.out.println("++++++++++++<INVALID ENTRY!>+++++++++++++");
                        System.out.println("=======================================\n");
                    }
                }
            }else{
                MobilePhone.scan.nextLine();
                System.out.println("\n=======================================");
                System.out.println("Invalid Entry try Again!");
                System.out.println("=======================================\n");
            }
        }
    }
    private static void MobileStart(){
        flag=true;
        System.out.println("Phone is Starting");
        System.out.println("++++++++++++++++++WELCOME++++++++++++++++++++");
        PrintOptions();


    }
    private static void PrintOptions(){
        System.out.println("\n=======================================");
        System.out.println("\t\t(Key)      (Function)        ");
        System.out.println("\t\t (1) Print list of Contacts  ");
        System.out.println("\t\t (2) Add new Contact         ");
        System.out.println("\t\t (3) Update Existing Contact ");
        System.out.println("\t\t (4) Remove Contact          ");
        System.out.println("\t\t (5) Find/Search Contact (using Name)  ");
        System.out.println("\t\t (6) Find/Search Contact (using PhNumber");
        System.out.println("\t\t (7) Show Options            ");
        System.out.println("\t\t (8) Exit the app!           ");
        System.out.println("=======================================\n");
    }
    private static void PrintContacts(){
        phone.PrintAllContacts();
    }
    private static void Find_SearchContacts(){
        System.out.print("Enter the name: ");
        String name=MobilePhone.scan.nextLine();
        System.out.println("\n==============================================");
        phone.FindContactsWithName(name);
        System.out.println("==============================================\n");
    }
    private static void Find_SearchContactsUsingNumber(){
        System.out.print("Enter contact Number: ");
        long number= MobilePhone.scan.nextLong();
        MobilePhone.scan.nextLine();
        System.out.println("\n==============================================");
        phone.FindContactWithContactNumber(number);
        System.out.println("==============================================\n");

    }
    private static void RemoveContact(){
        System.out.print("Enter the contact name: ");
        String name=MobilePhone.scan.nextLine();
        var boo=phone.removeContact(name);
        if(boo){
            System.out.println("\n=======================================");
            System.out.println("Contact successfully removed!");
            System.out.println("=======================================\n");
        }
    }
    private static void ModifyContacts(){
        var result=phone.ModifyContact();
        if(!result){
            System.out.println("\n================================");
            System.out.println("Issues in modification!!");
            System.out.println("================================\n");
        }
    }
    private static void AddContact() {
        System.out.print("contact's name: ");
        String firstName= MobilePhone.scan.nextLine();
        System.out.print("contact's lastName: ");
        String lastName= MobilePhone.scan.nextLine();
        System.out.print("Phone Number: ");
        if(MobilePhone.scan.hasNextLong()){
            long PhNum= MobilePhone.scan.nextLong();
            MobilePhone.scan.nextLine();
            var result=phone.AddContacts(firstName,lastName,PhNum);
            if(result){
                phone.accessContacts().sort(null);
                System.out.println("\n===========================================");
                System.out.println("Contact successfully added!!");
                System.out.println("===========================================\n");
            }else{
                System.out.println("\n===============================================================");
                System.out.println("Error Saving Contact, check if the contact already exists!!");
                System.out.println("===============================================================\n");
            }
        }
        else{
            MobilePhone.scan.nextLine();
            System.out.println("\n===========================================");
            System.out.println("Contact Number has to be a Numerical Value");
            System.out.println("===========================================\n");
        }
    }
}

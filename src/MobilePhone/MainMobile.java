package MobilePhone;
public class MainMobile {
    private static boolean flag;
    private static final MobilePhone phone=new MobilePhone();
    public static void main(String... args){
        flag=false;
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
                    case 7 -> PrintOptions();
                    case 8 -> flag = false;
                    default -> System.out.println("<INVALID ENTRY!>");
                }
            }else{
                System.out.println("Invalid Entry try Again!");
                MobilePhone.scan.nextLine();
            }
        }
    }
    public static void MobileStart(){
        flag=true;
        System.out.println("Phone is Starting");
        System.out.println("++++++++++++++++++WELCOME++++++++++++++++++++");
        PrintOptions();


    }
    public static void PrintOptions(){
        System.out.println("\t\t(Key)      (Function)        ");
        System.out.println("\t\t (1) Print list of Contacts  ");
        System.out.println("\t\t (2) Add new Contact         ");
        System.out.println("\t\t (3) Update Existing Contact ");
        System.out.println("\t\t (4) Remove Contact          ");
        System.out.println("\t\t (5) Find/Search Contact     ");
        System.out.println("\t\t (6) Don't use 6! PLZ        ");
        System.out.println("\t\t (7) Show Options            ");
        System.out.println("\t\t (8) Exit the app!           ");
    }
    public static void PrintContacts(){
        phone.PrintAllContacts();
    }
    public static void Find_SearchContacts(){
        System.out.print("Enter the name: ");
        String name=MobilePhone.scan.nextLine();
        phone.PrintDuplicates(name);
        System.out.println();
    }
    public static void RemoveContact(){
        System.out.print("Enter the contact name: ");
        String name=MobilePhone.scan.nextLine();
        phone.removeContact(name);
        System.out.println();
    }
    public static void ModifyContacts(){
        phone.ModifyContact();
        System.out.println();
    }
    public static void AddContact(){
        System.out.print("Enter the name: ");
        String name=MobilePhone.scan.nextLine();
        System.out.println();
        System.out.print("Enter the Contact Number: ");
        long number=MobilePhone.scan.nextLong();
        phone.AddContacts(name,number);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class BankManagementSystem{
    public static void main(String[] args) {
        
        Scanner SCANNER = new Scanner(System.in);

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to Start Banking";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSIT_MONEY = "Deposit";
        final String WITHDRAW_MONEY = "Withdrawal";
        final String TRANSFER_MONEY = "Transfer";
        final String CHECK_BALANCE  = "Check Balance";
        final String DELETE_STATE = "Delete Statement";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String screen = DASHBOARD;
        String[][] users = new String[0][];

        System.out.println(users.length);

        mainloop:

        do{

            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){

                case DASHBOARD:

                System.out.println("\t[1]. Create New Account");
                System.out.println("\t[2]. Deposit");
                System.out.println("\t[3]. Withdrawal");
                System.out.println("\t[4]. Transfer");
                System.out.println("\t[5]. Check Balance)");
                System.out.println("\t[6]. Delete Statement");
                System.out.print("\tEnter an option to continue: ");
                int option = SCANNER.nextInt();
                SCANNER.nextLine();

                switch (option){
                    case 1: screen = CREATE_ACCOUNT; break;
                    case 2: screen = DEPOSIT_MONEY; break;
                    case 3: screen = WITHDRAW_MONEY; break;
                    case 4: screen = TRANSFER_MONEY; break;
                    case 5: screen = CHECK_BALANCE; break;
                    case 6: screen = DELETE_STATE; break;
                    case 7: System.out.println(CLEAR); System.exit(0);
                    default: continue;
                }
                break;

                case CREATE_ACCOUNT:{

                    String id;
                    String name;
                    double balance;
                    boolean valid;

                    //User ID generation

                    id = String.format("SDB-%05d", (users.length+1));
                    System.out.printf("SDB-%05d \n", (users.length+1));

                    //Name Validation

                    do{
                        valid = true;

                        System.out.print("Enter User Name : ");
                        name = SCANNER.nextLine();

                         /* Empty */
                        if(name.isBlank()){
                            System.out.printf(ERROR_MSG, "Username name can't be empty");
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid name");
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    //Initial Deposit Validation

                    double intialDepo = 0;

                    do{
                        valid = true;

                        System.out.print("Initial Deposit : ");
                        String strDepo = SCANNER.nextLine();
                            
                        if(strDepo.isBlank()){
                            System.out.printf(ERROR_MSG, "Please enter an Initial amount");
                            valid= false;
                            continue;
                        }
                        intialDepo = Double.parseDouble(strDepo);

                        if(intialDepo < 5000){
                            System.out.printf(ERROR_MSG, "Insufficient Initial Deposit");
                            valid = false;
                            continue;
                        }

                    }while(!valid);

                     /*
                     * Now we have to store this new assignment marks,
                     * So let's scale the `student` array by one
                     */
                    String[][] tempUsers = new String[users.length + 1][3];

                    /*
                     * Let's copy previous recrods from old `student` array to new `student` array
                     */
                    for (int i = 0; i < users.length; i++) {
                        tempUsers[i] = users[i];
                    }

                    /* Let's add new assignment marks */
                    tempUsers[tempUsers.length - 1][0] = id;
                    tempUsers[tempUsers.length - 1][1] = name;
                    tempUsers[tempUsers.length - 1][2] = intialDepo + " ";

                    /* Let's swap arrays' memory locations */
                    users = tempUsers;

                    System.out.println();
                    System.out.printf(SUCCESS_MSG, String.format("%s:%s added successfully \n", id, name));
                    System.out.print("\tDo you want to continue adding marks? (Y/n)");
                    if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
                        screen = DASHBOARD;
                    break;

                }




            }








        }while(true);








    }
}
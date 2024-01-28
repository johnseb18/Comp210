package assn07;


import java.util.Set;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();



        while (true) {
            System.out.println("Enter Master Password");
            String firstInput = scanner.nextLine();
            if (passwordManager.checkMasterPassword(firstInput)) {
                break; }
        }

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Exit")) {
                return; }
            else if (input.equals("New password")) {
                String website = scanner.nextLine();
                String password = scanner.nextLine();
                passwordManager.put(website, password);
                System.out.println("New password added");

            }
            else if (input.equals("Get password")) {
                    String inputWebsite = scanner.nextLine();
                    String retrievedPassword = passwordManager.get(inputWebsite);
                    if (retrievedPassword != null) {
                        System.out.println(retrievedPassword);
                    } else {
                        System.out.println("Account does not exist");
                    }
            }

            else if (input.equals("Delete account")) {
                String website = scanner.nextLine();
                String removedPassword = passwordManager.remove(website);
                if (removedPassword != null) {
                    System.out.println("Account deleted"); }
                else {
                    System.out.println("Account does not exist"); }
            }

            else if (input.equals("Check duplicate password")) {
                String password = scanner.nextLine();
                List<String> value = passwordManager.checkDuplicate(password);
                if (value.isEmpty()) {
                    System.out.println("No account uses that password");
                } else {
                    System.out.println("Websites using that password:");
                    for (String _value : value) {
                        System.out.println(_value);
                    }
                }
            } else if (input.equals("Get accounts")) {
                Set<String> allKeys = passwordManager.keySet();
                System.out.println("Your accounts:");
                for (String key : allKeys) {
                    System.out.println(key);
                }
            }
            else if (input.equals("Generate random password")) {

                Integer length = scanner.nextInt();
                scanner.nextLine();
                String newPassword = passwordManager.generateRandomPassword(length);
                System.out.println(newPassword);
            }
            else {
                System.out.println("Command not found");
            }}}}

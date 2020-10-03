import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import app.RBAC;
import app.RolesDAOImpl;
import app.UserDAOImpl;
import app.entities.Operation;

public class CLI {

    public static void main(String[] args){
        RBAC rbac = new RBAC(RolesDAOImpl.create(), UserDAOImpl.create());
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter commands");
            while (true) {
                String input = scanner.nextLine();
                String[] command = input.split(" ");

                Operation operation = Operation.valueOf(command[0].toUpperCase());
                List<String> arguments =  List.of(Arrays.copyOfRange(command, 1, command.length));

                String result = rbac.executeOperatation(operation, arguments);
                System.out.println("> :" + result);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("System error !!");
        }
    }
}

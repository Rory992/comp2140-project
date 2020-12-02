import app.PaySysApp;
import ui.TextUI;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PaySysApp app = new PaySysApp("PaySysEmp.txt", "PaySysSlip.txt", "PaySysCom.txt", "PaySysRep.txt", ',');
        TextUI ui = new TextUI();

        System.out.println("\n Please wait, the system is starting...");
        Thread.sleep(4000);
        System.out.println("\n");
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy \n               hh.mm aa");
        String dateString2 = dateFormat2.format(new Date()).toString();
        System.out.println("              " + dateString2);
        System.out.println("\n");
        System.out.println("        Main Menu is approaching      ".toUpperCase());
        Thread.sleep(4000);
        System.out.println("1)TextUI");
        Thread.sleep(250);
        System.out.println("2)GUI\n");
        Thread.sleep(250);
        Scanner select = new Scanner(System.in);
        int choice = select.nextInt();

        if (choice == 1) {
            ui.start(app);
//        } else{
//            Gui gui = new Gui(app);
//            gui.main(app);
        }
        select.close();
    }
}

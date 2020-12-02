package ui;

import app.PaySysApp;

import java.io.IOException;
import java.util.Scanner;

public class TextUI {
    int selection;

    public void start (PaySysApp app) {
        System.out.println("\n+++++++++++++++++++ WELCOME TO SUNNYSIDE BEAUTY SUPPLIES PAYMENT SYSTEM +++++++++++++++++++\n");
        System.out.println(" 1) Manage Records\n 2) Review Employees\n 3) Manage Employee Comments\n 4) Generate A Payslip \n 5) Generate A Report\n 6) Exit System");

        Scanner input = new Scanner(System.in);
        System.out.println("\nSelect A Number From Above: ");
         try{
             selection = input.nextInt();

             while (selection!=6) {
                 if (selection == 1) {
                     int choice0;
                     System.out.println(" 1) Create New Employee Record\n 2) Remove Existing Record\n 3) Update Employee Name\n 4) Update Employee Address\n 5) Add Hours\n 6) Remove Hours\n 7) Update Employee Position\n");
                     System.out.println("Select An Option From Above");

                     Scanner manage = new Scanner(System.in);
                     choice0 = manage.nextInt();

                     if (choice0 == 1) {
                         System.out.println("Enter New Employee Information\n Format Required - 123456789,4321,1999,M or F,John,James,Jones,0 or 1");
                         Scanner newEmp = new Scanner(System.in);
                         String line = newEmp.nextLine();
                         String[] empArr = line.split(",");
                         app.addEmployee( empArr[0].strip(), empArr[1].strip(), empArr[2].strip(), empArr[3].strip(), empArr[4].strip(), empArr[5].strip(), empArr[6].strip(), empArr[7].strip());
                         System.out.println("++++++ Successfully Added New Employee Record ++++++");

                     } else if (choice0 == 2) {
                         System.out.println("Enter Employee Number To Remove From System\n");
                         Scanner remove = new Scanner(System.in);
                         String id = remove.nextLine();
                         app.removeEmployee(id);
                         System.out.println("------ Successfully Removed From System ------");

                     } else if (choice0 == 3) {
                         int choice1;
                         System.out.println(" 1) Change First Name\n 2) Change Middle Name\n 3) Change Last Name\n");
                         System.out.println("Select An Option From Above");

                         Scanner nameChange = new Scanner(System.in);
                         choice1 = nameChange.nextInt();

                         if (choice1 == 1) {
                             System.out.println("Enter Employee Number And New First Name\n Required Format - 10,Mary");
                             Scanner firstName = new Scanner(System.in);
                             String fLine = firstName.nextLine();
                             String[] fNameArr = fLine.split(",");
                             app.updateFirstName(fNameArr[0].strip(), fNameArr[1].strip());
                             System.out.println("Employee with Id Number " + fNameArr[0] + " First Name Successfully Changed To " + fNameArr[1]);

                         } else if (choice1 == 2) {
                             System.out.println("Enter Employee Number And New Middle Name\n Required Format - 10,Jane");
                             Scanner middleName = new Scanner(System.in);
                             String mLine = middleName.nextLine();
                             String[] mNameArr = mLine.split(",");
                             app.updateMiddleName(mNameArr[0].strip(), mNameArr[1].strip());
                             System.out.println("Employee with Id Number " + mNameArr[0] + " Middle Name Successfully Changed To " + mNameArr[1]);

                         } else if (choice1 == 3) {
                             System.out.println("Enter Employee Number And New Last Name\n Required Format - 10,Jane");
                             Scanner lastName = new Scanner(System.in);
                             String lLine = lastName.nextLine();
                             String[] lNameArr = lLine.split(",");
                             app.updateLastName(lNameArr[0].strip(), lNameArr[1].strip());
                             System.out.println("Employee with Id Number " + lNameArr[0].strip() + " Last Name Successfully Changed To " + lNameArr[1].strip());
                         }

                     } else if (choice0 == 4) {
                         int choice2;
                         System.out.println(" 1) Add Address Information\n 2) Change Country\n 3) Change Parish\n 4) Change Town\n 5) Change Street\n");
                         System.out.println("Select An Option From Above");

                         Scanner addressChange = new Scanner(System.in);
                         choice2 = addressChange.nextInt();

                         if (choice2 == 1) {
                             System.out.println("Enter Employee Number And Complete Address \n Required Format - 9,Jamaica,St. Ann, Ocho Rios, First Street\n");
                             Scanner addr = new Scanner(System.in);
                             String newAddress = addr.nextLine();
                             String[] addrArr = newAddress.split(",",-1);
                             app.createAddress(addrArr[0].strip(), addrArr[1].strip(), addrArr[2].strip(), addrArr[3].strip(), addrArr[4].strip());
                             System.out.println("Employee With Id Number " + addrArr[0] + " Now Has An Address");

                         } else if (choice2 == 2) {
                             System.out.println("Enter Employee Number And New Country\n Required Format - 11,Cuba\n");
                             Scanner country = new Scanner(System.in);
                             String newCountry = country.nextLine();
                             String[] countryArr = newCountry.split(",",-1);
                             app.updateCountry(countryArr[0].strip(), countryArr[1].strip());
                             System.out.println("Employee with Id Number " + countryArr[0].strip() + " Country Address Successfully Changed To " + countryArr[1].strip());

                         } else if (choice2 == 3) {
                             System.out.println("Enter Employee Number And New Parish\n Required Format - 11,Portland\n");
                             Scanner parish = new Scanner(System.in);
                             String newParish = parish.nextLine();
                             String[] parishArr = newParish.split(",",-1);
                             app.updateParish(parishArr[0].strip(), parishArr[1].strip());
                             System.out.println("Employee with Id Number " + parishArr[0].strip() + " Parish Address Successfully Changed To " + parishArr[1].strip());

                         } else if (choice2 == 4) {
                             System.out.println("Enter Employee Number And New Town\n Required Format - 12, Warsop\n");
                             Scanner town = new Scanner(System.in);
                             String newTown = town.nextLine();
                             String[] townArr = newTown.split(",", -1);
                             app.updateTown(townArr[0].strip(), townArr[1].strip());
                             System.out.println("Employee with Id Number " + townArr[0].strip() + " Town Address Successfully Changed To " + townArr[1].strip());

                         } else if (choice2 == 5) {
                             System.out.println("Enter Employee Number And New Street\n Required Format - 12, Queens Drive\n");
                             Scanner street = new Scanner(System.in);
                             String newStreet = street.nextLine();
                             String[] streetArr = newStreet.split(",", -1);
                             app.updateStreet(streetArr[0].strip(), streetArr[1].strip());
                             System.out.println("Employee with ID Number " + streetArr[0].strip() + " Street Address Successfully Changed To " + streetArr[1].strip());
                         }
                     } else if (choice0==5) {
                         System.out.println("Enter The Employee Number And Hours You Wish To Add\n Required Format - 8,7.5 ");
                         Scanner addHrs = new Scanner(System.in);
                         String hrs = addHrs.nextLine();
                         String [] hrsArr = hrs.split(",");
                         app.addHours(hrsArr[0].strip(), hrsArr[1].strip());
                         System.out.println( hrsArr[1].strip() + " Hours Has Been Added To Employee With ID Number " + hrsArr[0].strip() + " Record");

                     } else if (choice0==6) {
                         System.out.println("Enter The Employee Number And Hours You Wish To Remove\n Required Format - 9,3.5 ");
                         Scanner remHrs = new Scanner(System.in);
                         String hrs = remHrs.nextLine();
                         String [] hrsArr = hrs.split(",");
                         app.deleteHours(hrsArr[0].strip(), hrsArr[1].strip());
                         System.out.println( hrsArr[1].strip() + " Hours Has Been Subtracted From Employee With ID Number " + hrsArr[0].strip() + " Record");

                     }  else if (choice0==7) {
                         System.out.println("Enter The Employee Number And  0 Or 1 To Change Position To SENIORSTAFF Or JUNIORSTAFF \n Required Format - 9, 1 or 0 ");
                         Scanner pos = new Scanner(System.in);
                         String posLine = pos.nextLine();
                         String[] posArr = posLine.split(",");
                         app.changePosition(posArr[0].strip(), posArr[1].strip());
                         System.out.println("Employee With Id Number " + posArr[0].strip() + " Position Has Been Changed To");
                     }

                 } else if (selection == 2) {
                     int choice3;

                     System.out.println(" 1) Search By ID\n 2) Search By First Name\n 3) Search By Last Name\n");
                     System.out.println("Select An option Above");

                     Scanner nameChange = new Scanner(System.in);
                     choice3 = nameChange.nextInt();

                     if (choice3 == 1) {
                         System.out.println("Enter Employee Number Of The Desired Employee\n");
                         Scanner searchID = new Scanner(System.in);
                         System.out.println(app.searchById(searchID.nextLine().strip()));

                     } else if (choice3 == 2) {
                         System.out.println("Enter The First Name Of The Desired Employee\n");
                         Scanner searchFName = new Scanner(System.in);
                         System.out.println(app.searchByFirstName(searchFName.nextLine().strip()));

                     } else if (choice3 == 3) {
                         System.out.println("Enter The Last Name Of The Desired Employee\n");
                         Scanner searchLast = new Scanner(System.in);
                         System.out.println(app.searchByLastName(searchLast.nextLine().strip()));
                     }
                 } else if (selection == 3) {
                     int choice4;
                     System.out.println(" 1) Add A Comment\n 2) Review Comments\n 3) Remove A Comment\n");
                     System.out.println("Select An option Above");

                     Scanner commentLine = new Scanner(System.in);
                     choice4 = commentLine.nextInt();

                     if (choice4 == 1) {
                         System.out.println("Enter The Employee ID Number and The Comment To Be Added\n Format Required - 14,This is a hard working employee");

                         Scanner makeComment = new Scanner(System.in);
                         String comment = makeComment.nextLine();
                         String[] commentArr = comment.split(",");
                         app.makeComment(commentArr[0].strip(), commentArr[1].strip());
                         System.out.println("Comment Successfully Added To The System");

                     } else if (choice4 == 2) {
                         System.out.println("Enter The Employee ID Number To Find Comments On");

                         Scanner findComment = new Scanner(System.in);
                         String id = findComment.nextLine();
                         System.out.println(app.viewComment(id));

                     } else if (choice4 == 3) {
                         System.out.println("Enter The Employee ID Number To Remove Comment");

                         Scanner removeComment = new Scanner(System.in);
                         String id = removeComment.nextLine();
                         System.out.println(app.deleteComment(id));
                     }
                 } else if (selection == 4) {
                     System.out.println(" Enter The Employee ID, Extras And Deductions To Generate Their Payslip\n Format Required - 7,500,100");

                     Scanner paySlip = new Scanner(System.in);
                     String id = paySlip.nextLine();
                     String [] slipArr = id.split(",");
                     System.out.println(app.generatePaySlip(slipArr[0].strip(), slipArr[1].strip(), slipArr[2].strip()));

                 } else if (selection == 5) {
                     System.out.println("Please Wait For A Report To Be Generated");

                     app.generateReport();
                 }
             System.out.println("\n+++++++++++++++++++ WELCOME TO SUNNYSIDE BEAUTY SUPPLIES PAYMENT SYSTEM +++++++++++++++++++\n");
             System.out.println(" 1) Manage Records\n 2) Review Employees\n 3) Manage Employee Comments\n 4) Generate A Payslip \n 5) Generate A Report\n 6) Exit System");

             System.out.println("\nSelect A Number From Above: ");
             selection = input.nextInt();
             }

             System.out.println("\n THANK YOU FOR USING THE APPLICATION");
             app.shutDown();

         } catch (NumberFormatException | IOException e) {
             System.out.println("Input Is Invalid");
         }
    }
}
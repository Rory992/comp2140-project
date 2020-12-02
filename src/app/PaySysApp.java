package app;

import data.PaySysDb;
import paysys.Address;
import paysys.Employee;
import paysys.Position;
import java.io.IOException;
import java.util.ArrayList;


public class PaySysApp {
    private PaySysDb employeeData;
    private PaySysDb paySlipData;
    private PaySysDb commentsData;
    private PaySysDb reportData;
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<String> paySlipList = new ArrayList<>();
    private ArrayList<String> commentList = new ArrayList<>();
    private ArrayList<String> reportList = new ArrayList<>();
    private static short num = 7;
    private float snrRate = 197;
    private float jnrRate = (float) 160.8;

    public PaySysApp(String employeeFile, String payFile, String commentFile, String reportFile, char delimiter) throws IOException {
        employeeData = new PaySysDb(employeeFile, delimiter);
        paySlipData = new PaySysDb(payFile, delimiter);
        commentsData = new PaySysDb(commentFile, delimiter);
        reportData = new PaySysDb(reportFile, delimiter);

        while (employeeData.hasNext()) {
            String[] parts = employeeData.getNext();

            String middleName;

            int trn = Integer.parseInt(parts[0]);
            int nis = Integer.parseInt(parts[1]);
            int yob = Integer.parseInt(parts[2]);
            char gender = parts[3].charAt(0);
            int empID = Integer.parseInt(parts[4]);
            int position = Integer.parseInt(parts[12]);
            float hours = Float.parseFloat(parts[13]);

            if (parts[6].equals("")) {
                middleName = "";
            } else {
                middleName = parts[6];
            }

            Employee newEmployee = new Employee(trn, nis, yob, gender, empID, parts[5], middleName, parts[7], parts[8], parts[9], parts[10], parts[11], position, hours);
            employeeList.add(newEmployee);
        }

        while (paySlipData.hasNext()) {
            String[] parts = paySlipData.getNext();

            String paySlip = parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + parts[6] + "," + parts[7];
            paySlipList.add(paySlip);
        }

        while (commentsData.hasNext()) {
            String[] parts = commentsData.getNext();

            String comment = parts[0] + "," + parts[1];
            commentList.add(comment);
        }

        while (reportData.hasNext()) {
            String[] parts = reportData.getNext();

            String report = parts[0] + "," + parts[1];
            reportList.add(report);
        }
    }

    public void addEmployee(String trn, String nis, String yob, String gender, String fName, String mName, String lName, String pos) {
        try {
            int taxNum = Integer.parseInt(trn);
            int natIns = Integer.parseInt(nis);
            int birth = Integer.parseInt(yob);
            int position = Integer.parseInt(pos);
            char gen = '\0';
            if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")) {
                gen = gender.charAt(0);
            }
            Employee newEmployee = new Employee(taxNum, natIns, birth, Character.toUpperCase(gen), fName, mName, lName, position);
            newEmployee.setEmployeeID(num);
            employeeList.add(newEmployee);
            num++;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number or character");
        }
    }

    public void removeEmployee(String iD) {
        try {
            int id = Integer.parseInt(iD);
            employeeList.removeIf(employee -> employee.getEmployeeID() == id);
        } catch (Exception e) {
            System.out.println("Invalid number or employee ID not in system");
        }
    }

    public void updateFirstName(String iD, String fName) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getName().setFirstName(fName);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID ");
        }

    }

    public void updateMiddleName(String iD, String mName) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getName().setMiddleName(mName);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid ID");
        }

    }

    public void createAddress (String id, String country, String parish, String town, String street) {
        try {
            int iD = Integer.parseInt(id);
            for (Employee employee : employeeList){
                if (employee.getEmployeeID()==iD){
                    Address addr = new Address(country,parish,town,street);
                    employee.setAddress(addr);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void updateLastName(String iD, String lName) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getName().setLastName(lName);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid ID");
        }
    }

    public void updateStreet(String iD, String street) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getAddress().setStreet(street);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    public void updateTown(String iD, String town) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getAddress().setTown(town);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    public void updateParish(String iD, String parish) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getAddress().setParish(parish);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    public void updateCountry(String iD, String country) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.getAddress().setCountry(country);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    public void addHours(String iD, String hours) {
        try {
            int id = Integer.parseInt(iD);
            float hrs = Float.parseFloat(hours);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.setHours(hrs);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID or hours");
        }

    }

    public void deleteHours(String iD, String hours) {
        try {
            int id = Integer.parseInt(iD);
            float hrs = Float.parseFloat(hours);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    employee.takeHours(hrs);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID or hours");
        }

    }

    public void changePosition(String iD, String val) {
        try {
            int id = Integer.parseInt(iD);
            int num = Integer.parseInt(val);
            for (Employee employee : employeeList) {
                if (num==0 || num==1 && employee.getEmployeeID()==id) {
                        employee.setPosition(num);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID or Position value");
        }
    }


    public String generatePaySlip(String iD, String extra, String deduction) {
        float salary;
        float bonus = Float.parseFloat(extra);
        float deductions = Float.parseFloat(deduction);
        float totals = 0;
        float netPay = 0;
        String result = "";
        int id;

        try {
            id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID()==id){
                    if (employee.getHours()<1) {
                        return "Employee Has Not Worked Any Hours As Yet";
                    }
                    if (employee.getPosition()==Position.JUNIORSTAFF){
                        salary = employee.getHours()*jnrRate;
                        totals = salary + bonus;
                        netPay = (totals-deductions);
                        result = "                                                                  Sunnyside beauty supplies ltd                                ".toUpperCase()+"\n" +
                                "                                                                       Location:Lucea,Negril                                ".toUpperCase()+"\n"+
                                "                                                             \tTelephone#:876-5865-9658||876-578-9658                                ".toUpperCase()+"\n"+
                                "                                                            \tEmployee Payslip                               ".toUpperCase() + "\n\n"+

                                "           ----------------------------------------------------------------------------------------------------------------------------------------\n" +
                                "\nName:  " + employee.getName().getLastName().toUpperCase() + ", " + employee.getName().getFirstName() + "  \tEmp. ID: " + employee.getEmployeeID() + "\tTRN: " + employee.getTRN() +
                                "\n\nSalary: \t" + salary + "\n\nBonus: \t\t" + bonus  +"\n           ----------------------------------------------------------------------------------------------------------------------------------------\n\n" +
                                "\n\nDeductions: " + deductions + "\n\nTOTALS: \t" + totals + "\n\nNET PAY: \t" +netPay;

                        paySlipList.add(id + "," + employee.getHours() + "," + jnrRate + "," + salary + "," + bonus + "," + deductions + "," + totals + "," + netPay);
                        employee.resetHours();
                    } else if (employee.getPosition()==Position.SENIORSTAFF){

                        salary = employee.getHours() * snrRate;
                        totals = salary + bonus;
                        netPay = totals - deductions;
                        result = "                                                                  Sunnyside beauty supplies ltd                                ".toUpperCase() + "\n" +
                                "                                                                       Location:Lucea,Negril                                ".toUpperCase() + "\n" +
                                "                                                             \tTelephone#:876-5865-9658||876-578-9658                                ".toUpperCase() + "\n" +
                                "                                                            \tEmployee Payslip                               ".toUpperCase() + "\n\n" +

                                "           ----------------------------------------------------------------------------------------------------------------------------------------\n" + "\nName:  " + employee.getName().getLastName().toUpperCase() + ", " + employee.getName().getFirstName() + "  \tEmp. ID: " + employee.getEmployeeID() + "\tTRN: " + employee.getTRN() +
                                "\n\nSalary: \t" + salary + "\n\nBonus: \t\t" + bonus + "\n           ----------------------------------------------------------------------------------------------------------------------------------------\n\n" +
                                "\n\nDeductions: " + deductions + "\n\nTOTALS: \t" + totals + "\n\nNET PAY: \t" + netPay;

                        paySlipList.add(id + "," + employee.getHours() + "," + jnrRate + "," + salary + "," + bonus + "," + deductions + "," + totals + "," + netPay);
                        employee.resetHours();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid ID, Extra, Or Deduction Values");
        }
        return result;
//        NumberFormat.getCurrencyInstance().format(v)
//  import java.text.NumberFormat;

    }


    public String searchById(String iD) {

        String searchID = "";
        Employee temp = null;
        int id = 0;
        try {
            id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id && employee.getAddress() != null) {
                    temp = employee;
                    searchID += employee.getName().toString() + "\n" + employee.getAddress().toString() + "\n" + employee.getPosition() + "\nEmployee ID: " + employee.getEmployeeID() + "\n" + "Hours on record: " + employee.getHours();
                } else if (employee.getEmployeeID() == id && employee.getAddress() == null) {
                    temp = employee;
                    searchID += employee.getName().toString() + "\n" + employee.getPosition() + "\nEmployee ID: " + employee.getEmployeeID() + "\nHours on record: " + employee.getHours();

                }
            }

            String payVal = null;
            for (String pay : paySlipList) {
                String[] slip = pay.split(",");
                if (slip[0].strip().equals(String.valueOf(id))) {
                    payVal = pay;
                }
            }

            String paySlip = null;
            if (payVal!=null && temp!=null) {
                String[] values = payVal.split(",");

            paySlip = "\nSunnySide Beauty Supplies Ltd.\n \nName:  " + temp.getName().getLastName().toUpperCase() + ", " + temp.getName().getFirstName()
                    + "  \tEmp. ID: " + temp.getEmployeeID() + "\tTRN: " + temp.getTRN() + "\n\nHours: \t\t" + values[1] +"\n\nRate Paid: \t" + values[2] + "\n\nSalary: \t" + values[3] + "\n\nBonus: \t\t" + values[4]
                    + "\n\nDeductions: " + values[5] + "\n\nTOTALS: \t" + values[6] + "\n\nNET PAY: \t" + values[7];
            searchID+=paySlip;
            }

        } catch (NumberFormatException e) {
            return "Invalid Id";
        }
        return searchID;
    }

    public String searchByFirstName(String fName) {
        String searchFName = "";
        Employee temp = null;
        int id = 0;
        try {
            for (Employee employee : employeeList) {
                temp = employee;
                if (employee.getName().getFirstName().equalsIgnoreCase(fName) && employee.getAddress()!=null) {
                    id = employee.getEmployeeID();
                    searchFName += employee.getName().toString() + "\n" + employee.getAddress().toString() + "\n" + employee.getPosition()
                            + "\nEmployee ID: " + employee.getEmployeeID() + "\n" + "Hours on record: " + employee.getHours();
                } else if (employee.getName().getFirstName().equalsIgnoreCase(fName) && employee.getAddress()==null){
                    temp = employee;
                    id = employee.getEmployeeID();
                    searchFName += employee.getName().toString() + "\n" + employee.getPosition()
                            + "\nEmployee ID: " + employee.getEmployeeID() + "\n" + "Hours on record: " + employee.getHours();
                }
            }

            String payVal = null;
            for (String pay : paySlipList) {
                String[] slip = pay.split(",");
                if (slip[0].strip().equals(String.valueOf(id))) {
                    payVal = pay;
                }
            }

            String paySlip = null;

            if (payVal!=null && temp!=null) {
                String[] values = payVal.split(",");

                paySlip = "\nSunnySide Beauty Supplies Ltd.\n \nName:  " + temp.getName().getLastName().toUpperCase() + ", " + temp.getName().getFirstName()
                        + "  \tEmp. ID: " + temp.getEmployeeID() + "\tTRN: " + temp.getTRN() + "\n\nHours: \t\t" + values[1] +"\n\nRate Paid: \t" + values[2] + "\n\nSalary: \t" + values[3] + "\n\nBonus: \t\t" + values[4]
                        + "\n\nDeductions: " + values[5] + "\n\nTOTALS: \t" + values[6] + "\n\nNET PAY: \t" + values[7];
                searchFName+=paySlip;
            }

        } catch (Exception e) {
            return "Person with first name " + fName + " cannot be found";
        }
        return searchFName;
    }

    public String searchByLastName(String lName) {
        String searchLName = "";
        Employee temp = null;
        int id = 0;
        try {
            for (Employee employee : employeeList) {
                if (employee.getName().getLastName().equalsIgnoreCase(lName) && employee.getAddress()!=null) {
                    temp = employee;
                    id = employee.getEmployeeID();
                    searchLName += employee.getName().toString() + "\n" + employee.getAddress().toString() + "\n" + employee.getPosition()
                            + "\nEmployee ID: " + employee.getEmployeeID() + "\n" + "Hours on record: " + employee.getHours();
                } else if (employee.getName().getLastName().equalsIgnoreCase(lName) && employee.getAddress()==null){
                    temp = employee;
                    searchLName += employee.getName().toString() + "\n" + employee.getPosition()
                            + "\nEmployee ID: " + employee.getEmployeeID() + "\n" + "Hours on record: " + employee.getHours();
                }
            }

            String payVal = null;
            for (String pay : paySlipList) {
                String[] slip = pay.split(",");
                if (slip[0].strip().equals(String.valueOf(id))) {
                    payVal = pay;
                }
            }

            String paySlip = null;

            if (payVal!=null && temp!=null) {
                String[] values = payVal.split(",");

                paySlip = "\nSunnySide Beauty Supplies Ltd.\n \nName:  " + temp.getName().getLastName().toUpperCase() + ", " + temp.getName().getFirstName()
                        + "  \tEmp. ID: " + temp.getEmployeeID() + "\tTRN: " + temp.getTRN() + "\n\nHours: \t\t" + values[1] +"\n\nRate Paid: \t" + values[2] + "\n\nSalary: \t" + values[3] + "\n\nBonus: \t\t" + values[4]
                        + "\n\nDeductions: " + values[5] + "\n\nTOTALS: \t" + values[6] + "\n\nNET PAY: \t" + values[7];
                searchLName+=paySlip;
            }


        } catch (Exception e) {
            return "Person with last name " + lName + " cannot be found";
        }
        return searchLName;
    }


    public void makeComment(String iD, String comment) {
        try {
            int id = Integer.parseInt(iD);
            for (Employee employee : employeeList) {
                if (employee.getEmployeeID() == id) {
                    commentList.add(id + "," + comment);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }

    }

    public String viewComment(String iD) {
        String cmt = "";
        try {
            for (String comment : commentList) {
                if (comment.contains(iD)) {
                    cmt += comment + "\n";
                }
            }
        } catch (Exception e) {
            return "Invalid ID";
        }
        return cmt;
    }

    public String deleteComment(String iD) {
        try {
            commentList.removeIf(cmt -> cmt.contains(iD));
            return "Comment deleted";
        } catch (Exception e) {
            return "Invalid ID";
        }
    }

    public String generateReport () {
        return "";
    }


    public void shutDown () throws IOException {
        employeeData.rewrite();
        paySlipData.rewrite();
        commentsData.rewrite();
        reportData.rewrite();

        for (Employee employee : employeeList) {
            employeeData.putNext(putEmployeeInfo(employee));
        }
        for (String slip : paySlipList) {
            paySlipData.putNext(putPaySlip(slip));
        }
        for (String comment : commentList) {
            commentsData.putNext(putComment(comment));
        }
        for (String report : reportList) {
            reportData.putNext(putReport(report));
        }
        System.exit(0);

    }


    //Helper functions
    public String[] putEmployeeInfo(Employee employee){
        int pos;
        if (employee.getPosition()==Position.SENIORSTAFF){
            pos = 0;
        } else {
            pos = 1;
        }

        String str;
        if (employee.getAddress()!=null){
            str = employee.getTRN() + "," + employee.getNIS() + "," + employee.getYOB() + "," + employee.getGender() + "," + employee.getEmployeeID() + "," + employee.getName().getFirstName() + "," + employee.getName().getMiddleName() + "," + employee.getName().getLastName() + "," + employee.getAddress().getCountry() + "," + employee.getAddress().getParish() + "," + employee.getAddress().getTown() + "," + employee.getAddress().getStreet() + "," + pos + "," + employee.getHours();
        } else {
            str = employee.getTRN() + "," + employee.getNIS() + "," + employee.getYOB() + "," + employee.getGender() + "," + employee.getEmployeeID() + "," + employee.getName().getFirstName() + "," + employee.getName().getMiddleName() + "," + employee.getName().getLastName() + "," +  "" + "," +  "" + "," + "" + "," + "" + "," + pos + "," + employee.getHours();
        }
        return str.split(",",-1);
    }

    public String [] putPaySlip (String paySlip) {
        return paySlip.split(",");
    }

    public String [] putComment (String comment) {
        return comment.split(",");
    }

    public String [] putReport (String report) {
        return report.split(",");
    }


    public static void main (String[] args) throws IOException {
        //Testing Method
        PaySysApp app = new PaySysApp("PaySysEmp.txt", "PaySysSlip.txt", "PaySysCom.txt", "PaySysRep.txt", ',');
        System.out.println(app.searchById("0") + "\n");
        System.out.println(app.searchByFirstName("Marsha"));
        //app.addEmployee("12345", "789", "1992", "m", "John", "Jack", "Jones", "0");
        //System.out.println(app.searchById("7"));
        //System.out.println(app.searchByLastName("jones"));
        //String str = "Employee Name" + "\t \t Address" + "\t \t Salary" +  "\t \t Hours"  +  "\t" +"\t" + "Something" + "\n " + "John James"  + "\t" +"\t" + "Montego Bay DR" + "\t" +"\t " + "$458000" + "\t" + "48hours" + "\t" + "\t" + "SOmething";
        //String str = "Employee Name" + "\t \t Address" + "\n" +
        //    "John James" + "\t \t Back Road, Somewhere" + "\n \nSalary" + "\t \t \t Hours"  + "\n$45000.00" + "\t \t 200 hrs" + "\n \n";
    }
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

interface Employee {
    void detail();
    void output();
}

class EmployeeDetail implements Employee {
    Scanner in = new Scanner(System.in);
    static int id=1;
    static ArrayList<Integer> employeeID = new ArrayList<Integer>();
    static ArrayList<Long> phoneNo = new ArrayList<Long>();
    static ArrayList<String> name = new ArrayList<String>();
    static ArrayList<Date> dob = new ArrayList<Date>();
    static ArrayList<Integer> salary=new ArrayList<Integer>();
    static ArrayList<Integer> employeeAge = new ArrayList<Integer>();
    static ArrayList<Integer> departmentID=new ArrayList<Integer>();
    static ArrayList<String> departmentDetail=new ArrayList<String>();
    class Calculate
    {
        int age;
        int calculateAge()
        {
            try
            {
                int n=dob.size() - 1;
                Date date=dob.get(n);
                Calendar c =Calendar.getInstance();
                c.setTime(date);
                int birthYear=c.get(Calendar.YEAR);
                int currentYear=Year.now().getValue();
                age=currentYear - birthYear;
                return age;
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e);
                return 0;
            }
            catch (Exception e)
            {
                System.out.println(e);
                return 0;   
            }
        }
        
        int calculateAge(int n) {
            try {
                Date date = dob.get(n);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int birthYear = c.get(Calendar.YEAR);
                int currentYear = Year.now().getValue();
                age = currentYear - birthYear;
                return age;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                return 0;
            } catch (Exception e) {
                System.out.println(e);
                return 0;
            }
        }
    }
    public void detail()
    {
        try
        {
            System.out.println("Enter Employee Name - ");
            name.add(in.nextLine());
            System.out.println("Enter Mobile Number - ");
            phoneNo.add(in.nextLong());
            System.out.println("Enter Date of Birth in format dd/mm/yyyy like(01/01/2020)- ");
            String date = in.next();
            Date d;
            d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            dob.add(d);
            Calculate ob=new Calculate();
            int aaa=ob.calculateAge();
            employeeAge.add(aaa);
            employeeID.add(id);
            id++;
            System.out.println("Enter Salary - ");
            salary.add(in.nextInt());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
    void salaryUpdate(double a)
    {
        if(salary.size()==0)
        {
            System.out.println("No record found");
        }
        else
        {
            for(int i=0;i<salary.size();i++)
            {
                int sal=salary.get(i);
                sal=sal+(int)((sal*a)/100);
                salary.set(i, sal);
            }
        }
    }
    void salaryUpdate(int a,double p)
    {
        if(employeeID.contains(a) && salary.size()!=0)
        {
            int i=employeeID.indexOf(a);
            int sal=salary.get(i);
            sal=sal+(int)((sal*p)/100);
            salary.set(i, sal);
            System.out.println("Your employee salary with employee id " + a + " has been updated");
        }
        else
        {
            System.out.println("Employee not found");
        }
    }
    void removeEmployee()
    {
        name.clear();
        employeeID.clear();
        phoneNo.clear();
        dob.clear();
        salary.clear();
        departmentID.clear();
        departmentDetail.clear();
        System.out.println("All record is removed");
    }
    void removeEmployee(int a)
    {
        if(employeeID.contains(a))
        {
            int i = employeeID.indexOf(a);
            name.remove(i);
            employeeID.remove(i);
            phoneNo.remove(i);
            dob.remove(i);
            salary.remove(i);
            departmentID.remove(i);
            departmentDetail.remove(i);
            System.out.println("Your employee with employee id " + a + " has been removed successfully");
        }
        else
        {
            System.out.println("Employee not found so can't be removed");
        }
    }
    void employeeUpdate(int a)
    {
        if(employeeID.contains(a))
        {
            int i=employeeID.indexOf(a);
            System.out.println("What you want to update - ");
            System.out.println("1 - Name");
            System.out.println("2 - DOB");
            System.out.println("3 - Salary");
            int n=in.nextInt();
            switch(n)
            {
                case 1:
                    System.out.println("Enter Name - ");
                    String na=in.next();
                    name.set(i, na);
                    break;
                case 2:
                try {
                        System.out.println("Enter DOB dd/mm/yyyy like(01/01/2020) - ");
                        String date = in.next();
                        Date d;
                        d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                        dob.set(i,d);
                        Calculate ag=new Calculate();
                        employeeAge.set(i, ag.calculateAge(i));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Enter Salary - ");
                    int s=in.nextInt();
                    salary.set(i, s);
                    break;
                default:
                    System.out.println("Please enter the valid serial number :");
                    employeeUpdate(a);
            }
        }
        else
        {
            System.out.println("Employee not found");
        }
    }
    public void output()
    {
        System.out.println("Detail of the employees are - ");
        System.out.println("Employee ID\tName\t\tPhone No.\tDate of birth\tAge\tDepartmet ID\tDepartment Detail\tSalary");
        for(int i=0;i<employeeID.size();i++)
        {
            Calendar c = Calendar.getInstance();
            c.setTime(dob.get(i));
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH)+1;
            int date=c.get(Calendar.DATE);
            LocalDate l1=LocalDate.of(year, month, date);
            System.out.println(employeeID.get(i)+"\t\t"+name.get(i)+"\t\t"+phoneNo.get(i)+"\t"+l1+"\t"+employeeAge.get(i)+"\t"+departmentID.get(i)+"\t\t"+departmentDetail.get(i)+"\t\t\t"+salary.get(i));
        }
    }
}
class Technical extends EmployeeDetail
{
    static int id=100000;
    public void detail()
    {
        
        System.out.println("Select the technical department by entering particular serial number - ");
        System.out.println("Serial No.\t Department Name");
        System.out.println("\t1\t\t\tSenior Developer");
        System.out.println("\t2\t\t\tJunior Developer");
        System.out.println("\t3\t\t\tSoftware Maintainer");
        System.out.println("\t4\t\t\tTester");
        System.out.println("Enter Serial number - ");
        int n =in.nextInt();
        int flag=0;
        switch(n)
        {
            case 1:
                departmentDetail.add("Senior Developer");
                flag=1;
                break;
            case 2:
                departmentDetail.add("Junior Developer");
                flag = 1;
                break;
            case 3:
                departmentDetail.add("Software Maintainer");
                flag = 1;
                break;
            case 4:
                departmentDetail.add("Tester");
                flag = 1;
                break;
            default:
                System.out.println("Please enter the valid serial number Try again");
                detail();
                break;
        }
        if(flag==1)
        {
            departmentID.add(id++);
        }
    }
}
class NonTechnical extends EmployeeDetail
{
    static int id = 200000;
    public void detail()
    {
        System.out.println("Select the non-technical department by entering particular serial number - ");
        System.out.println("Serial No.\t Department Name");
        System.out.println("\t1\t\t\tHR");
        System.out.println("\t2\t\t\tOperations Manager");
        System.out.println("\t3\t\t\tAccount Manager");
        System.out.println("\t4\t\t\tCopywriter");
        System.out.println("Enter Serial number - ");
        int n = in.nextInt();
        int flag=0;
        switch (n) 
        {
            case 1:
                departmentDetail.add("HR");
                flag=1;
                break;
            case 2:
                departmentDetail.add("Operation Manager");
                flag=1;
                break;
            case 3:
                departmentDetail.add("Account Manager");
                flag=1;
                break;
            case 4:
                departmentDetail.add("Copywriter");
                flag=1;
                break;
            default:
                System.out.println("Please enter the valid serial number Try again");
                detail();
                break;
        }
        if(flag==1)
        {
            departmentID.add(id++);
        }
    }
}
class Emp
{
    void empl()
    {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println(
                    "Press 1 to enter detail\nPress 2 to update detail\nPress 3 to add bonus to the salary\nPress 4 to remove employee\nPress 5 to display record\nPress 0 to exit");
            int n = in.nextInt();
            switch (n) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    EmployeeDetail o1 = new EmployeeDetail();
                    o1.detail();
                    int flag1 = 1;
                    while (flag1 == 1) {
                        System.out.println("Press 1 for technical Department\nPress 2 for the Non-technical department\nPress 0 to exit");
                        int a1 = in.nextInt();
                        switch (a1) {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                EmployeeDetail ob1 = new Technical();
                                ob1.detail();
                                flag1 = 0;
                                break;
                            case 2:
                                EmployeeDetail ob2 = new NonTechnical();
                                ob2.detail();
                                flag1 = 0;
                                break;
                            default:
                                System.out.println("Please Enter the valid number");
                                flag1 = 1;
                        }
                    }
                    break;
                case 2:
                    EmployeeDetail c2 = new EmployeeDetail();
                    System.out.println("Enter the employee id - ");
                    int ac2 = in.nextInt();
                    c2.employeeUpdate(ac2);
                    break;
                case 3:
                    EmployeeDetail c3 = new EmployeeDetail();
                    int flag2 = 1;
                    while (flag2 == 1) {
                        System.out.println("Press 1 to add bonus to all\nPress 2 to add on particular employee");
                        int ac3 = in.nextInt();
                        switch (ac3) {
                            case 1:
                                System.out.println("Enter the percentage value only of the bonus - ");
                                double acc1 = in.nextDouble();
                                c3.salaryUpdate(acc1);
                                flag2 = 0;
                                break;
                            case 2:
                                System.out.println("Enter the id of the employee - ");
                                int acc2 = in.nextInt();
                                System.out.println("Enter the percentage value only of the bonus - ");
                                double acc3 = in.nextDouble();
                                c3.salaryUpdate(acc2, acc3);
                                flag2 = 0;
                                break;
                            default:
                                System.out.println("Please enter the valid number");
                                flag2 = 1;
                        }

                    }
                    break;
                case 4:
                    EmployeeDetail c4 = new EmployeeDetail();
                    int flag3 = 1;
                    while (flag3 == 1) {
                        System.out.println("Press 1 to remove all\nPress 2 to remove particular employee");
                        int ac4 = in.nextInt();
                        switch (ac4) {
                            case 1:
                                c4.removeEmployee();
                                flag3 = 0;
                                break;
                            case 2:
                                System.out.println("Enter the id of the employee - ");
                                int acc1 = in.nextInt();
                                c4.removeEmployee(acc1);
                                flag3 = 0;
                                break;
                            default:
                                System.out.println("Please enter the valid number");
                                flag3 = 1;
                        }
                    }
                    break;
                case 5:
                    Employee c5 = new EmployeeDetail();
                    c5.output();
                    break;
                default:
                    System.out.println("Please Enter the valid value");
                    break;
            }
        } while (true);
    }
    public static void main(String[] args) {
        System.out.println("\n\t\t\t\t\t\tWelcome to the Employee Managment System");
        Emp oo=new Emp();
        oo.empl();        
    }
}
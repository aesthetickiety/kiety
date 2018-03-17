import java.io.*;
import java.util.*;
class Account
{
  String Name,Password;
  int AccNo,Money;
  int dd,mm,yy;
  public Account(String n,int an,int d,int m,int y,int mon,String p)
  {
    Name=n;
    AccNo=an;
    dd=d;
    mm=m;
    yy=y;
    Money=mon;
    Password=p;
  }
  public void displayData()
  {
    System.out.println(AccNo+"\t"+Name+"\t\t"+dd+"/"+mm+"/"+yy+"\t"+Money+"\t\t"+Password);
  }
}

public class Bank
{
  public static Calendar c=Calendar.getInstance();
  public static int date=c.get(Calendar.DATE);
  public static int month=c.get(Calendar.MONTH);
  public static int year=c.get(Calendar.YEAR);
  public static InputStreamReader isr=new InputStreamReader(System.in);
  public static BufferedReader x=new BufferedReader(isr);
  public static int Ano=1;
  public static Account Acc[]=new Account[100];
  public static void main() throws IOException
  {
    int ch=1;
    startAccount();
    do
    {
      System.out.println("  Welcome to State Bank   ");
      System.out.println("   --: OPTION MENU :--    ");
      System.out.println("   1. Create Account      ");
      System.out.println("   2. Withdrawl           ");
      System.out.println("   3. Deposited           ");
      System.out.println("   4. Checking Account    ");
      System.out.println("   5. Checking Master     ");
      System.out.println("   6. Exit                ");
      System.out.print(  "Enter Your Choice(1-6) : ");
      ch=Integer.parseInt(x.readLine());
      switch(ch)
      {
        case 1: createAccount(); break;
        case 2: withdrawl(); break;
        case 3: deposit(); break;
        case 4: checkAccount(); break;
        case 5: checkMaster(); break;
      }
    }while(ch<=5);
  }
  private static void createAccount() throws IOException
  {
    Calendar c=Calendar.getInstance();
    int date=c.get(Calendar.DATE);
    int month=c.get(Calendar.MONTH);
    int year=c.get(Calendar.YEAR);
    String n,p;
    int m;
    System.out.println("Your Account Number is : "+Ano);
    System.out.print("Your Name : ");
    n=x.readLine();
    System.out.print("Opening Balance : ");
    m=Integer.parseInt(x.readLine());
    System.out.print("Your Password : ");
    p=x.readLine();
    Acc[Ano]=new Account(n,Ano,date,month,year,m,p);
    Ano++;
  }
  private static void withdrawl() throws IOException
  {
    String p;
    int no,amt;
    System.out.print("Your Account Number : ");
    no=Integer.parseInt(x.readLine());
    System.out.print("Password : ");
    p=x.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Welcome "+Acc[no].Name);
      System.out.print("Withdrawl Amount : ");
      amt=Integer.parseInt(x.readLine());
      if(amt<=Acc[no].Money)
        Acc[no].Money-=amt;
      else
        System.out.println("Only "+Acc[no].Money+" amount left in your Account");
    }
    else
      System.out.println("Your are Unauthorized Customer");
  }
  private static void deposit() throws IOException
  {
    String p;
    int no,amt;
    System.out.print("Your Account Number : ");
    no=Integer.parseInt(x.readLine());
    System.out.print("Password : ");
    p=x.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Welcome "+Acc[no].Name);
      System.out.print("Deposit Amount : ");
      amt=Integer.parseInt(x.readLine());
      Acc[no].Money+=amt;
    }
    else
      System.out.println("Your are Unauthorized Customer");
  }
  private static void checkAccount() throws IOException
  {
    String p;
    int no,amt;
    System.out.print("Your Account No. : ");
    no=Integer.parseInt(x.readLine());
    System.out.print("Password : ");
    p=x.readLine();
    if(no<Ano && p.equals(Acc[no].Password))
    {
      System.out.println("Your Name : "+Acc[no].Name);
      System.out.println("Balance Amount : "+Acc[no].Money);
      int rate=(Acc[no].Money>=20000)?18:10;
      System.out.println("Interest Rate : "+rate+"%");
      int interest=Acc[no].Money*rate/100;
      System.out.println("Current Balance : "+(Acc[no].Money+interest));
    }
    else
      System.out.println("Your are Unauthorized Customer");
  }
  private static void checkMaster()
  {
    System.out.println("Acc\tName\t\tDate\t\tMoney\t\tPassword");
    for(int i=1;i<Ano;i++)
      Acc[i].displayData();
  }      
  private static void startAccount()
  {
    Acc[Ano]=new Account("Srijan",Ano,date,month,year,500,"ABC");  Ano++;
    Acc[Ano]=new Account("Nikhil",Ano,date,month,year,500,"XYZ");  Ano++;
    Acc[Ano]=new Account("Shivank",Ano,date,month,year,500,"MNO");  Ano++;
  }
}
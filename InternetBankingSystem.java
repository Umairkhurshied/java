class Account {   // the 'monitor'
   int balance=200;
// if 'synchronized' is removed, the outcome is unpredictable
 public synchronized void deposit(int deposit_amount ) {
    // METHOD BODY : 
    System.out.println(Thread.currentThread().getName()+"Started Deopisting");

   balance += deposit_amount;
System.out.println(Thread.currentThread().getName()+"completed Deopisting");
  } 

   public  synchronized void withdraw(int deposit_amount ) {
                  

	 // METHOD BODY: 
             System.out.println(Thread.currentThread().getName()+"Started WithDrawing");
             balance -= deposit_amount;
             System.out.println(Thread.currentThread().getName()+"Completed WithDrawing");
   } 
   public synchronized  void enquire( ) {
	 // METHOD BODY: display balance.
System.out.println(Thread.currentThread().getName()+"Inquirey Started");
    System.out.println("Balance is"+balance);
    System.out.println(Thread.currentThread().getName()+"Inquirey Completed");
   }
}

class MyThread implements Runnable  {
 Account account;
        public MyThread (Account s) {  account = s;}
        public void run() 
            {
         //System.out.println("MYThread is depositing"); 
        account.deposit(1000); }
} // end class MyThread

class YourThread implements Runnable  {
 Account account;
        public YourThread (Account s) { account = s;}
        public void run() { 
//System.out.println("YourThread is witdrawing");
account.withdraw(500);
//account.deposit(1000);
 }     
} // end class YourThread

class HerThread implements Runnable  {
 Account account;
        public HerThread (Account s) { account = s; }
        public void run() {
//System.out.println("Her Thread Enquiring");
account.enquire(); }
} // end class HerThread



public class InternetBankingSystem {
        public static void main(String [] args  ) {
            Account accountObject = new Account (); 
            Thread t1 = new Thread(new MyThread(accountObject));
               Thread t2 = new Thread(new YourThread(accountObject));
               Thread t3 = new Thread(new HerThread(accountObject));
            t1.setName("A");
            t2.setName("B");
             t3.setName("C");
            t1.start();
            t2.start();
            t3.start();
          // DO some other operation
       } // end main()
}   

class threaddemo implements Runnable
{

 public void run()
{
    try
{
     for(int i=0;i<5;i++)
{
          System.out.println(Thread.currentThread()+"I="+i);
           Thread.sleep(2000);
}
}
catch(InterruptedException e)
{
   System.out.println(e.toString());
}
}
}
class testthread
{
   public static void main(String ar[])
{
   System.out.println("Running main thread"+Thread.currentThread());
  threaddemo td=new threaddemo();
   Thread t1=new Thread(td);
   Thread t2=new Thread(td);
   Thread t3=new Thread(td);
   Thread t4=new Thread(td);
      t1.setName("A");
       t2.setName("B");
       t3.setName("C");
       t4.setName("D");
    	t4.setPriority(10);
     	t3.setPriority(8);
	t2.setPriority(7);
	t1.setPriority(5);
     
t1.start();
t2.start();
t3.start();
t4.start();
 
try
{
     for(int i=0;i<5;i++)
{
          System.out.println(Thread.currentThread()+"I="+i);
           Thread.sleep(2000);
}
}
catch(InterruptedException e)
{
   System.out.println(e.toString());
}
}
}
   
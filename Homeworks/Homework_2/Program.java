class Program {
	public static void main(String[] args){
		int x5 = 5000; int x2 = 2000; int x1 = 1000; int x05 = 500; int x02 = 200; int x01 = 100; int x005 = 50; int x001 = 10; int x0005 = 5; int x0002 = 2; int y = 0;
		int number = 13765;
		x5 = number / 5000; y = number - (x5*5000);
		x2 = y / 2000; y = y - (x2*2000);
		x1 = y / 1000; y = y - (x1*1000);
		x05 = y / 500; y = y - (x05*500);
		x02 = y / 200; y = y - (x02*200);
		x01 = y / 100; y = y - (x01*100);
		x005 = y / 50; y = y - (x005*50);
		x001 = y / 10; y = y - (x001*10);
		x0005 = y / 5; y = y - (x0005*5);
		x0002 = y / 2; 

System.out.println(x5); 
System.out.println(x2); 
System.out.println(x1);
System.out.println(x05);
System.out.println(x02);
System.out.println(x01);
System.out.println(x005);
System.out.println(x001);
System.out.println(x0005);
System.out.println(x0002);
	}
}
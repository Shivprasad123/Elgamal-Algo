import java.io.*;
import java.util.*;
import java.net.*;
import java.math.BigInteger;

class ElgamalSer{
	static BigInteger prime;
	static BigInteger pri;
	static Random ran = new Random();
	static Scanner sc = new Scanner(System.in);
	static int flag = 0,flag1=0,flag2=0;
	public static void main(String arg[]) throws IOException , NoSuchElementException{
		ServerSocket s1 = new ServerSocket(12345);
		System.out.println("Server Started...............");
		System.out.println("Waiting for Client....");
		Socket ss = s1.accept();
		System.out.println("Server got Client");
		int len1=1024;
		int len2=1000;
		System.out.println("Prime number Generated:");
		prime = BigInteger.probablePrime(len1,ran);
			System.out.println(prime);
		System.out.println("Generated Primitve Root:");
		BigInteger m;
		do{
			pri = new BigInteger(10,ran);

		m = (prime.subtract(new BigInteger("1"))).divide(new BigInteger("2"));
		}while(pri.modPow(m,prime) == new BigInteger("1"));
		//pri = sc.nextBigInteger();
		Scanner sc1 = new Scanner(ss.getInputStream());
		PrintStream p= new PrintStream(ss.getOutputStream());
		String str2="";
		System.out.println("Prim :\n"+pri);
		p.println(prime);
		p.println(pri);
		BigInteger b;
		int j;
		int len = sc1.nextInt();
		for(int i=0;i<len;i++){
		do {
			b = BigInteger.probablePrime(len2, ran);
		} while (b.compareTo(new BigInteger("2")) <=0);
		BigInteger y = pri.modPow(b,prime);
		System.out.println("Generated Value Of B:"+b);

		p.println(y);
		BigInteger x = sc1.nextBigInteger();
		BigInteger key = x.modPow(b,prime);
		j=i+1;
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Key Generated Server:"+j+" :"+key);
		
		//int len = sc1.nextInt();
		System.out.println("Len:"+len);
		//for(int i=0;i<len;i++){
			BigInteger emsg = sc1.nextBigInteger();
			System.out.println("---------------------------------------------------------------------");
//			System.out.println(emsg);
			BigInteger dmsg = emsg.multiply(key.modInverse(prime)).mod(prime);
			//System.out.println(dmsg);
			byte dec[] = dmsg.toByteArray();
			String str3 = new String(dec,"UTF-8");
			System.out.println(str3+"\t");
			str2 = str2 +" " +str3;
		}

			System.out.println("---------------------------------------------------------------------");
		System.out.println("Decrepted Message:\n"+str2);
			System.out.println("---------------------------------------------------------------------");
	}
}

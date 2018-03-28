import java.io.*;
import java.util.*;
import java.net.*;
import java.math.BigInteger;

class ElgamalCli{
	static BigInteger pri,prime;
	static Random ran = new Random();
	static Scanner sc = new Scanner(System.in);
	public static void main(String arg[]) throws IOException , UnknownHostException,NoSuchElementException{
		
		Socket s = new Socket("127.0.0.1",12345);
		System.out.println("Got the server");
		int bitlength = 1000;
		Scanner sc1 = new Scanner(s.getInputStream());
		PrintStream p = new PrintStream(s.getOutputStream());

		BigInteger prime = sc1.nextBigInteger();
		BigInteger pri = sc1.nextBigInteger();
		
		BigInteger a;
		System.out.println("Enter Msg:");
		String str = sc.nextLine();
		String[] st = str.split(" ");
		int len = st.length;
		p.println(len);
		int j;
		for(int i=0;i<st.length;i++){
		do {
			    a = BigInteger.probablePrime(bitlength, ran);
		} while (a.compareTo(new BigInteger("2")) <=0);
		System.out.println("--------------------------------------------------------------------");
		j=i+1;
		System.out.println("Generated value of A "+j+" :"+a);
		BigInteger  y = sc1.nextBigInteger();
		BigInteger x = pri.modPow(a,prime);
		
		
		p.println(x);	
		BigInteger key = y.modPow(a,prime);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Key Generated:"+j+" :"+key);
		System.out.println("---------------------------------------------------------------------");
		BigInteger emsg;
			System.out.println(st[i]);
			System.out.println("---------------------------------------------------------------------");
			byte msg[] = st[i].getBytes();
			emsg = new BigInteger(msg).multiply(key).mod(prime);
			p.println(emsg);
			System.out.println("Encrypted MSG:\n");
			System.out.print(emsg+"\t");
		//}
	}
	}
}

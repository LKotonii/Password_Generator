package java_classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// a class to get a totally random number as a random seed for further algorithms

public class Random {

	// load random long from random.org
	private static String urlIntegerGenerator = "https://www.random.org/integers/?";
	private static String singleIntegerGenerator = "https://www.random.org/integers/?num=1";
	private static String num = "num=";
	private static String min = "&min=";
	private static String max = "&max=";
	private static String base_format_randomisation = "&col=1&base=10&format=plain&rnd=new";

	// method returns random int from random.org in range from minInt to maxInt
	// @params (int minInt , int maxInt)
	protected static int getRandomInt(int minInt, int maxInt) {
		int random = 0;
		try {
			URL url = new URL(singleIntegerGenerator + min + minInt + max + maxInt + base_format_randomisation);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			random = Integer.parseInt(in.readLine());
			in.close();

			con.disconnect();

		} catch (Exception exc) {
			exc.getMessage();
		}
		return random;
	}

	protected static int[] getNofRandomInt(int N, int minInt, int maxInt) {
		int[] randoms = new int[N];
		
		try {
			URL url = new URL(urlIntegerGenerator + num + N + min + minInt + max + maxInt + base_format_randomisation);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			for (int a = 0; a < N; a++) {
				
				randoms[a] = Integer.parseInt(in.readLine());
				
			}
			in.close();

			con.disconnect();

		} catch (Exception exc) {
			exc.getMessage();
		}
		return randoms;
	}
}

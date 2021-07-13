package webScaper;
import algs4.In;
import algs4.Out;
import algs4.StdIn;
import algs4.StdOut;

public class TickerCleaner {

	public static void main(String[] args) {
		StdIn.fromFile("data/tikerPT1.txt");
		
		Out out;
		out = new Out("data/tickers.txt");
		
		while(StdIn.hasNextLine()) {
			String string = StdIn.readLine();
			if(string != "") {
				out.println(string);
			}
		
		}

	}
	

}

package webScaper;


import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import algs4.Out;
import algs4.StdIn;
import algs4.StdOut;
import algs4.Stopwatch;
import org.jsoup.nodes.Element;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StockPriceScraper {
	
/**
 * @urlFetch returns an array of websites that you can iterate from. It takes in a file 
 * and converts the contents (tickers) into a string array @tickers. Then creates an object @urlObj 
 * from the TickerToURL class that is used in conjunction with a new array @websites to have the
 * URL's stored in the array for later access. All of the tickers in the file are predetermined from
 * a variety of tickers from the S&P 500. Each ticker is converted and stored in an array to a website 
 * URL index of the array for a more simple form of access when using JSOUP to go to the desired 
 * website (from the index of the array @websites) and obtain the ticker prices of each index.
 */
	private static String[] urlFetch() {
		StdIn.fromFile("data/tickers2.txt");
		String[] tickers = StdIn.readAllStrings();
		TickerToURL urlObj = new TickerToURL();
		String[] websites = new String[tickers.length];
		
		for(int i = 0; i < tickers.length; i++) {
			String ticker = tickers[i];
			websites[i] = urlObj.url(ticker);
		}
		return websites;
	}

	private static String price(String tickerURL) throws IOException {
		
		String url = tickerURL;
		final Document doc = (Document) Jsoup.connect(url).get();
	
		Elements  element1 = doc.getElementsByClass("YMlKec fxKbKc");
		String stockPrice = element1.text();		
		return stockPrice;
	}
	
	
	public static void main(String[] args) throws IOException {
		while(true) {
		File f = new File ("C:\\Users\\Humberto\\Desktop\\stockData");
		
		Out out;
		LocalDateTime date = LocalDateTime.now();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		int hour = date.getHour();
		int minute = date.getMinute();
		String dateName = month + "_" + day + "_" + hour + "_" + minute;
		out = new Out("C:\\Users\\Humberto\\Desktop\\stockData"+ "/" + dateName + ".txt" );
	
		 
		 
		 
	      
	      StdOut.println("Current Date and Time: "+ date); 
	      
		Stopwatch timer = new Stopwatch();
		
		// take out urlFetch and have it stored in a new variable so the main function doesn't keep
		// calling the static method and recreating the array
		for(String website : urlFetch()) {  
			
			StdOut.print(website + "---> ");
			out.print(website + "---> ");
			StdOut.println(price(website));
			out.println(price(website));
			
		}
		
		StdOut.println(timer.elapsedTime());
		StdOut.println("Current Date and Time: "+ date);
	}
	


	}

}

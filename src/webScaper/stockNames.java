package webScaper;


import algs4.Out;
import java.io.IOException;

import org.jsoup.nodes.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class stockNames {

	public static void main(String[] args) throws IOException {
		final String url = "https://www.liberatedstocktrader.com/sp-500-companies-list-alphabetically-sorted/";

			final Document doc = (Document) Jsoup.connect(url).get();
			//System.out.println(doc.outerHtml());
			
			Out out;
			out = new Out("data/tikerPT1.txt");
	       
			
			for(Element row : doc.select("table td") ) {
				
				final String ticker = row.select("td:nth-of-type(2)").text();
			  
					out.println((String)ticker);
					
			
			
			
				
				
			}
			out.close();
	}
}

		
		

	



package network;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

public class URLButton extends Applet {
	 URL url = null;
	 String title = null;
	 	 
	 public void init() {
		 String urlString = null;
		 setLayout(new GridLayout(1,1));
		 title = getParameter("title");
		 if(title == null)
			 title = "URLButton";
		 
		 urlString = getParameter("url");
		 if(urlString == null)
			 urlString = "http://";
		 
		 try {
			 url = new URL(urlString);	 
		 }catch(MalformedURLException e) {
			 System.out.println("Invalid URL : " + urlString);
		 }
		 
		 Button site = new Button(title);
		 add(site);
		 resize(100, 60);
	 }	
	
	 public boolean action(Event e, Object arg) {
		 if((e.target instanceof Button) && (arg.equals(title))) {
			 getAppletContext().showDocument(url);
		 }
		 
		 return false;
	 }

}

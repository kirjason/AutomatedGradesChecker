package web;

import java.io.InputStream;

/**
 * An interface for connecting to the grades online
 * 
 * @author Jarred
 * @version 2/9/2017
 * @since 2/6/2017
 */
public interface WebConnectionManager {
	/**
	 * @return The <code>InputStream</code> object associated with the connection to the page showing all of the grades.
	 */
	InputStream getMainGradesPage();
	

	/**
	 * Builds all of the appropriate Class objects for the user's schedule
	 */
	void fillInGrades();
	
	/**
	 * 
	 * @author Jarred
	 * @version 2/6/2017
	 * @since 2/6/2017
	 */
	public static final class Builder {
		private String webResourceName;
		
		/**
		 * Creates a builder that builds a WebConnectionManager that accesses the Aeries site run by FJUHSD
		 */
		public Builder() {
			this("FJUHSD_Aeries");
		}
		
		/**
		 * Creates a builder that builds a WebConnectionManager that accesses the Aeries site run by FJUHSD
		 * 
		 * @param webResourceName The name of the site. Valid names include the following: <ul><li>FJUHSD_Aeries</li></ul>
		 */
		public Builder(String webResourceName) {
			this.webResourceName=webResourceName;
		}
		
		/**
		 * Builds a complete WebConnectionManager using the arguments already passed into it
		 * 
		 * @return A complete WebConnectionManager
		 * @throws IllegalStateException if the resource name is incorrect
		 */
		public WebConnectionManager build() {
			switch(webResourceName) {
			case "FJUHSD_Aeries":
				return new FJUHSDAeriesConnectionManager();
				
			default:
				throw new IllegalStateException(); //this is only run if it is given an invalid webResourceName
			}
		}
	}
}

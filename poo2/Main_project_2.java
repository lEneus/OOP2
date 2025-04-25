package prr;

import javax.swing.UIManager;

public class Main_project_2 {

	public static void main(String[] args) {
		
		try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Modern theme
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
		
		  window_user_admin w=new window_user_admin();	}
	
}


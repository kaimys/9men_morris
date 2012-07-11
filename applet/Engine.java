import java.awt.Graphics;
import java.awt.Font;
import java.applet.Applet;
import netscape.javascript.JSObject; 
import netscape.javascript.JSException; 

public class Engine extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	Font f;
	String version = "Nine Men Morris Engine 1.0";

	public void init() {
		System.out.println("init");
		f = new Font("Helvetica", Font.BOLD, 16);
	}
	
	public void start() {
		System.out.println("start");
        try {
        	String jsCallbackName = getParameter("applet_ready_callback");
            JSObject window = JSObject.getWindow(this);
            window.eval(jsCallbackName + "()");
        } catch(JSException ex) {
        	ex.printStackTrace();
        }
	}

	public void paint ( Graphics g ) {
        System.out.println("paint");
    	g.setFont(f);
        g.drawString ( version, 20, 20);
    }
    
    public void stop() {
    	System.out.println("stop");
    }
    
    public void destroy() {
    	System.out.println("destroy");
    }
    
    public String echo(String str) {
    	version = str;
    	repaint();
    	return "Echo: " + str;
    }
}

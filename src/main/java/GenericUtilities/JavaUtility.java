package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class consists of java Specific generic methods
 * @author hp
 *
 */
public class JavaUtility 
{
	/**
	 * This method will generate system Date in required format
	 * @return
	 */
    public String getDate()
    {
    	Date d=new Date();
    	SimpleDateFormat f=new SimpleDateFormat("dd-MM-yy hh-mm-ss");
    	String date = f.format(d);
    	return date;
    }
}

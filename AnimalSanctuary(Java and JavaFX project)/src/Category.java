
/**
 * Write a description of class Category here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Date;
public abstract class Category
{
    private Date date;
    private Person contact;
    
    public Category(Date d)
    {
        setDate(d);
    }
    
    public Category(Date d, Person c)
    {
    	this(d);
    }
    
    public void setDate(Date d)
    {
        d=date;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public void setContact(Person c)
    {
        c=contact;
    }
    
    public Person getContact()
    {
        return contact;
    }
}

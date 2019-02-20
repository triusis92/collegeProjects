
/**
 * Write a description of class Found here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Date;
public class Found extends Category
{
   private String location;
   private Person owner;
   public Found(Date d, String l, Person p)
   {
       super(d,p);
       setLocation(l);
       
   }
   
   public Date getDate(Date date)
   {
       return date;
   }
   
   public void setLocation(String l)
   {
       location=l;
   }
   
   public String getLocation()
   {
       return location;
   }
   
   public void setOwner(Person o)
   {
       o=owner;
   }
   
   public Person getOwner()
   {
       return owner;
   }
}

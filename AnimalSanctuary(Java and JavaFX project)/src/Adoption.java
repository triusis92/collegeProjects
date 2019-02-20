
/**
 * Write a description of class Adoption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

import java.util.Date;
public class Adoption extends Category
{
    private boolean neutered;
    private boolean chipped;
    private boolean vaccinated;
    private String status;
    private boolean reserved;
    //private personList interested;
    private ArrayList<Person> interested;
    private Date adoptionDate;
    
    public Adoption(Date d)
    {
    	super(d);
        interested = new ArrayList<Person>();
    }
    
    public void setNeutered(boolean n)
    {
        n=neutered;
    }
    
    public boolean getNeutered()
    {
        return neutered;
    }
    
    public void setChipped(boolean c)
    {
        c=chipped;
    }
    
    public boolean getChipped()
    {
        return chipped;
    }
    
    public void setVaccinated(boolean v)
    {
        v=vaccinated;
    }
    
    public boolean getVaccinated()
    {
        return vaccinated;
    }
    
    public void setReserved(boolean r)
    {
        r=reserved;
    }
    
    public boolean getReserved()
    {
        return reserved;
    }
    
    public void setStatus(String s)
    {
        s=status;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setInterested(Person p)
    {
        interested.add(p);
    }
    
    public ArrayList<Person> getInterested()
    {
        return interested;
    }
    
    public Date getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(Date adoptionDate) {
		this.adoptionDate = adoptionDate;
	}
    
    public void print()
    {
    	
    }

	
}

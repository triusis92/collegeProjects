
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String address;
    private String phone;
    private String email;
    private int animalID;
    
    public Person()
    {
    	
    }
    
    public Person(String n,String a,String p,String e)
    {
        setName(n);
        setAddress(a);
        setPhone(p);
        setEmail(e);
    }
    
    public void setName(String n)
    {
        name=n;
    }
    
     public void setAddress(String a)
    {
        address=a;
    }
    
     public void setPhone(String p)
    {
        phone=p;
    }
    
     public void setEmail(String e)
    {
        email=e;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}
    
    public String toString()
    {
        return "Name: "+getName()+" Address: "+getAddress()+" Phone: "+getPhone()+" E-mail: "+getEmail();
    }
    
    public void print()
    {
        System.out.println(toString());
    }

	
}

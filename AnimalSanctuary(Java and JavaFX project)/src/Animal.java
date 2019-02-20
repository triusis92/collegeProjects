
/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javafx.scene.image.Image;
public class Animal
{
    private int age;
    private String aType;
    private boolean gender;
    private String description;
    private String name;
    private String breed;
    private static int animalCount=1;
    private int ID;
    private Category animalCat;
    private Image jpeg;
    
    public Animal() {
		
	}
    public Animal(String t, boolean g, String b, String d)
    {
        ID=animalCount;
        animalCount++;
        setType(t);
        setGender(g);
        setBreed(b);
        setDescription(d);
        
    }

    public Animal(int a, String t, boolean g, String b, String d)
    {
        this(t,g,b,d);
        setAge(a);
    }

    public Animal(int a, String b, boolean g, String n, String d, String t)
    { 
        this(a,t,g,b,d);
        setName(n);
    }

	public void setAge(int a)
    {
        age=a;
    }

    public void setType(String t)
    {
        aType=t;
    }

    public int getAge()
    {
        return age;
    }

    public void setBreed(String b)
    {
        breed=b;
    }

    public void setDescription(String d)
    {
        description=d;
    }

    public String getBreed()
    {
        return breed;
    }

    public void setGender(boolean g)
    {
       gender=g;;
    }

    public boolean getGender()
    {
        return gender;
    }

    public void setName(String n)
    {
       name=n;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getAType()
    {
        return aType;
    }

    public int getNumber()
    {
        return ID;
    }

    public void setCategory(Category l)
    {
    	animalCat=l;
    }

    public Category getCategory()
    {
        return animalCat;
    }
    
    public void setPicture(Image i)
    {
    	jpeg=i;
    }

    public Image getImage()
    {
        return jpeg;
    }

    public String toString()
    {
        return "Animal name: "+getName()+"\n Animal Type: "+getAType()+"\n Animal Age:"+getAge()+"\n Gender: "+getGender()+"\n Breed: "+getBreed()+"\n Description:"+getDescription()+"\n Animal ID: "+getNumber()+"\n Category: "+getCategory()+"\n";
    }

    public void print()
    {
        System.out.println(toString());
    }
}

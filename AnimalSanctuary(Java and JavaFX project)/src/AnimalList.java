
/**
 * Write a description of class AnimalList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Date;
public class AnimalList
{
    ArrayList<Animal> list = new ArrayList<Animal>();
    public AnimalList()
    {
        list = new ArrayList<Animal>();
    }

    public boolean add(Animal a)
    {
        return (list.add(a));
    }

    public void remove(Animal a)
    {
        if(list.isEmpty())
        {
            System.out.println("No animals found in the directory");
        }
        else
        {

            list.remove(a);
        }
    }
    //rturns an animal with specific ID
    public Animal searchAnimal(int ID)
    {
        int place=0;
        for(int i=0; i<list.size(); i++)//for loop to go through every object
        {
            if(list.get(i).getNumber()==ID) 
            {
                place=i;//assign the object found to place variable
            }

        }
        return list.get(place);
    }
    //returns a list of animals in Lost category
    public ArrayList<Animal> getLostList()
    {
		ArrayList<Animal> lostAnimals = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getCategory() instanceof Lost)
			{
				lostAnimals.add(list.get(i));
			}
		}
    	
    	return lostAnimals;
       
    }
    //returns a list of animals in found category
    public ArrayList<Animal> getFoundList()
    {
		ArrayList<Animal> foundAnimals = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getCategory() instanceof Found)
			{
				foundAnimals.add(list.get(i));
			}
		}
    	
    	return foundAnimals;
       
    }
    //returns a list of animals in adoption category
    public ArrayList<Animal> getAdoptionList()
    {
    	ArrayList<Animal> adoptionAnimals = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getCategory() instanceof Adoption)
			{
				adoptionAnimals.add(list.get(i));
			}
		}
    	
    	return adoptionAnimals;
       
    }
    //returns a list of animals of a certain type lost in certain location
    public ArrayList<Animal> getLostReport1(String type, String location)
    {
    	ArrayList<Animal> lostInCertainLocation = new ArrayList<>();
		
		for(int i=0; i<getLostList().size(); i++)
		{
			if(getLostList().get(i).getAType()==type && (((Lost)getLostList().get(i).getCategory()).getLocation()==location))
			{
				lostInCertainLocation.add(getLostList().get(i));
			}
		}
    	
    	return lostInCertainLocation;
       
    }
    //returns a list of cats lost in a certain location on a certain date
    public ArrayList<Animal> getLostReport2(String type, String location, Date date)
    {
    	ArrayList<Animal> lostInCertainLocationAndDate = new ArrayList<>();
		
		for(int i=0; i<getLostList().size(); i++)
		{
			if(getLostList().get(i).getAType()=="Cat" && (((Lost) getLostList().get(i).getCategory()).getLocation()==location) && (((Lost) getLostList().get(i).getCategory()).getDate()==date))
			{
				lostInCertainLocationAndDate.add(getLostList().get(i));
			}
		}
    	
    	return lostInCertainLocationAndDate;
       
    }
    //returns a list of animals of a certain type found in a certain location
    public ArrayList<Animal> getFoundReport1(String type, String location)
    {
    	ArrayList<Animal> foundInCertainLocation = new ArrayList<>();
		
		for(int i=0; i<getFoundList().size(); i++)
		{
			if(getFoundList().get(i).getAType()==type && ((Found) getFoundList().get(i).getCategory()).getLocation()==location)
			{
				foundInCertainLocation.add(getFoundList().get(i));
			}
		}
    	
    	return foundInCertainLocation;
       
    }
    //returns a list of male or female animals found between certain dates
    public ArrayList<Animal> getFoundReport2(boolean gender,Date startDate, Date endDate)
    {
    	ArrayList<Animal> foundByGenderAndDates = new ArrayList<>();
    	
		
		for(int i=0; i<getFoundList().size(); i++)
		{
			Date start=(((Found) getFoundList().get(i).getCategory()).getDate());
			Date end=(((Found) getFoundList().get(i).getCategory()).getDate());
			
			if(getFoundList().get(i).getGender()==gender && (start.before(endDate)&& end.after(startDate)))
			{
				foundByGenderAndDates.add(getFoundList().get(i));
			}
		}
    	
    	return foundByGenderAndDates;
       
    }
    //returns a list of animals of a certain type found in a certain location between certain dates
    public ArrayList<Animal> getFoundReport3(String type, String location, Date startDate, Date endDate)
    {
    	ArrayList<Animal> foundInCertainLocationAndDates = new ArrayList<>();
    	
		
		for(int i=0; i<getFoundList().size(); i++)
		{
			Date start=(((Found) getFoundList().get(i).getCategory()).getDate());
			Date end=(((Found) getFoundList().get(i).getCategory()).getDate());
			
			if(getFoundList().get(i).getAType()==type && ((Found) getFoundList().get(i).getCategory()).getLocation()==location &&(start.before(endDate)&& end.after(startDate)))
			{
				foundInCertainLocationAndDates.add(getFoundList().get(i));
			}
		}
    	
    	return foundInCertainLocationAndDates;
       
    }
    //returns a list of animals wirh certain name ready for adoption
    public ArrayList<Animal> getAdoptionReport1(String status, String name)
    {
    	ArrayList<Animal> readyList = new ArrayList<>();
		
		for(int i=0; i<getAdoptionList().size(); i++)
		{
			if(getAdoptionList().get(i).getName()==name && ((Adoption) getAdoptionList().get(i).getCategory()).getStatus()=="Ready")
			{
				readyList.add(getAdoptionList().get(i));
			}
		}
    	
    	return readyList;
       
    }
    //returns a list of either cats or dogs that are ready for adoption
    public ArrayList<Animal> getAdoptionReport2(String type,String status)
    {
    	ArrayList<Animal> readyListCatsOrDogs = new ArrayList<>();
		
		for(int i=0; i<getAdoptionList().size(); i++)
		{
			if((getAdoptionList().get(i).getAType()=="Cat" || getAdoptionList().get(i).getAType()=="Dog") && ((Adoption) getAdoptionList().get(i).getCategory()).getStatus()=="Ready")
			{
				readyListCatsOrDogs.add(getAdoptionList().get(i));
			}
		}
    	
    	return readyListCatsOrDogs;
       
    }
    //returns a list of dogs/puppies that are in training
    public ArrayList<Animal> getAdoptionReport3(String type,String status)
    {
    	ArrayList<Animal> readyListDogs = new ArrayList<>();
		
		for(int i=0; i<getAdoptionList().size(); i++)
		{
			if(getAdoptionList().get(i).getAType()=="Dog" && ((Adoption) getAdoptionList().get(i).getCategory()).getStatus()=="In Training")
			{
				readyListDogs.add(getAdoptionList().get(i));
			}
		}
    	
    	return readyListDogs;
       
    }
    //returns a list of cats or dogs in the system organised by age
    public ArrayList<Animal> getGeneralReport1(int age)
    {
		ArrayList<Animal> allCatsAndDogs = new ArrayList<>();
	
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getCategory() instanceof Lost && list.get(i).getCategory() instanceof Found && list.get(i).getCategory() instanceof Adoption)
			{
				if((list.get(i).getAType()=="Cat" || list.get(i).getAType()=="Dog") && list.get(i).getAge()==age)
				{
					allCatsAndDogs.add(getAdoptionList().get(i));
				}
			}
		}
    	
    	return allCatsAndDogs;
       
    }
    
    public void printList()
    {
       //for(int i=0; i<list.size(); i++)
        //{
            System.out.println("\n"+list);
       // }
    }
}

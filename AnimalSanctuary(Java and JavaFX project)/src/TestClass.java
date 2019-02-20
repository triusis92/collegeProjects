
/**
 * Write a description of class TestClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Date;
public class TestClass
{
   public static void main(String[] args)
   {
       AnimalList a=new AnimalList();
       a.add(new Animal("Dog",true,"yorkie","black"));
     
      //a.add(b);
       a.add(new Animal(10,"Dog",true,"yorkie","black"));
       a.add(new Animal(10,"rotweiler",true,"Lance","black","dog"));
       a.printList();
     //  System.out.print(a.searchAnimal(1).getName());
       a.remove(a.searchAnimal(2));
       a.printList();
       //a.add(new Animal("Dog",true,"yorkie","beeach"));
       a.searchAnimal(1).setCategory(new Lost(new Date(04/03/2016), "Cork", new Person("Lance", "Limerick", "0851133035", "lancetriusis@yahoo.ie")));
       a.printList();
   }
}

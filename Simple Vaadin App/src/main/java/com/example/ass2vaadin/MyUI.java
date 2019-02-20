package com.example.ass2vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javafx.scene.control.RadioButton;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();//layout container

        Label title = new Label("Simple Calculator");//title
         //text fields for entering information
        final TextField name = new TextField();
        name.setCaption("Type your name here:");
        final  TextField number1= new TextField();
        number1.setCaption("Enter first whole number:");
        final  TextField number2= new TextField();
        number2.setCaption("Enter second whole  number:");
        //Radio buttons        
        RadioButtonGroup<String> single = new RadioButtonGroup<>("Choose Operation");
        single.setItems("Add", "Multiply");                 
        //calculate button and listener
        Button button = new Button("Calculate");
        button.addClickListener( e -> {
        	int result=0;
        	
        	if(single.getValue().toString().equals("Add"))//check which radio button was selected
        	{
        		//compute trhe rseult of addition of two numbers
        		result = Integer.parseInt(number1.getValue()) + Integer.parseInt(number2.getValue());
        	}
        	if(single.getValue().toString().equals("Multiply"))
        	{
        		//compute result of multiplication of two entered numbers
        		result = Integer.parseInt(number1.getValue()) * Integer.parseInt(number2.getValue());
        	}
        	layout.removeAllComponents();//clear all elements
        	//display result
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", Your calculated result is: "+result+"\n.Refresh the page to do another calculation"));
        });
     
        layout.addComponents(title, name, number1, number2, single, button);//add the UI components to container
        
        setContent(layout);//display layout
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


public class MainController
{


    private void sprawdz(double pom)
    {
        if((int)pom==pom)
        {
            output.setText(String.valueOf((int)pom));
            operator="";
            output2.setText(String.valueOf(operator));
            start=true;
        }
        else
        {
            output.setText(String.valueOf(pom));
            operator="";
            output2.setText(String.valueOf(operator));
            start=true;
        }
    }

    @FXML
    private Text output;
    @FXML
    private Text output2;
    private String operator="";
    private double numer1=0;
    private double numer3=0;
    private double pom;
    private  boolean start=true;

    private Model model=new Model();
    @FXML
    public void processNumbers(ActionEvent event)
    {
        if(start)
        {
            output.setText("");
            start=false;
        }
        String value=((Button)event.getSource()).getText();
        String test=output.getText();
        if(test.length()>11)
            return;
        output.setText(output.getText()+value);

    }

    @FXML
    public void processNumbersKlawiatura(KeyEvent event)
    {
        if(start)
        {
            output.setText("");
            start=false;
        }
        String value=String.valueOf(event.getText());
        if(value.equals(","))
            value=".";
        String test=output.getText();
        System.out.println(value);
        if(test.length()>11)
            return;
        output.setText(output.getText()+value);

    }
    @FXML
    public void checkKeyEvent(KeyEvent event)
    {
        if(event.getCode().isDigitKey() || (event.getCode().getName()).equals("Decimal"))
        {
            processNumbersKlawiatura(event);
        }

        else if((event.getCode().getName()).equals("Add"))
        {

            if(!operator.isEmpty())
                return;


            operator="+";
            output2.setText(String.valueOf(operator));
            numer1=Float.parseFloat(output.getText());
            output.setText("");
        }
        else if((event.getCode().getName()).equals("Subtract"))
        {

            if(!operator.isEmpty())
                return;


            operator="-";
            output2.setText(String.valueOf(operator));
            numer1=Float.parseFloat(output.getText());
            output.setText("");
        }
        else if((event.getCode().getName()).equals("Multiply"))
        {

            if(!operator.isEmpty())
                return;


            operator="*";
            output2.setText(String.valueOf(operator));
            numer1=Float.parseFloat(output.getText());
            output.setText("");
        }
        else if((event.getCode().getName()).equals("Divide"))
        {

            if(!operator.isEmpty())
                return;


            operator="/";
            output2.setText(String.valueOf(operator));
            numer1=Float.parseFloat(output.getText());
            output.setText("");
        }
        else if((event.getCode().getName()).equals("Enter"))

        {
            if(operator.isEmpty())
                return;

            pom=model.calculate(numer1,Float.parseFloat(output.getText()),operator);
            sprawdz(pom);
        }
    }
    @FXML
    public  void processOperators(ActionEvent event)
    {
        String value=((Button)event.getSource()).getText();
        if("MR".equals(value))
        {

            sprawdz(numer3);
        }
        else if("MR+".equals(value))
        {

            numer1=Float.parseFloat(output.getText());
            numer3+=numer1;
        }
        else if("MR-".equals(value))
        {

            numer1=Float.parseFloat(output.getText());
            numer3-=numer1;
        }
        else if("CMR".equals(value))
        {

            numer3=0;
        }
        else if("CL".equals(value))
        {
            numer1=0;
            operator="";
            start=true;
            output.setText("");
        }
        else if("√".equals(value))
        {

            operator="√";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
        }
        else if("x²".equals(value))
        {
            operator="x²";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
        }
        else if("±".equals(value))
        {
            operator="±";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
        }
        else if("BIN".equals(value))
        {

            operator="BIN";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
        }
        else if("DEC".equals(value))
        {

            operator="DEC";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
        }
        else if("⌫".equals(value))
        {
            operator="⌫";
            pom=model.calculate2(operator,Float.parseFloat(output.getText()));
            sprawdz(pom);
            numer1=Float.parseFloat(output.getText());
        }
        else if(!"=".equals(value))
        {
            if(!operator.isEmpty())
                return;

            operator=value;
            output2.setText(String.valueOf(operator));
            numer1=Float.parseFloat(output.getText());
            output.setText("");
        }
        else
        {
            if(operator.isEmpty())
                return;

            pom=model.calculate(numer1,Float.parseFloat(output.getText()),operator);
            sprawdz(pom);

        }
    }
}

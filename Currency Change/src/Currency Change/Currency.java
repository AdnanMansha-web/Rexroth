package any;
import java.util.ArrayList;
import java.util.Scanner;


public class Currency {

	private int[] Currency_Unit = {500, 200, 100, 50, 20, 10,5,2,1};
    private int[] Currency_Units_For_Cents = {50, 20, 10,5,2,1};
    private  ArrayList<Integer> Euros_list = new ArrayList<Integer>();
    private  ArrayList<Integer> Cents_list = new ArrayList<Integer>();
    
    // function to change the currency in euro
    public int Euros_Part(int euros)
    {
        for(int i =0; i < Currency_Unit.length; i++)
        {
           if(Currency_Unit[i] <= euros)
            {
                int Remainder = euros % Currency_Unit[i];
                if(Remainder  == 0)
                {
                    int divider = euros / Currency_Unit[i];
                    for(int j =0; j < divider; j++)
                    {
                        Euros_list.add(Currency_Unit[i]);

                    }
                     return 0;
                }
                else
                {
                    Euros_Part(euros-Remainder);
                    return Remainder;
                }
            }

        }
        return 0;
    }

    // function to change the currency in euro
    public int Cents_Part(int cents)
    {

        for(int i =0; i < Currency_Units_For_Cents.length; i++)
        {
            if(Currency_Units_For_Cents[i] <= cents)
            {
                int Remainder = cents % Currency_Units_For_Cents[i];
                if(Remainder  == 0)
                {
                    int divider = cents / Currency_Units_For_Cents[i];
                    for(int j =0; j < divider; j++)
                    {
                        Cents_list.add(Currency_Units_For_Cents[i]);
                    }

                    return 0;
                }
                else
                {
                    Cents_Part(cents-Remainder);
                    return Remainder;
                }
            }

        }
        return 0;
    }


    public static void main(String[] args)
    {
    	// Input value from user
    	// Create a Scanner object
    	Scanner sc = new Scanner(System.in);  
        System.out.println("Enter Value for change");
        double input=sc.nextDouble();
        String number = Double.toString(input);

        // split the Euros and Cents
        String[] data = number.split("\\.");

        int euros =  Integer.parseInt(data[0]);
        int cents = Integer.parseInt(data[1]);

        Currency obj1 = new Currency();

        while (euros > 0)
           {
               euros = obj1.Euros_Part(euros);
           }

        while (cents > 0)
        {
            cents = obj1.Cents_Part(cents);
        }

        System.out.println("Change in cash");
        System.out.println(obj1.Euros_list);
        System.out.println("Change in coin");
        System.out.println(obj1.Cents_list);
    }
}

	
	
	


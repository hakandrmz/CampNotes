package com.company;

import java.util.ArrayList;
import java.util.Arrays;

class MyException extends Exception
{
    public MyException(String s)
    {
        super(s);
    }
}
class MySecondException extends Exception
{
    public MySecondException(String s)
    {
        super(s);
    }
}

// A Class that uses above MyException
public class Main
{
    // Driver Program
    public static void main(String args[])
    {
        boolean temp = false;
        try
        {
            if (temp) {
                throw new MyException("MyException");
            }else {
                throw new MySecondException("MySecondException");
            }

        }
        catch (MyException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (MySecondException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("finally");
        }
    }
}
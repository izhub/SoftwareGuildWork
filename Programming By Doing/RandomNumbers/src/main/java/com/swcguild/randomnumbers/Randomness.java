/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.randomnumbers;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class Randomness {
    public static void main ( String[] args )
	{
//To pick a random number, you must create a random-number generator object, like so:
		Random r = new Random();
                
// you can have the computer pick a random integer like this:
//That'll pick a random number from 1 to 10 (inclusive) and store it into the variable x
		int x = 1 + r.nextInt(10);

		System.out.println( "My random number is " + x );

		System.out.println( "Here are some numbers from 1 to 5!" );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.println();

		System.out.println( "Here are some numbers from 1 to 100!" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.println();

		int num1 = 1 + r.nextInt(10);
		int num2 = 1 + r.nextInt(10);

		if ( num1 == num2 )
		{
			System.out.println( "The random numbers were the same! Weird." );
		}
		if ( num1 != num2 )
		{
			System.out.println( "The random numbers were different! Not too surprising, actually." );
		}
	}
}
/* What You Should Do on Your Own

    Delete the 1 + in front of all six lines that pick numbers 1-5, so that they look like this: System.out.print( r.nextInt(5) + " " ); Run the program a few times, and see if you can figure out what range the new random numbers are in.
    Change the 1 + in front of all six lines that pick numbers 1-5, so that they look like this: System.out.print( 3 + r.nextInt(5) + " " ); Run the program a few times. Is it picking random numbers from 3 to 5? If not, what range are they?
    Change the line where you create the random number generator so that it looks like this: Random r = new Random(12353); This number is called a seed. Run the program a few times. What do you notice? What happened to the random numbers?
    Change to random seed to something else and observe the behavior. What happens to the random numbers?
  
*/
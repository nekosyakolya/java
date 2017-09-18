package net.volgatech.javacore2017;
import java.util.regex.Pattern;
import java.util.Random;

public class PasswordGenerator {

	public static void main(String[] args) {

		try {
			if (args.length != 2)
			{
				throw new Exception("incorrect number of arguments");
			}


			if(!args[0].matches("[0-9]+"))
				{
					throw new Exception("incorrect value");
				}

			Integer size = Integer.parseInt(args[0]);
			String alphabet = args[1];
			Random random = new Random();

			String result = "";


			Integer bound = alphabet.length();

			for (Integer i = 0; i < size ; ++i) {
				result += alphabet.charAt(random.nextInt(bound));
			}
			System.out.println(result);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}
package net.volgatech.javacore2017;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

public class GetNetAddress {

	private static ArrayList<Integer> m_first;
	private static ArrayList<Integer> m_second;
	private static ArrayList<Integer> getValues(String value) throws Exception	{
			Pattern pattern = Pattern.compile("[.]");
			String[] first = pattern.split(value);
			ArrayList<Integer> ipNumbers = new ArrayList<>();
			for (String el : first)
			{

				if(!el.matches("[0-9]+"))
				{
					throw new Exception("incorrect value");
				}

				ipNumbers.add(Integer.parseInt(el));


			}

			if (ipNumbers.size() != 4)
			{
				throw new Exception("incorrect value!!!");
			}


		return ipNumbers;

	}

	public static void getResult() {
		String result = "";
		for (Integer i = 0; i < m_first.size(); ++i) {
			Integer value = m_first.get(i) & m_second.get(i);
			result += Integer.toString(value) + ".";		
		}
		result = result.substring(0, result.length() - 1);
		System.out.println(result);
	}
	
	public static void main(String[] args) {

		try {
			if (args.length != 2)
			{
				throw new Exception("incorrect number of arguments");
			}

			m_first = getValues(args[0]);
			m_second = getValues(args[1]);
			getResult();


		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}
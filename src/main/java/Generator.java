import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fileWriter = null;		
		try
		{
			fileWriter = new FileWriter("data.txt");			
			int upper = 1000000;
			int upperLenght = String.valueOf(upper).length();

			for (int i = 1; i <= upper; i++)
			{
				int lenghtOfI = String.valueOf(i).length();
				int numberOfSpaces = upperLenght - lenghtOfI;
				String id = "";
				for (int y = 0; y < numberOfSpaces; y++)
				{
					id = id + " ";
				}
				id = id + i;
				String state = RandomStringUtils.random(10,"abcdefghijklmnopqrstuvwxyz");
				String capital = RandomStringUtils.random(10,"abcdefghijklmnopqrstuvwxyz!@#$%^&*");
				String line = id + state + capital;
				fileWriter.write(line+"\n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			fileWriter.close();			
		}
	}
}

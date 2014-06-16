package table;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

	public String readFileContent( String fileName )
	{
		StringBuilder stringBuilder = new StringBuilder();

		try( BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName)) )
		{
			String line;
			while ( (line = reader.readLine()) != null )
				stringBuilder.append(line).append("\n");
		}
		catch(IOException e) {
			System.out.println(e);
		}

		return stringBuilder.toString();
	}

}

package Fing_GUI;

import java.io.*;



public class FileOutput {
  public static void makeBatch(String fingCommand) {

		try {

			String changeDirectoryToFingCommand = "cd c:\\Program Files (x86)\\overlook fing 2.1\\bin";
			String fingCommandLine = fingCommand;

			File file = new File("c:\\fingtest.bat");

			if (!file.exists()) {
				file.createNewFile();
			}

			File invisibleVBS = new File("c:\\invisible.vbs");

			if (!invisibleVBS.exists()) {
				invisibleVBS.createNewFile();
			}
			FileWriter _vbsFw = new FileWriter(invisibleVBS.getAbsoluteFile());
			BufferedWriter _vbsBw = new BufferedWriter(_vbsFw);
			_vbsBw.write("Set WshShell = CreateObject(\"WScript.Shell\")");
			
			_vbsBw.newLine();
			_vbsBw.write("WshShell.Run chr(34) & \"c:\\fingtest.bat\" & Chr(34), 0");
			_vbsBw.newLine();
			_vbsBw.write("Set WshShell = Nothing");
			_vbsBw.close();
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(changeDirectoryToFingCommand);
			bw.newLine();
			bw.write(fingCommandLine);
			bw.newLine();
			bw.write("cd c:\\");
			bw.newLine();
			bw.write("del invisible.vbs && DEL \"%~f0\"");
			
			bw.close();

			Runtime.getRuntime().exec("cmd /c start c:\\invisible.vbs");
		
			
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

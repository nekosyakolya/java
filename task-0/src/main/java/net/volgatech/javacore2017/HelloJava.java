package net.volgatech.javacore2017;
import java.io.File;

public class HelloJava {
	private static void printMessage(){
		System.out.println("Hello, JAVA");
	}

	private static void printOsName(){
		System.out.println("Operating system name: " + System.getProperty("os.name"));
	}

	private static void printOsVersion(){
		System.out.println("Operating system version: " + System.getProperty("os.version"));
	}

	private static void printInfoOs(){
		printOsName();
		printOsVersion();
	}

	private static void printJavaHome(){
		System.out.println("Java path: " + System.getProperty("java.home"));
	}

	private static void printJavaVersion(){
		System.out.println("Java version: " + System.getProperty("java.version"));
	}

	private static void printInfoJava(){
		printJavaHome();
		printJavaVersion();
	}

	private static void printCurrentPath(){
		System.out.println(new File("").getAbsolutePath());
	}

	private static void printArgs(String[] args){
		System.out.print("Java from ");
		for (String arg : args) {
			System.out.print(arg + " ");			
		}
	}

	public static void main(String[] args){

		printMessage();
		printInfoOs();
		printInfoJava();
		printCurrentPath();
		printArgs(args);

	}
}
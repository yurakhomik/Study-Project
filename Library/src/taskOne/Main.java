package taskOne;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String s = sc.nextLine();

			char[] c = s.toCharArray();
			String bookname = "";
			String bookauthor = "";
			int k = s.indexOf("\"");

			if (s.contains("all"))
				BookStore.printBooks();
			else if (s.contains("add")) {
				for (int i = k + 1; i < c.length - 1; ++i) {
					bookname += String.valueOf(c[i]);
				}
				for (int i = 9; i < k - 1; ++i) {
					bookauthor += c[i];
				}
				BookStore.addBook(bookauthor, bookname);
			} else if (s.contains("remove")) {
				if (s.contains("\"")) {
					for (int i = k + 1; i < c.length - 1; ++i) {
						bookname += c[i];
					}
				} else {
					for (int i = 7; i < c.length; ++i) {
						bookname += c[i];
					}
				}
				BookStore.removeBook(bookname);
			} else if (s.contains("edit")) {
				if (k != -1) {
					for (int i = k + 1; i < c.length - 1; ++i) {
						bookname += c[i];
					}
				} else {
					for (int i = 10; i < c.length; ++i) {
						bookname += c[i];
					}
				}
				System.out.println("enter a new name books");
				String newName = sc.nextLine();
				
				if (newName.startsWith("\"")) {
					char[] ch = newName.toCharArray();
					newName = "";
					for (int i = 1; i < ch.length-1; ++i)
						newName += ch[i];
				}
				BookStore.editBook(bookname, newName);

				
			}  else
				System.out.println("incorrect input");
				
			
			
				
	

		}
		
	}
	
}

/*
//String[] w = s.split(pattern);
//char[] c = s.toCharArray();
String p = "";
for (int i = 0; i < 3; ++i) {
	 p += String.valueOf(c[i]);
	//System.out.print(p);
}System.out.print(p);

if(w[0].equals("all")) {
	BookStore.printBooks();
}	

else if (w[0].equals("add")) {
		if(w.length == 5)
		BookStore.addBook(w[2], w[w.length-2] + " " + w[w.length-1]);
	else
		BookStore.addBook(w[2], w[w.length - 1]);
}
else if (w[0].equals("remove")) {
	
}
	if(w[0].equals("add")) {
		String bookname;
		String bookauthor;
		for (int i = 1; i < w.length; ++i) {
			if(w[i].startsWith("\"") && w[i].endsWith("\"")) {
				bookname = w[i];
				bookauthor = w[i-1];
			}
			else {
				bookauthor = w[1];
				//int k = Arrays.in
			}*/

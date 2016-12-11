package taskOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/library";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args) {
		// printBooks();
		// addBook("KKkk", "KKKkkk");
		// addBook("KKkk", "k");
		// printBooks();
		// removeBook("Java");
		// printBooks();
		// editBook("k", "gdsfgdsgdsgdshgdf");
		printBooks();
		// addBook("J. Rowling", "Harry Potter");
		// addBook("Unkdown", "Harry Potter");
		// addBook("Harry", "Germiona");
		// addBook("A", "Harry Potter");
		// addBook("B", "Harry Potter");
		// addBook("C", "Harry Potter");
		//addBook("A", "a");
		//addBook("B", "a");
		//addBook("A", "a");
		//addBook("", "qqq");
		// printBooks();
		//addBook("Yura","PP");
		//removeBook("Java");
		//printBooks();
		editBook("Philosophy Java","Java");
		printBooks();
		



	}
	
	

	public static void removeBook(String name) {
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			String sql;
			String s;
			int k = 0;
			Scanner sc = new Scanner(System.in);
			int i = 0;
			ArrayList<String> list = new ArrayList<>();
			sql = "SELECT * FROM books WHERE bookname='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				i++;
				list.add(rs.getString("bookauthor"));
				list.add(rs.getString("bookname"));
			}

			if (list.isEmpty()) {
				System.out.println("book not found");
				return; 
			}
			
			
			else if (i > 1) {
				int j = 1, l = 0, p = 1;
				System.out.println("we have few books with such name please choose one by typing a number of book:");
				while (i != 0) {
					//s = "\t" + j++ + ". " + list.get(l) + " '" + list.get(l + 1) + "'";
					System.out.println("\t" + j++ + ". " + list.get(l) + " \"" + list.get(l + 1) + "\"");
					l += 2;
					i--;
				}
				k = sc.nextInt();
				if (k == 1) {
					sql = "DELETE FROM books WHERE bookname ='" + list.get(k) 
					       + "'&& bookauthor ='" + list.get(k-1)+ "'" ;
					System.out.println("book " + list.get(k - 1)  + " \"" + list.get(k) + "\" was removed");
				} else if (k == 2) {
					sql = "DELETE FROM books WHERE bookname ='" + list.get(k+1) 
					       + "'&& bookauthor ='" + list.get(k)+ "'";
					System.out.println("book " + list.get(k)  + " \"" + list.get(k+1) + "\" was removed");
				} else {
					sql = "DELETE FROM books WHERE bookname ='" + list.get(k + (k - 1)) 
					       + "'&& bookauthor ='" + list.get(k+(k-2))+ "'";
					System.out.println("book " + list.get(k + (k-2))  + " \"" + list.get(k + (k-1)) + "\" was removed");
				}
				
			} else {
				sql = "DELETE FROM books WHERE bookname ='" + list.get(1) 
				       + "' && bookauthor ='" + list.get(0)+ "'" ;
				System.out.println( "book " + list.get(0) + " \"" + list.get(1) + "\" was removed");

			}
			stmt.executeUpdate(sql);

			

			// String author = list.get(k);
			// System.out.println(author);
			// sql = "DELETE FROM books WHERE bookautor ='" + list.get(k+1) +
			// "'";
			// System.out.println(list.get(k-1) + " dasdas");



		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void editBook(String name, String newName) {
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			String sql;
			String author = "";
			sql = "SELECT bookauthor FROM books WHERE bookname='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				author = rs.getString("bookauthor");
			}
			System.out.println("book " + author + " \"" + name + "\" change to " 
			                   + author + " \"" + newName + "\"");
			sql = "UPDATE books SET bookname ='" + newName + "'" + "WHERE bookname='" + name + "'";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void addBook(String autor, String name) {
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			String sql;
			System.out.println("book " + autor + " \"" + name + "\" was added");
			sql = "INSERT INTO books" + "(bookauthor, bookname)" + "values ('" + autor + "'," + "'" + name + "')";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void printBooks() {
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM books ORDER BY bookname";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("Our books: ");
			while (rs.next()) {
				int id = rs.getInt("bookid");
				String author = rs.getString("bookauthor");
				String name = rs.getString("bookname");

				System.out.print("\t" + author);
				System.out.println(" \"" + name + "\"");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}
}

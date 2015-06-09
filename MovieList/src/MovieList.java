import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


public class MovieList
{

	public static void main(String[] args)
	{
		// Test comment for GIT
		ArrayList<Movie> relevantMovies = new ArrayList<Movie>();
		TreeMap<Integer, String> numberedCategories;
		String goAgain = "y";
		String movieCategory;
		int movieCategoryNumber = 0;
		
		System.out.println("Welcome to the Movie List Application!\n\n"
				+ "There are 100 movies in the library.");
		
		while (goAgain.equalsIgnoreCase("y"))
		{
			// get the numbered movie categories
			numberedCategories = getSortedMovieCategories();
			
			// Display the movie categories numbered and sorted to enable selection by number
			printSortedMovieCategories(numberedCategories);
			
			// prompt for movie category of interest, by category number, to retrieve
			movieCategoryNumber = Validator.promptForIntegerResponse("What category of movies interest you?  Please enter a number: ");
			
			// explicitly get the movie category for code clarity rather than passing method
			movieCategory = numberedCategories.get(movieCategoryNumber);
			
			// get the filtered list of movies - use the overloaded getMovies(String) to return selections
			relevantMovies = getMovies(movieCategory);
			
			// display the list of movies returned for the category selected
			displayMovies(relevantMovies, numberedCategories.get(movieCategoryNumber));
			
			goAgain = Validator.promptForStringResponse("Continue? (y/n)");
		}
		
		System.out.println("\n\nProgram ended.");

	}
	
	public static ArrayList<Movie> getMovies()
	{
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		for (int i = 1; i <= 100; i++)
		{
			Movie m = MovieIO.getMovie(i);
			movies.add(m);
		}
		
		return movies;
	}
	
	public static ArrayList<Movie> getMovies(String category)
	{
		ArrayList<Movie> filteredMovies = new ArrayList<Movie>();
		
		for (int i = 1; i <= 100; i++)
		{
			Movie m = MovieIO.getMovie(i);
			
			if (m.getCategory().equalsIgnoreCase(category))
			{
				filteredMovies.add(m);
			}
		}
		
		return filteredMovies;
	}
	
	public static TreeMap<Integer, String> getSortedMovieCategories()
	{
		ArrayList<Movie> movieList = getMovies();
		ArrayList<String> categories = new ArrayList<String>();
		TreeMap<Integer, String> sortedCategories = new TreeMap<Integer, String>();
		
		for (Movie m : movieList)
		{
			if(!categories.contains(m.getCategory()))
				categories.add(m.getCategory());
		}
		
		String[] categoryArray = new String[categories.size()];
		int i = 0;
		
		for (String s : categories)
		{
			categoryArray[i] = s;
			i++;
		}
		
		Arrays.sort(categoryArray);
		
		i = 1;
		for (String s : categoryArray)
		{
			sortedCategories.put(i, s);
			i++;
		}
		
		return sortedCategories;
	}
	
	public static void printSortedMovieCategories(TreeMap<Integer, String> sortedCategories)
	{
		System.out.println("Available Movie Categories");
		System.out.println("--------------------------");
		
		for(Map.Entry<Integer, String> entry : sortedCategories.entrySet())
		{
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
		System.out.println();
	}
	
	public static void displayMovies(ArrayList<Movie> moviesToDisplay, String category)
	{
		System.out.println("\n\nMovies in " + category + " category are: ");
		
		for (Movie m : moviesToDisplay)
		{
			m.printMovieTitle();
		}
		
		System.out.println("\n");	// provide some white space between transactions
	}

}

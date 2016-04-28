
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Collections {

	public static void main(String[] args) {
		List l = new LinkedList();
		l.add(12);
		l.add("toto ! !");
		l.add(12.20f);

		for (int i = 0; i < l.size(); i++)
			System.out.println("Élément à l'index " + i + " = " + l.get(i));

		System.out.println("\n \tParcours avec un itérateur ");
		System.out.println("-----------------------------------");
		ListIterator li = l.listIterator();

		while (li.hasNext())
			System.out.println(li.next());
	}

	ArrayList<String> a = new ArrayList<String>();
}
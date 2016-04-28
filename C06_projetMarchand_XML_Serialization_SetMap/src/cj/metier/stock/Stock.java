package cj.metier.stock;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import cj.metier.product.Product;

public class Stock extends TreeMap<String, Product> {

	public Stock() {
		super();
	}

	public Stock(Comparator<? super String> comparator) {
		super(comparator);
	}

	public Stock(Map<? extends String, ? extends Product> m) {
		super(m);
	}

	public Stock(SortedMap<String, ? extends Product> m) {
		super(m);
	}

	@Override
	public String toString() {
		String s = "[";
		Set<Entry<String, Product>> set = this.entrySet();
		for (Entry<String, Product> entry : set) {
			s += entry.getValue().getNom();
		}
		s += "]";
		return s;

	}

}

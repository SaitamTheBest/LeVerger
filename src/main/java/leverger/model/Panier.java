package leverger.model;

import java.util.List;
import java.util.ArrayList;

public class Panier {
	protected List<Fruit> panier;

	public Panier(List<Fruit> panier) {
		this.panier = panier;
	}
	
	public Panier() {
		this(new ArrayList<Fruit>());
	}
	
	public void ajout(Fruit fruit) {
		this.panier.add(fruit);
	}
	
	public int taillePanier() {
		return this.panier.size();
	}
	

}

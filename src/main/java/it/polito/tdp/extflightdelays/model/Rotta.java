package it.polito.tdp.extflightdelays.model;


/**
 * Classe di aiuto per rappresentare un arco, ovverosia
 * una tratta (A->B, B->A) con anche le informazioni di:
 * - distanza totale percorsa da tutti i voli attivi sulla tratta
 * - il numero totale di voli operativi sulla tratta
 * - la distanza media percorsa dai voli sulla tratta
 * Implementa anche un metodo compareTo, semplicemente per ordinare
 * le rotte in ordine alfabetico, per la stampa.
 * @author carlo
 *
 */
public class Rotta implements Comparable<Rotta>{

	
	private Airport a1;
	private Airport a2;
	private int totDistance;
	private int nVoli;
	private double avgDistance;
	
	
	public Rotta(Airport a1, Airport a2, int totDistance, int nVoli) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.totDistance = totDistance;
		this.nVoli = nVoli;
		this.avgDistance = totDistance/nVoli;
	}
	
	
	public Rotta(Airport a1, Airport a2, double avgDistance) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.totDistance = 0;
		this.nVoli = 0;
		this.avgDistance = avgDistance;
	}


	public Airport getA1() {
		return a1;
	}


	public void setA1(Airport a1) {
		this.a1 = a1;
	}


	public Airport getA2() {
		return a2;
	}


	public void setA2(Airport a2) {
		this.a2 = a2;
	}


	public double getAvgDistance() {
		return avgDistance;
	}


	public void setAvgDistance(double avgDistance) {
		this.avgDistance = avgDistance;
	}


	public void setTotDistance(int totDistance) {
		this.totDistance = totDistance;
		this.avgDistance = totDistance/this.nVoli;
	}


	public void setnVoli(int nVoli) {
		this.nVoli = nVoli;
		this.avgDistance = this.totDistance/nVoli;
	}
	
	
	public int getTotDistance() {
		return totDistance;
	}

	public int getnVoli() {
		return nVoli;
	}


	public void increaseNVoli(int nVoli) {
		if (nVoli < 0) {
			throw new IllegalArgumentException("Il numero di voli inserito deve essere non negativo");
		}
		this.nVoli += nVoli;
		this.avgDistance = this.totDistance/this.nVoli;
	}
	
	
	public void increaseTotDistance(int distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("La distanza inserita deve essere non negativa");
		}
		this.totDistance += distance;
		this.avgDistance = this.totDistance/this.nVoli;
	}


	@Override
	public int compareTo(Rotta o) {
		return a1.compareTo(o.a1);
	}
	
	
	
	
	
	
}

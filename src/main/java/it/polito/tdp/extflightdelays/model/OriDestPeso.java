package it.polito.tdp.extflightdelays.model;

public class OriDestPeso {

	private int id_origine;
	private int id_arrivo;
	private int distance;
	
	
	
	
	public OriDestPeso(int id_origine, int id_arrivo, int distance) {
		super();
		this.id_origine = id_origine;
		this.id_arrivo = id_arrivo;
		this.distance = distance;
	}
	public int getId_origine() {
		return id_origine;
	}
	public void setId_origine(int id_origine) {
		this.id_origine = id_origine;
	}
	public int getId_arrivo() {
		return id_arrivo;
	}
	public void setId_arrivo(int id_arrivo) {
		this.id_arrivo = id_arrivo;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
	
}

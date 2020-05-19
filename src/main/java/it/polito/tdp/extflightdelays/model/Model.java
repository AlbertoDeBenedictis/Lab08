package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	Map<Integer, Airport> airportIdMap;
	List<Airport> listaAir;
	Graph<Airport, DefaultWeightedEdge> grafo;

	ExtFlightDelaysDAO dao;
	
	public Model() {

		// creo un'istanza del dao e mi faccio dare la lista degli aeroporti
		dao = new ExtFlightDelaysDAO();
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public void creaGrafo(int distanzaMin) {
		
		// prendo la lista dei vertici
		listaAir = new ArrayList<>(dao.loadAllAirports());

		// creo l'idMap degli aeroporti, così posso riconoscere tutti gli aeroporti dall'id
		airportIdMap = new HashMap<>();
		for (Airport a : listaAir) {

			airportIdMap.put(a.getId(), a);
		}

		// creo il grafo
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// aggiungo i vertici
		Graphs.addAllVertices(this.grafo, listaAir);
		
		// aggiungo gli archi - metodo smart
		List<OriDestPeso> listaCoppie = dao.getCoppie(distanzaMin);
		
		for(OriDestPeso coppia: listaCoppie) {
			
			// creo l'arco (se è ripetuto non lo crea, non fa niente)
			Graphs.addEdge(this.grafo, airportIdMap.get(coppia.getId_origine()), airportIdMap.get(coppia.getId_arrivo()), coppia.getDistance());
		}
		
		System.out.println(String.format("Grafo creato!\n# Vertici %d\n#Archi %d", this.grafo.vertexSet().size(), this.grafo.edgeSet().size()));
	}
	
	

}

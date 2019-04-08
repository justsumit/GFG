package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentation {
	
	public static final String DIRECTED_GRAPH_TYPE="D";
	public static final String UNDIRECTED_GRAPH_TYPE="U";
	
	public static void main(String[] args){
		AdjacenyMatrixGraph amGraph= new AdjacenyMatrixGraph(DIRECTED_GRAPH_TYPE, 5);
		amGraph.init();
		
		System.out.println("-------------------------------------");
		
		AdjacenyListGraph alGraph= new AdjacenyListGraph(DIRECTED_GRAPH_TYPE, 5);
		alGraph.init();
	}
	
	
}

class AdjacenyMatrixGraph{
	private String graphType;
	private int vertices;
	private int[][] edges;
	
	public AdjacenyMatrixGraph(String graphType,int vertices){
		this.graphType=graphType;
		this.vertices=vertices;
		edges=new int[vertices][vertices];
		
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++){
				edges[i][j]=0;
			}
		}
	}
	
	public String getGraphType() {
		return graphType;
	}
	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}
	public int getVertices() {
		return vertices;
	}
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
	public int[][] getEdges() {
		return edges;
	}
	public void setEdges(int[][] edges) {
		this.edges = edges;
	}
	public void addEdge(int src, int dest){
		edges[src][dest]=1;
		if(graphType.equals(GraphRepresentation.DIRECTED_GRAPH_TYPE)){
			edges[dest][src ]=1;
		}
	}
	public void removeEdge(int src, int dest){
		edges[src][dest]=0;
		if(graphType.equals(GraphRepresentation.DIRECTED_GRAPH_TYPE)){
			edges[dest][src ]=0;
		}
	}
	public void printGraph(){
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++){
				System.out.print(edges[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public void init(){
		addEdge(0, 1); 
	    addEdge(0, 4); 
	    addEdge(1, 2); 
	    addEdge(1, 3); 
	    addEdge(1, 4); 
	    addEdge(2, 3); 
	    addEdge(3, 4); 
	    printGraph(); 
	}
	
}

class AdjacenyListGraph{
	private String graphType;
	private int vertices;
	private List<Integer>[] edges;
	
	public AdjacenyListGraph(String graphType,int vertices){
		this.graphType=graphType;
		this.vertices=vertices;
		edges=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
				edges[i]=new ArrayList<>();
		}
	}
	public String getGraphType() {
		return graphType;
	}

	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}
	public int getVertices() {
		return vertices;
	}
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
	public List<Integer>[] getEdges() {
		return edges;
	}
	public void setEdges(List<Integer>[] edges) {
		this.edges = edges;
	}
	void addEdge(int src, int dest){
		edges[src].add(dest);
		if(graphType.equals(GraphRepresentation.DIRECTED_GRAPH_TYPE)){
			edges[dest].add(src);
		}
	}
	
	void removeEdge(int src, int dest){
		edges[src].remove(dest);
		if(graphType.equals(GraphRepresentation.DIRECTED_GRAPH_TYPE)){
			edges[dest].remove(src);
		}
	}
	
	void printGraph(){
		for(int i=0;i<vertices;i++){
			System.out.println("Adjacency List of Vertex :" + i);
			for(int j=0;j<edges[i].size();j++){
				System.out.print(edges[i].get(j) + " -> ");
			}
			System.out.println("");
		}
	}
	
	void init(){
		addEdge(0, 1); 
	    addEdge(0, 4); 
	    addEdge(1, 2); 
	    addEdge(1, 3); 
	    addEdge(1, 4); 
	    addEdge(2, 3); 
	    addEdge(3, 4); 
	    printGraph(); 
	}
	
}
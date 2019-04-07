package com.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

	public static void main(String args[]) {
		AdjListGraph graph = new AdjListGraph(GraphRepresentation.DIRECTED_GRAPH_TYPE,4);
		graph.init();
		graph.printGraph();
		bfsTraversal(graph, 2);

	}

	public static void bfsTraversal(AdjListGraph graph, int source) {

		List<Integer> visited=new ArrayList<>();
		
		LinkedList<Integer> queue= new LinkedList<>();
		queue.add(source);
		
		while(queue.size()!=0){
			source=queue.poll();
			visited.add(source);
			System.out.print(source + " ");
			
			for(int i : graph.getEdges()[source]){
				if(!visited.contains(i)){
					visited.add(i);
					queue.add(i);
				}
			}
		}
		

	}

}

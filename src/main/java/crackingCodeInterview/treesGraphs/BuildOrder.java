package crackingCodeInterview.treesGraphs;
import java.util.*;
/**
 *  You are given a list of projects and a list of dependencies 
 * (which is a list of pairs of projects, where the second project is 
 * dependent on the first project). 
 * All of a project's dependencies must be built before the project is. 
 * Find a build order that will allow the projects to be built. 
 * If there is no valid build order, return an error.
 * 
 * Input:
    projects: a, b, c, d, e, f
    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    Output:f, e, a, b, d, c

    Solution Hint: Topological sorting: Graph DFS with a stack
 */
public class BuildOrder {
    static class Project {
        public enum State {COMPLETE, PARTIAL, BLANK};
        private ArrayList<Project> children = new ArrayList<Project>();
        private HashMap<String, Project> map = new HashMap<String, Project>();
        private String name;
        private State state = State.BLANK;
        
        public Project(String n) {
            name = n;
        }
    
        public String getName() {
            return name;
        }
        
        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
            }
        }
        
        public State getState() { 
            return state;
        }
        
        public void setState(State st) {
            state = st;
        }
        
        public ArrayList<Project> getChildren() {
            return children;
        }
    }
    static class Graph {
        private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	
	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		
		return map.get(name);
	}
	
	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	
	public ArrayList<Project> getNodes() {
		return nodes;
	}
    }
    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Stack<Project> buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}

    public static String[] convertToStringList(Stack<Project> projects) {
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}
	}

    public static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}

    public static Stack<Project> orderProjects(ArrayList<Project> projects) {
		var stack = new Stack<Project>();
		for (Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

    public static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL) {
			return false; // Cycle
		}
		
		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}

    public static Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
}

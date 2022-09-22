package crackingCodeInterview.recursion;

import java.awt.geom.Point2D;
import java.util.*;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns. 
 * The robot can only move in two directions, right and down, but certain cellsare"offlimits"
 * such that the robot cannot step on them. 
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class RobotInGrid {
    public static ArrayList<Point2D> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		var path = new ArrayList<Point2D>();
		var visited = new HashSet<Point2D>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path, visited)) {
			return path;
		}
		return null;
	}
    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point2D> path, HashSet<Point2D> visited) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		var p = new Point2D.Double(row, col);
		
		/* If we've already visited this cell, return. */
		if (visited.contains(p)) { 
			return false;
		}	
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(maze, row, col - 1, path, visited) || getPath(maze, row - 1, col, path, visited)) {
			path.add(p);
			return true;
		}
		
		visited.add(p); // Cache result
		return false;
	}
}

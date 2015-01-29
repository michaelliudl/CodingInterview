package net.mike.other;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by doliu on 1/9/15.
 */
class TowerOfDefense {

	private static final List<Coordinate> moves = Arrays.asList(new Coordinate(-1, 0), new Coordinate(1, 0), new Coordinate(0, -1), new Coordinate(0, 1));

	private int row, col;
	private int[][] cost;
	private Coordinate goal;

	TowerOfDefense(int row, int col, List<Coordinate> blocks, Coordinate goal) {
		// validate row, col
		this.row = row;
		this.col = col;
		cost = new int[row][col];
		if (blocks != null) {
			for (Coordinate coordinate : blocks) {
				// validate coordinate
				cost[coordinate.x][coordinate.y] = -1;
			}
		}
		// validate goad in range
		this.goal = goal;
	}

	void calculate() {
		int step = 0;
		Queue<Coordinate> queue = new ArrayDeque<Coordinate>();
		queue.offer(goal);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (!queue.isEmpty() && size > 0) {
				Coordinate cur = queue.poll();
				cost[cur.x][cur.y] = step;
				for (Coordinate move : moves) {
					Coordinate next = new Coordinate(cur.x + move.x, cur.y + move.y);
					if (next.isValid(this.row, this.col, goal, cost)) {
						queue.offer(next);
					}
				}
				size--;
			}
			step++;
		}
	}

	int[][] getCost() {
		return cost;
	}

	void printCost() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf("%2d ", cost[i][j]);
			}
			System.out.println();
		}

	}


}

class Coordinate {
	int x, y;
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	boolean isValid(int row, int col, Coordinate goal, int[][] cost) {
		boolean isInMatrix = x >= 0 && x < row && y >= 0 && y < col;
		boolean isNotGoal = !(x == goal.x && y == goal.y);
		return isInMatrix && isNotGoal && cost[x][y] == 0;
	}
}

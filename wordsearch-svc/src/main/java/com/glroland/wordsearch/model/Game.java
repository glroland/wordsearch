package com.glroland.wordsearch.model;

public class Game {

	private char board [][] = null;
	
	public Game(int width, int height, char defaultChar) {
		
		// validate arguments
		if (width < 1)
			throw new RuntimeException("Invalid width provided to Game: " + width);
		if (height < 1)
			throw new RuntimeException("Invalid height provided to Game: " + height);
		
		// create board
		board = new char[width][height];
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
			{
				board[x][y] = defaultChar;
			}
	}
	
	public int getWidth()
	{
		return board.length;
	}
	
	public int getHeight()
	{
		return board[0].length;
	}
	
	public char[][] getBoard()
	{
		return board;
	}
	
	public void setSquare(int x, int y, char v)
	{
		board[x][y] = v;
	}
	
	public char getSquare(int x, int y)
	{
		return board[x][y];
	}
}

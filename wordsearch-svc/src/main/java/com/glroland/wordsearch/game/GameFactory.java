package com.glroland.wordsearch.game;

import com.glroland.wordsearch.model.Game;

public class GameFactory {

	private static final int DEFAULT_WIDTH = 50;
	private static final int DEFAULT_HEIGHT = DEFAULT_WIDTH;
	private static final char DEFAULT_CHAR = ' ';
	
	private enum Direction { Horizontal, Vertical, DiagonalForward, DiagonalBackward };
	
	private static GameFactory instance = null;
	
	public static GameFactory getInstance() {
		synchronized (GameFactory.class) {
			if (instance == null)
			{
				instance = new GameFactory();
			}
			return instance;
		}
	}
	
	private GameFactory()
	{
	}
	
	public Game generate()
	{
		return generate(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Game generate(int width, int height)
	{
    	Game game = new Game(width, height, DEFAULT_CHAR);
    	
    	String word = WordFactory.getInstance().getWord();
    	System.out.println(word);
    	attemptToPlaceWord(game, word);
    	
    	for (int x = 0; x < game.getWidth(); x++)
    	{
    		for (int y = 0; y < game.getHeight(); y++)
    		{
    			System.out.print(game.getSquare(x, y));
    		}
    	}
    	
    	return game;
	}
	
	private boolean attemptToPlaceWord(Game game, String word)
	{
		Direction dir = randomDirection();
		return false;
		
	}
	
	private Direction randomDirection()
	{
		double v = Math.random() * 4;
		if (v < 1)
			return Direction.DiagonalBackward;
		else if (v < 2)
			return Direction.DiagonalForward;
		else if (v < 2)
			return Direction.Vertical;
		else
			return Direction.Horizontal;
	}
}

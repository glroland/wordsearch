package com.glroland.wordsearch.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordFactory {

	public static final String DICTIONARY_FILE = "words.txt";
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int MIN_LENGTH = 3;
	private static final int MAX_LENGTH = 15;
	
	private static WordFactory instance = null;
	private ArrayList<String> words = null;
	
	public static WordFactory getInstance()
	{
		synchronized(WordFactory.class)
		{
			if (instance == null)
			{
				instance = new WordFactory();
			}
			return instance;
		}
	}
	
	private WordFactory()
	{
		load();
	}
	
	private void load()
	{
		// load the dictionary file
		InputStream inputStream = ClassLoader.getSystemResourceAsStream(DICTIONARY_FILE);
		if (inputStream == null)
		{
			throw new RuntimeException("Unable to load dictionary file: " + DICTIONARY_FILE);
		}
		
		ArrayList<String> words = new ArrayList<String>();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); 
		String line = null;
		try
		{
			while ((line = bufferedReader.readLine()) != null) {
				String word = line.trim().toUpperCase();
				if (!filter(word))
					words.add(word);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("Unable to read data from the dictionary file: " + DICTIONARY_FILE, e);
		}
		
		this.words = words;
	}
	
	private static final boolean filter(String word)
	{
		// exclude all words that aren't letters only
		int wordLength = word.length();
		for (int i=0; i<wordLength; i++)
		{
			char letter = word.charAt(i);
			
			if (LETTERS.indexOf(letter) < 0)
			{
				return true;
			}
		}
		
		// check length
		if ((wordLength < MIN_LENGTH) || (wordLength > MAX_LENGTH))
			return true;
		
		return false;
	}
	
	public String getWord()
	{
		int pos = (int)(Math.random() * (double)words.size());
		return words.get(pos);
	}
}

package com.glroland.wordsearch.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordFactoryTest {

	@Test
	public void testWord() {
		String word = WordFactory.getInstance().getWord();
		assertNotNull(word);
		assertTrue(word.length() >= 3);
		assertTrue(word.length() <= 15);
		System.out.println(word);
	}

	@Test
	public void testUniqueInstance() {
		WordFactory i1 = WordFactory.getInstance();
		WordFactory i2 = WordFactory.getInstance();
		assertNotNull(i1);
		assertTrue(i1 == i2);
	}

}

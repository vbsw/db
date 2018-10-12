/*
 *    Copyright 2018, Vitali Baumtrok (vbsw@mailbox.org).
 * Distributed under the Boost Software License, Version 1.0.
 *      (See accompanying file LICENSE or copy at
 *        http://www.boost.org/LICENSE_1_0.txt)
 */


package com.github.vbsw.db.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.vbsw.db.Search;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Vitali Baumtrok
 */
class TestSearch {

	@Test
	void testBinaryLeftBorder ( ) {
		final int[] valuesA = new int[] { 5, 2, 4, 4, 4, 4, 3, 1 };
		final int[] indicesA = new int[] { 7, 1, 6, 2, 3, 4, 5, 0 };
		final int[] valuesB = new int[] { 4, 4, 4, 4, 4, 4, 7, 5 };
		final int[] indicesB = new int[] { 0, 1, 2, 3, 4, 5, 7, 6 };
		final int key = 4;

		assertEquals(3,Search.binaryLeftBorder(valuesA,indicesA,0,3,key));
		assertEquals(3,Search.binaryLeftBorder(valuesA,indicesA,0,4,key));
		assertEquals(3,Search.binaryLeftBorder(valuesA,indicesA,0,5,key));
		assertEquals(3,Search.binaryLeftBorder(valuesA,indicesA,0,6,key));

		assertEquals(0,Search.binaryLeftBorder(valuesB,indicesB,0,0,key));
		assertEquals(0,Search.binaryLeftBorder(valuesB,indicesB,0,1,key));
		assertEquals(0,Search.binaryLeftBorder(valuesB,indicesB,0,2,key));
		assertEquals(0,Search.binaryLeftBorder(valuesB,indicesB,0,3,key));
	}

	@Test
	void testBinaryRightBorder ( ) {
		final int[] valuesA = new int[] { 5, 2, 4, 4, 4, 4, 3, 1 };
		final int[] indicesA = new int[] { 7, 1, 6, 2, 3, 4, 5, 0 };
		final int[] valuesB = new int[] { 3, 2, 4, 4, 4, 4, 4, 4 };
		final int[] indicesB = new int[] { 1, 0, 2, 3, 4, 5, 6 };
		final int key = 4;

		assertEquals(7,Search.binaryRightBorder(valuesA,indicesA,3,valuesA.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesA,indicesA,4,valuesA.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesA,indicesA,5,valuesA.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesA,indicesA,6,valuesA.length,key));

		assertEquals(7,Search.binaryRightBorder(valuesB,indicesB,3,indicesB.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesB,indicesB,4,indicesB.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesB,indicesB,5,indicesB.length,key));
		assertEquals(7,Search.binaryRightBorder(valuesB,indicesB,6,indicesB.length,key));
	}

}

/*
 *    Copyright 2018, Vitali Baumtrok (vbsw@mailbox.org).
 * Distributed under the Boost Software License, Version 1.0.
 *      (See accompanying file LICENSE or copy at
 *        http://www.boost.org/LICENSE_1_0.txt)
 */


package com.github.vbsw.db.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.vbsw.db.DBColumnIndexed;
import com.github.vbsw.db.DBQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Vitali Baumtrok
 */
class TestDBQuery {

	@Test
	void testGetNextIntegerAsc ( ) {
		final DBColumnIndexed.Integer column = new DBColumnIndexed.Integer();
		final DBQuery.IntegerAsc query = new DBQuery.IntegerAsc(column);
		column.addValue(5);
		column.addValue(4);
		column.addValue(3);
		column.addValue(2);

		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.reset();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.setUpperBound(4,false);
		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(false,query.hasNext());
	}

	@Test
	void testGetNextIntegerDesc ( ) {
		final DBColumnIndexed.Integer column = new DBColumnIndexed.Integer();
		final DBQuery.IntegerDesc query = new DBQuery.IntegerDesc(column);
		column.addValue(5);
		column.addValue(4);
		column.addValue(3);
		column.addValue(2);

		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.reset();
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.setUpperBound(4,false);
		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(false,query.hasNext());
	}

	@Test
	void testGetNextString ( ) {
		final DBColumnIndexed.String column = new DBColumnIndexed.String();
		final DBQuery.StringAsc query = new DBQuery.StringAsc(column);
		column.addValue("ddd");
		column.addValue("ccc");
		column.addValue("bbb");
		column.addValue("aaa");

		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.reset();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(1,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(0,query.getNextIndex());
		assertEquals(false,query.hasNext());

		query.setUpperBound(column.values[1],false);
		query.prepare();
		assertEquals(true,query.hasNext());
		assertEquals(3,query.getNextIndex());
		assertEquals(true,query.hasNext());
		assertEquals(2,query.getNextIndex());
		assertEquals(false,query.hasNext());
	}

}

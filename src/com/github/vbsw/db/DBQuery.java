/*
 *    Copyright 2018, Vitali Baumtrok (vbsw@mailbox.org).
 * Distributed under the Boost Software License, Version 1.0.
 *      (See accompanying file LICENSE or copy at
 *        http://www.boost.org/LICENSE_1_0.txt)
 */


package com.github.vbsw.db;


/**
 * @author Vitali Baumtrok
 */
public class DBQuery {

	public boolean hasNext ( ) {
		return false;
	}

	public boolean hasPrevious ( ) {
		return false;
	}

	public int nextIndex ( ) {
		return -1;
	}

	public int previousIndex ( ) {
		return -1;
	}

}

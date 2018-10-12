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
public class UniqueOrderOfColumn7 {

	public static final int INITIAL_CAPACITY = 10;

	public UniqueOrderOfColumn6[] values;
	public int length;

	public UniqueOrderOfColumn7 ( ) {
		this(INITIAL_CAPACITY);
	}

	public UniqueOrderOfColumn7 ( final int initialCapacity ) {
		values = new UniqueOrderOfColumn6[initialCapacity];
		length = 0;
	}

	public void add ( final int index ) {
		final UniqueOrderOfColumn6 value = new UniqueOrderOfColumn6(1);
		value.add(0);
		add(index,value);
	}

	public void add ( final int index, final UniqueOrderOfColumn6 value ) {
		final int copyLength = length - index;
		if ( length == values.length ) {
			final UniqueOrderOfColumn6[] valuesNew = new UniqueOrderOfColumn6[values.length * 2];
			System.arraycopy(values,0,valuesNew,0,values.length);
			values = valuesNew;
		}
		if ( copyLength > 0 )
			System.arraycopy(values,index,values,index + 1,copyLength);
		values[index] = value;
		length += 1;
	}

	public void remove ( final int index ) {
		length -= 1;
		if ( index < length ) {
			final int srcIndex = index + 1;
			final int copyLength = length - index;
			System.arraycopy(values,srcIndex,values,index,copyLength);
		}
	}

}
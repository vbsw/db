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
public class UniqueOrderOfColumn9 {

	public static final int INITIAL_CAPACITY = 10;

	public UniqueOrderOfColumn8[] values;
	public int length;

	public UniqueOrderOfColumn9 ( ) {
		this(INITIAL_CAPACITY);
	}

	public UniqueOrderOfColumn9 ( final int initialCapacity ) {
		values = new UniqueOrderOfColumn8[initialCapacity];
		length = 0;
	}

	public void add ( final int index ) {
		final UniqueOrderOfColumn8 value = new UniqueOrderOfColumn8(1);
		value.add(0);
		add(index,value);
	}

	public void add ( final int index, final UniqueOrderOfColumn8 value ) {
		final int copyLength = length - index;
		if ( length == values.length ) {
			final UniqueOrderOfColumn8[] valuesNew = new UniqueOrderOfColumn8[values.length * 2];
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

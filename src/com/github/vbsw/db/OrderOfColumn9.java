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
public class OrderOfColumn9 {

	public static final int INITIAL_CAPACITY = 10;

	public OrderOfColumn8[] values;
	public int length;

	public OrderOfColumn9 ( ) {
		this(INITIAL_CAPACITY);
	}

	public OrderOfColumn9 ( final int initialCapacity ) {
		values = new OrderOfColumn8[initialCapacity];
		length = 0;
	}

	public void add ( final int index ) {
		final OrderOfColumn8 value = new OrderOfColumn8(1);
		value.add(0);
		add(index,value);
	}

	public void add ( final int index, final OrderOfColumn8 value ) {
		final int copyLength = length - index;
		if ( length == values.length ) {
			final OrderOfColumn8[] valuesNew = new OrderOfColumn8[values.length * 2];
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
		values[length] = null;
	}

}

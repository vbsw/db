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
public class ColumnOfInt {

	public static final int INITIAL_CAPACITY = 10;

	public int[] values;
	public int length;

	public ColumnOfInt ( ) {
		this(INITIAL_CAPACITY);
	}

	public ColumnOfInt ( final int initialCapacity ) {
		values = new int[initialCapacity];
		length = 0;
	}

	public void clear ( ) {
		length = 0;
	}

	public void add ( final int value ) {
		final int index = length;
		if ( length == values.length ) {
			final int[] valuesNew = new int[values.length * 2];
			System.arraycopy(values,0,valuesNew,0,values.length);
			values = valuesNew;
		}
		values[index] = value;
		length += 1;
	}

	public void remove ( ) {
		remove(length - 1);
	}

	public void remove ( final int index ) {
		length -= 1;
		if ( index < length ) {
			final int srcIndex = index + 1;
			final int copyLength = length - index;
			System.arraycopy(values,srcIndex,values,index,copyLength);
		}
	}

	public String toString ( final String prefix, final String suffix, final String separator ) {
		final StringBuilder builder = new StringBuilder(100);
		builder.append(prefix);
		for ( int i = 0; i < length; i += 1 ) {
			if ( i > 0 )
				builder.append(separator);
			builder.append(values[i]);
		}
		builder.append(suffix);
		return builder.toString();
	}

	@Override
	public String toString ( ) {
		return toString("[","]",", ");
	}

	@Override
	public ColumnOfInt clone ( ) {
		final ColumnOfInt newColumn = new ColumnOfInt(values.length);
		newColumn.length = length;
		for ( int i = 0; i < length; i += 1 )
			newColumn.values[i] = values[i];
		return newColumn;
	}

}

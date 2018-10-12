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
public class OrderOfColumn {

	public static final int INITIAL_CAPACITY = 10;

	public UniqueOrderOfColumn[] values;
	public int length;

	public OrderOfColumn ( ) {
		this(INITIAL_CAPACITY);
	}

	public OrderOfColumn ( final int initialCapacity ) {
		values = new UniqueOrderOfColumn[initialCapacity];
		length = 0;
	}

	public void add ( final int index ) {
		final UniqueOrderOfColumn value = new UniqueOrderOfColumn(1);
		add(index,value);
	}

	public void add ( final int index, final UniqueOrderOfColumn value ) {
		final int copyLength = length - index;
		if ( length == values.length ) {
			final UniqueOrderOfColumn[] valuesNew = new UniqueOrderOfColumn[values.length * 2];
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

	public <T> int search ( final Object[] values, final Comparable<T> value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final String[] values, final String value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final long[] values, final long value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final int[] values, final int value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final short[] values, final short value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final byte[] values, final byte value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final double[] values, final double value ) {
		return Search.binary(values,this.values,0,length,value);
	}

	public int search ( final float[] values, final float value ) {
		return Search.binary(values,this.values,0,length,value);
	}

}

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
public class OrderOfColumnX {

	public static final int INITIAL_CAPACITY = 10;

	public int[] values;
	public int length;

	public OrderOfColumnX ( ) {
		this(INITIAL_CAPACITY);
	}

	public OrderOfColumnX ( final int initialCapacity ) {
		values = new int[initialCapacity];
		length = 0;
	}

	public void add ( final int index, final int value ) {
		final int copyLength = length - index;
		if ( length == values.length ) {
			final int[] valuesNew = new int[values.length * 2];
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

	@SuppressWarnings ( "unchecked" )
	public <T> int search ( final Object[] values, final int index, final Range range ) {
		searchRange(values,(T) values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final String[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final long[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final int[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final short[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final byte[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final double[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public int search ( final float[] values, final int index, final Range range ) {
		searchRange(values,values[index],range);
		return Search.binary(this.values,range.from,range.to,index);
	}

	public <T> void searchRange ( final Object[] values, final T value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || !values[this.values[from]].equals(value) )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || !values[this.values[to]].equals(value) )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final String[] values, final String value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || !values[this.values[from]].equals(value) )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || !values[this.values[to]].equals(value) )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final long[] values, final long value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final int[] values, final int value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final short[] values, final short value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final byte[] values, final byte value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final double[] values, final double value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

	public void searchRange ( final float[] values, final float value, final Range range ) {
		final int index = Search.binary(values,this.values,0,this.length,value);
		if ( index >= 0 ) {
			int from = index - 1;
			int to = index + 1;
			if ( from < 0 || values[this.values[from]] != value )
				range.from = from + 1;
			else
				range.from = Search.binaryLeftBorder(values,this.values,0,from,value);
			if ( to >= length || values[this.values[to]] != value )
				range.to = to;
			else
				range.to = Search.binaryRightBorder(values,this.values,to + 1,length,value);
		} else {
			range.setInsertIndex(index);
		}
	}

}

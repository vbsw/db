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
public final class Search {

	public static int binary ( final String[] values, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int compareResult = values[middle].compareTo(key);
			if ( compareResult < 0 )
				left = middle + 1;
			else if ( compareResult > 0 )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static <T> int binary ( final Object[] values, final int from, final int to, final T key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			@SuppressWarnings ( "unchecked" )
			final Comparable<T> value = (Comparable<T>) values[middle];
			final int compareResult = value.compareTo(key);
			if ( compareResult < 0 )
				left = middle + 1;
			else if ( compareResult > 0 )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final int[] values, final int from, final int to, final int key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			if ( values[middle] < key )
				left = middle + 1;
			else if ( values[middle] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final short[] values, final int from, final int to, final short key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			if ( values[middle] < key )
				left = middle + 1;
			else if ( values[middle] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final byte[] values, final int from, final int to, final byte key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			if ( values[middle] < key )
				left = middle + 1;
			else if ( values[middle] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final double[] values, final int from, final int to, final double key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			if ( values[middle] < key )
				left = middle + 1;
			else if ( values[middle] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final long[] values, final int from, final int to, final long key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			if ( values[middle] < key )
				left = middle + 1;
			else if ( values[middle] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final String[] values, final int[] indices, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			final int compareResult = values[valueIndex].compareTo(key);
			if ( compareResult < 0 )
				left = middle + 1;
			else if ( compareResult > 0 )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static <T> int binary ( final Object[] values, final int[] indices, final int from, final int to, final T key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			@SuppressWarnings ( "unchecked" )
			final Comparable<T> value = (Comparable<T>) values[valueIndex];
			final int compareResult = value.compareTo(key);
			if ( compareResult < 0 )
				left = middle + 1;
			else if ( compareResult > 0 )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final int[] values, final int[] indices, final int from, final int to, final int key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final short[] values, final int[] indices, final int from, final int to, final short key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final byte[] values, final int[] indices, final int from, final int to, final byte key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final double[] values, final int[] indices, final int from, final int to, final double key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final long[] values, final int[] indices, final int from, final int to, final long key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int linear ( final int[] values, final int from, final int to, final int key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final long[] values, final int from, final int to, final long key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final double[] values, final int from, final int to, final double key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final boolean[] values, final int from, final int to, final boolean key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final short[] values, final int from, final int to, final short key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final float[] values, final int from, final int to, final float key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final Object[] values, final int from, final int to, final Object key ) {
		for ( int i = from; i < to; i++ ) {
			final Object value = values[i];
			if ( value == key || (value != null && value.equals(key)) )
				return i;
		}
		return -(to + 1);
	}

	public static int linear ( final byte[] values, final int from, final int to, final byte key ) {
		for ( int i = from; i < to; i++ )
			if ( values[i] == key )
				return i;
		return -(to + 1);
	}

	public static int linear ( final String[] values, final int from, final int to, final String key ) {
		for ( int i = from; i < to; i++ ) {
			final String value = values[i];
			if ( value == key || (value != null && value.compareTo(key) == 0) )
				return i;
		}
		return -(to + 1);
	}

}

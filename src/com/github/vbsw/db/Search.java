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

	public static <T> int binary ( final Object[] values, final int[] indices, final int from, final int to, final Comparable<T> key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			@SuppressWarnings ( "unchecked" )
			final int compareResult = key.compareTo((T) values[valueIndex]);
			if ( compareResult > 0 )
				left = middle + 1;
			else if ( compareResult < 0 )
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

	public static int binaryByPrefix ( final String[] values, final int[] indices, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			final String value = values[valueIndex];
			if ( !value.startsWith(key) ) {
				final int compareResult = value.compareTo(key);
				if ( compareResult < 0 )
					left = middle + 1;
				else if ( compareResult > 0 )
					right = middle - 1;
				else
					return middle;
			} else {
				return middle;
			}
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

	public static int binary ( final float[] values, final int[] indices, final int from, final int to, final float key ) {
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

	public static <T> int binary ( final Object[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final Comparable<T> key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			@SuppressWarnings ( "unchecked" )
			final int compareResult = key.compareTo((T) values[valueIndex]);
			if ( compareResult > 0 )
				left = middle + 1;
			else if ( compareResult < 0 )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final String[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
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

	public static int binary ( final long[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final long key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final int[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final int key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final short[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final short key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final byte[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final byte key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final double[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final double key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binary ( final float[] values, final UniqueOrderOfColumn[] indices, final int from, final int to, final float key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle].values[0];
			if ( values[valueIndex] < key )
				left = middle + 1;
			else if ( values[valueIndex] > key )
				right = middle - 1;
			else
				return middle;
		}
		return -left - 1;
	}

	public static int binaryLeftBorder ( final Object[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final Object key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].equals(key) )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final String[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final String key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].equals(key) )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorderByPrefix ( final String[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final String key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].startsWith(key) )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final long[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final long key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final int[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final int key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final short[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final short key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final byte[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final byte key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final double[] values, final int[] indices, final int leftBorderIncl, final int rightBorderIncl, final double key ) {
		int left = leftBorderIncl;
		int right = rightBorderIncl - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryLeftBorder ( final float[] values, final int[] indices, final int from, final int to, final float key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				left = middle + 1;
			else
				right = middle - 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final Object[] values, final int[] indices, final int from, final int to, final Object key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].equals(key) )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final String[] values, final int[] indices, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].equals(key) )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorderByPrefix ( final String[] values, final int[] indices, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( !values[valueIndex].startsWith(key) )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final long[] values, final int[] indices, final int from, final int to, final long key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final int[] values, final int[] indices, final int from, final int to, final int key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final short[] values, final int[] indices, final int from, final int to, final short key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final byte[] values, final int[] indices, final int from, final int to, final byte key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final float[] values, final int[] indices, final int from, final int to, final float key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

	public static int binaryRightBorder ( final double[] values, final int[] indices, final int from, final int to, final double key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final int valueIndex = indices[middle];
			if ( values[valueIndex] != key )
				right = middle - 1;
			else
				left = middle + 1;
		}
		return left;
	}

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

	public static int binaryByPrefix ( final String[] values, final int from, final int to, final String key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			final String value = values[middle];
			if ( !value.startsWith(key) ) {
				final int compareResult = value.compareTo(key);
				if ( compareResult < 0 )
					left = middle + 1;
				else if ( compareResult > 0 )
					right = middle - 1;
				else
					return middle;
			} else {
				return middle;
			}
		}
		return -left - 1;
	}

	public static <T> int binary ( final Object[] values, final int from, final int to, final Comparable<T> key ) {
		int left = from;
		int right = to - 1;
		while ( left <= right ) {
			final int middle = (left + right) / 2;
			@SuppressWarnings ( "unchecked" )
			final int compareResult = key.compareTo((T) values[middle]);
			if ( compareResult > 0 )
				left = middle + 1;
			else if ( compareResult < 0 )
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

	public static int linearByPrefix ( final String[] values, final int from, final int to, final String key ) {
		for ( int i = from; i < to; i++ ) {
			final String value = values[i];
			if ( value == key || (value != null && value.startsWith(key)) )
				return i;
		}
		return -(to + 1);
	}

}

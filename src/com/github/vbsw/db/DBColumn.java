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
public final class DBColumn {

	private DBColumn ( ) {
	}

	public static final class Integer {

		public static final int INITIAL_CAPACITY = 10;

		public int[] values;
		public int valuesLength;

		public Integer ( ) {
			this(INITIAL_CAPACITY);
		}

		public Integer ( final int initialCapacity ) {
			values = new int[initialCapacity];
			clear();
		}

		public void clear ( ) {
			valuesLength = 0;
		}

		public int addValue ( final int value ) {
			final int index = valuesLength;
			ensureValuesCapacity();
			values[valuesLength] = value;
			valuesLength += 1;
			return index;
		}

		public void removeValueAt ( final int index ) {
			valuesLength -= 1;
			if ( index < valuesLength ) {
				final int srcIndex = index + 1;
				final int copyLength = valuesLength - index;
				System.arraycopy(values,srcIndex,values,index,copyLength);
			}
		}

		@Override
		public String toString ( ) {
			return toString("[","]",",");
		}

		public String toString ( final String prefix, final String suffix, final String separator ) {
			final StringBuilder builder = new StringBuilder(100);
			builder.append(prefix);
			for ( int i = 0; i < valuesLength; i += 1 ) {
				if ( i > 0 )
					builder.append(separator);
				builder.append(values[i]);
			}
			builder.append(suffix);
			return builder.toString();
		}

		private void ensureValuesCapacity ( ) {
			if ( valuesLength == values.length ) {
				final int newLength = values.length * 2;
				final int[] newValues = new int[newLength];
				System.arraycopy(values,0,newValues,0,values.length);
				values = newValues;
			}
		}
	}

}

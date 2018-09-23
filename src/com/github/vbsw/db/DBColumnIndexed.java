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
public final class DBColumnIndexed {

	private DBColumnIndexed ( ) {
	}

	public static final class Integer {

		public static final int INITIAL_CAPACITY = 10;

		public int[] values;
		public int[] indices;
		public int valuesLength;
		public int indicesLength;

		public Integer ( ) {
			this(INITIAL_CAPACITY);
		}

		public Integer ( final int initialCapacity ) {
			values = new int[initialCapacity];
			indices = new int[initialCapacity];
			clear();
		}

		public void clear ( ) {
			valuesLength = 0;
			indicesLength = 0;
		}

		public void rebuildIndex ( ) {
			for ( indicesLength = 0; indicesLength < valuesLength; indicesLength++ ) {
				final int value = values[indicesLength];
				final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
				final int insertIndicesIndex = indicesIndex < 0 ? -(indicesIndex + 1) : indicesIndex;
				final int copyLength = indicesLength - insertIndicesIndex;
				ensureIndicesCapacity();
				if ( copyLength > 0 )
					System.arraycopy(indices,insertIndicesIndex,indices,insertIndicesIndex + 1,copyLength);
				indices[insertIndicesIndex] = indicesLength;
				indicesLength += 1;
			}
		}

		public int addValue ( final int value ) {
			final int index = valuesLength;
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			final int insertIndicesIndex = indicesIndex < 0 ? -(indicesIndex + 1) : indicesIndex;
			final int indicesCopyLength = indicesLength - insertIndicesIndex;
			ensureValuesCapacity();
			ensureIndicesCapacity();
			if ( indicesCopyLength > 0 )
				System.arraycopy(indices,insertIndicesIndex,indices,insertIndicesIndex + 1,indicesCopyLength);
			values[valuesLength] = value;
			indices[insertIndicesIndex] = valuesLength;
			valuesLength += 1;
			indicesLength += 1;
			return index;
		}

		public void updateValueAt ( final int index, final int newValue ) {
			final int oldValue = values[index];
			final int oldIndicesIndex = Search.binary(values,indices,0,indicesLength,oldValue);
			final int newIndicesIndex = Search.binary(values,indices,0,indicesLength,newValue);
			final int indicesIndex;
			if ( oldIndicesIndex != newIndicesIndex ) {
				if ( oldIndicesIndex < newIndicesIndex ) {
					final int copyLength = newIndicesIndex - oldIndicesIndex;
					System.arraycopy(indices,oldIndicesIndex + 1,indices,oldIndicesIndex,copyLength);
					indicesIndex = newIndicesIndex - 1;
				} else {
					final int copyLength = oldIndicesIndex - newIndicesIndex;
					System.arraycopy(indices,newIndicesIndex,indices,newIndicesIndex + 1,copyLength);
					indicesIndex = newIndicesIndex;
				}
			} else {
				indicesIndex = newIndicesIndex;
			}
			indices[indicesIndex] = index;
		}

		public void removeValueAt ( final int index ) {
			final int value = values[index];
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			valuesLength -= 1;
			indicesLength -= 1;
			if ( index < valuesLength ) {
				final int srcIndex = index + 1;
				final int copyLength = valuesLength - index;
				System.arraycopy(values,srcIndex,values,index,copyLength);
			}
			if ( indicesIndex < indicesLength ) {
				final int srcIndex = indicesIndex + 1;
				final int copyLength = indicesLength - indicesIndex;
				System.arraycopy(indices,srcIndex,indices,indicesIndex,copyLength);
			}
		}

		public int getValueIndex ( final int value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			final int valueIndex;
			if ( indicesIndex >= 0 )
				valueIndex = indices[indicesIndex];
			else
				valueIndex = -valuesLength - 1;
			return valueIndex;
		}

		public int getFirstValueIndex ( final int value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			int valueIndex;
			if ( indicesIndex >= 0 ) {
				valueIndex = indices[indicesIndex] - 1;
				while ( valueIndex > 0 && values[valueIndex] == value ) {
					valueIndex--;
				}
				valueIndex++;
			} else {
				valueIndex = -valuesLength - 1;
			}
			return valueIndex;
		}

		public int getLastValueIndex ( final int value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			int valueIndex;
			if ( indicesIndex >= 0 ) {
				valueIndex = indices[indicesIndex];
				valueIndex++;
				while ( valueIndex < valuesLength && values[valueIndex] == value ) {
					valueIndex++;
				}
				valueIndex--;
			} else {
				valueIndex = -valuesLength - 1;
			}
			return valueIndex;
		}

		@Override
		public java.lang.String toString ( ) {
			return toString("[","]",",");
		}

		public java.lang.String toString ( final java.lang.String prefix, final java.lang.String suffix, final java.lang.String separator ) {
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

		private void ensureIndicesCapacity ( ) {
			if ( indicesLength == indices.length ) {
				final int newLength = indices.length * 2;
				final int[] newIndices = new int[newLength];
				System.arraycopy(indices,0,newIndices,0,indices.length);
				indices = newIndices;
			}
		}
	}

	public static final class String {

		public static final int INITIAL_CAPACITY = 10;

		public java.lang.String[] values;
		public int[] indices;
		public int valuesLength;
		public int indicesLength;

		public String ( ) {
			this(INITIAL_CAPACITY);
		}

		public String ( final int initialCapacity ) {
			values = new java.lang.String[initialCapacity];
			indices = new int[initialCapacity];
			clear();
		}

		public void clear ( ) {
			valuesLength = 0;
			indicesLength = 0;
		}

		public void rebuildIndex ( ) {
			for ( indicesLength = 0; indicesLength < valuesLength; indicesLength++ ) {
				final java.lang.String value = values[indicesLength];
				final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
				final int insertIndicesIndex = indicesIndex < 0 ? -(indicesIndex + 1) : indicesIndex;
				final int copyLength = indicesLength - insertIndicesIndex;
				ensureIndicesCapacity();
				if ( copyLength > 0 )
					System.arraycopy(indices,insertIndicesIndex,indices,insertIndicesIndex + 1,copyLength);
				indices[insertIndicesIndex] = indicesLength;
				indicesLength += 1;
			}
		}

		public int addValue ( final java.lang.String value ) {
			final int index = valuesLength;
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			final int insertIndicesIndex = indicesIndex < 0 ? -(indicesIndex + 1) : indicesIndex;
			final int indicesCopyLength = indicesLength - insertIndicesIndex;
			ensureValuesCapacity();
			ensureIndicesCapacity();
			if ( indicesCopyLength > 0 )
				System.arraycopy(indices,insertIndicesIndex,indices,insertIndicesIndex + 1,indicesCopyLength);
			values[valuesLength] = value;
			indices[insertIndicesIndex] = valuesLength;
			valuesLength += 1;
			indicesLength += 1;
			return index;
		}

		public void updateValueAt ( final int index, final java.lang.String newValue ) {
			final java.lang.String oldValue = values[index];
			final int oldIndicesIndex = Search.binary(values,indices,0,indicesLength,oldValue);
			final int newIndicesIndex = Search.binary(values,indices,0,indicesLength,newValue);
			final int indicesIndex;
			if ( oldIndicesIndex != newIndicesIndex ) {
				if ( oldIndicesIndex < newIndicesIndex ) {
					final int copyLength = newIndicesIndex - oldIndicesIndex;
					System.arraycopy(indices,oldIndicesIndex + 1,indices,oldIndicesIndex,copyLength);
					indicesIndex = newIndicesIndex - 1;
				} else {
					final int copyLength = oldIndicesIndex - newIndicesIndex;
					System.arraycopy(indices,newIndicesIndex,indices,newIndicesIndex + 1,copyLength);
					indicesIndex = newIndicesIndex;
				}
			} else {
				indicesIndex = newIndicesIndex;
			}
			indices[indicesIndex] = index;
		}

		public void removeValueAt ( final int index ) {
			final java.lang.String value = values[index];
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			valuesLength -= 1;
			indicesLength -= 1;
			if ( index < valuesLength ) {
				final int srcIndex = index + 1;
				final int copyLength = valuesLength - index;
				System.arraycopy(values,srcIndex,values,index,copyLength);
			}
			if ( indicesIndex < indicesLength ) {
				final int srcIndex = indicesIndex + 1;
				final int copyLength = indicesLength - indicesIndex;
				System.arraycopy(indices,srcIndex,indices,indicesIndex,copyLength);
			}
		}

		public int getValueIndex ( final int value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			final int valueIndex;
			if ( indicesIndex >= 0 )
				valueIndex = indices[indicesIndex];
			else
				valueIndex = -valuesLength - 1;
			return valueIndex;
		}

		public int getFirstValueIndex ( final java.lang.String value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			int valueIndex;
			if ( indicesIndex >= 0 ) {
				valueIndex = indices[indicesIndex] - 1;
				while ( valueIndex > 0 && (values[valueIndex] == value || values[valueIndex].equals(value)) ) {
					valueIndex--;
				}
				valueIndex++;
			} else {
				valueIndex = -valuesLength - 1;
			}
			return valueIndex;
		}

		public int getLastValueIndex ( final java.lang.String value ) {
			final int indicesIndex = Search.binary(values,indices,0,indicesLength,value);
			int valueIndex;
			if ( indicesIndex >= 0 ) {
				valueIndex = indices[indicesIndex];
				valueIndex++;
				while ( valueIndex < valuesLength && (values[valueIndex] == value || values[valueIndex].equals(value)) ) {
					valueIndex++;
				}
				valueIndex--;
			} else {
				valueIndex = -valuesLength - 1;
			}
			return valueIndex;
		}

		@Override
		public java.lang.String toString ( ) {
			return toString("[","]",",");
		}

		public java.lang.String toString ( final java.lang.String prefix, final java.lang.String suffix, final java.lang.String separator ) {
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
				final java.lang.String[] newValues = new java.lang.String[newLength];
				System.arraycopy(values,0,newValues,0,values.length);
				values = newValues;
			}
		}

		private void ensureIndicesCapacity ( ) {
			if ( indicesLength == indices.length ) {
				final int newLength = indices.length * 2;
				final int[] newIndices = new int[newLength];
				System.arraycopy(indices,0,newIndices,0,indices.length);
				indices = newIndices;
			}
		}
	}

}

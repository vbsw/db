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
public abstract class DBQuery {

	protected boolean lowerBoundInclusive;
	protected boolean lowerBoundEnabled;
	protected boolean upperBoundInclusive;
	protected boolean upperBoundEnabled;
	protected int startIndex;
	protected int currIndex;

	public final void setLowerBoundDisabled ( ) {
		lowerBoundEnabled = false;
	}

	public final void setUpperBoundDisabled ( ) {
		upperBoundEnabled = false;
	}

	public final void reset ( ) {
		currIndex = startIndex;
	}

	public static final class IntegerAsc extends DBQuery {

		private final DBColumnIndexed.Integer column;
		private int lowerBound;
		private int upperBound;

		public IntegerAsc ( final DBColumnIndexed.Integer column ) {
			this.column = column;
		}

		public final void setLowerBound ( final int lowerBound, final boolean inclusive ) {
			this.lowerBoundEnabled = true;
			this.lowerBound = lowerBound;
			this.lowerBoundInclusive = inclusive;
		}

		public final void setUpperBound ( final int upperBound, final boolean inclusive ) {
			this.upperBoundEnabled = true;
			this.upperBound = upperBound;
			this.upperBoundInclusive = inclusive;
		}

		public final void prepare ( ) {
			if ( lowerBoundEnabled ) {
				final int indicesIndex = Search.binary(column.values,column.indices,0,column.indicesLength,lowerBound);
				if ( indicesIndex < 0 )
					startIndex = -indicesIndex - 1;
				else {
					if ( lowerBoundInclusive )
						startIndex = getLeftIndex(indicesIndex);
					else
						startIndex = getRightIndex(indicesIndex) - 1;
				}
			} else {
				startIndex = -1;
			}
			reset();
		}

		public final boolean hasNext ( ) {
			boolean has = false;
			currIndex++;
			if ( currIndex < column.indicesLength ) {
				if ( upperBoundEnabled )
					if ( upperBoundInclusive )
						has = column.values[column.indices[currIndex]] <= upperBound;
					else
						has = column.values[column.indices[currIndex]] < upperBound;
				else
					has = true;
			}
			if ( !has )
				currIndex = startIndex;
			return has;
		}

		public final int getNextIndex ( ) {
			return column.indices[currIndex];
		}

		private int getRightIndex ( int indicesIndex ) {
			indicesIndex++;
			while ( indicesIndex < column.indicesLength && column.values[column.indices[indicesIndex]] == lowerBound )
				indicesIndex++;
			return indicesIndex;
		}

		private int getLeftIndex ( int indicesIndex ) {
			indicesIndex--;
			while ( indicesIndex > 0 && column.values[column.indices[indicesIndex]] == lowerBound )
				indicesIndex--;
			return indicesIndex;
		}

	}

	public static final class IntegerDesc extends DBQuery {

		private final DBColumnIndexed.Integer column;
		private int lowerBound;
		private int upperBound;

		public IntegerDesc ( final DBColumnIndexed.Integer column ) {
			this.column = column;
		}

		public final void setLowerBound ( final int lowerBound, final boolean inclusive ) {
			this.lowerBoundEnabled = true;
			this.lowerBound = lowerBound;
			this.lowerBoundInclusive = inclusive;
		}

		public final void setUpperBound ( final int upperBound, final boolean inclusive ) {
			this.upperBoundEnabled = true;
			this.upperBound = upperBound;
			this.upperBoundInclusive = inclusive;
		}

		public final void prepare ( ) {
			if ( upperBoundEnabled ) {
				final int indicesIndex = Search.binary(column.values,column.indices,0,column.indicesLength,upperBound);
				if ( indicesIndex < 0 )
					startIndex = -indicesIndex - 1;
				else {
					if ( upperBoundInclusive )
						startIndex = getRightIndex(indicesIndex);
					else
						startIndex = getLeftIndex(indicesIndex) + 1;
				}
			} else {
				startIndex = column.indicesLength;
			}
			reset();
		}

		public final boolean hasNext ( ) {
			boolean has = false;
			currIndex--;
			if ( currIndex >= 0 ) {
				if ( lowerBoundEnabled )
					if ( lowerBoundInclusive )
						has = column.values[column.indices[currIndex]] >= lowerBound;
					else
						has = column.values[column.indices[currIndex]] > lowerBound;
				else
					has = true;
			}
			if ( !has )
				currIndex = startIndex;
			return has;
		}

		public final int getNextIndex ( ) {
			return column.indices[currIndex];
		}

		private int getRightIndex ( int indicesIndex ) {
			indicesIndex++;
			while ( indicesIndex < column.indicesLength && column.values[column.indices[indicesIndex]] == lowerBound )
				indicesIndex++;
			return indicesIndex;
		}

		private int getLeftIndex ( int indicesIndex ) {
			indicesIndex--;
			while ( indicesIndex > 0 && column.values[column.indices[indicesIndex]] == lowerBound )
				indicesIndex--;
			return indicesIndex;
		}

	}

	public static final class StringAsc extends DBQuery {

		private final DBColumnIndexed.String column;
		private String lowerBound;
		private String upperBound;

		public StringAsc ( final DBColumnIndexed.String column ) {
			this.column = column;
		}

		public final void setLowerBound ( final String lowerBound, final boolean inclusive ) {
			this.lowerBoundEnabled = true;
			this.lowerBound = lowerBound;
			this.lowerBoundInclusive = inclusive;
		}

		public final void setUpperBound ( final String upperBound, final boolean inclusive ) {
			this.upperBoundEnabled = true;
			this.upperBound = upperBound;
			this.upperBoundInclusive = inclusive;
		}

		public final void prepare ( ) {
			if ( lowerBoundEnabled ) {
				final int indicesIndex = Search.binary(column.values,column.indices,0,column.indicesLength,lowerBound);
				if ( indicesIndex < 0 )
					startIndex = -indicesIndex - 1;
				else {
					if ( lowerBoundInclusive )
						startIndex = indicesIndex - 1;
					else
						startIndex = indicesIndex;
				}
			} else {
				startIndex = -1;
			}
			reset();
		}

		public final boolean hasNext ( ) {
			boolean has = false;
			currIndex++;
			if ( currIndex < column.indicesLength ) {
				if ( upperBoundEnabled )
					if ( upperBoundInclusive )
						has = column.values[column.indices[currIndex]].compareTo(upperBound) <= 0;
					else
						has = column.values[column.indices[currIndex]].compareTo(upperBound) < 0;
				else
					has = true;
			}
			if ( !has )
				currIndex = startIndex;
			return has;
		}

		public final int getNextIndex ( ) {
			return column.indices[currIndex];
		}

	}

	public static final class StringDesc extends DBQuery {

		private final DBColumnIndexed.String column;
		private String lowerBound;
		private String upperBound;

		public StringDesc ( final DBColumnIndexed.String column ) {
			this.column = column;
		}

		public final void setLowerBound ( final String lowerBound, final boolean inclusive ) {
			this.lowerBoundEnabled = true;
			this.lowerBound = lowerBound;
			this.lowerBoundInclusive = inclusive;
		}

		public final void setUpperBound ( final String upperBound, final boolean inclusive ) {
			this.upperBoundEnabled = true;
			this.upperBound = upperBound;
			this.upperBoundInclusive = inclusive;
		}

		public final void prepare ( ) {
			if ( upperBoundEnabled ) {
				final int indicesIndex = Search.binary(column.values,column.indices,0,column.indicesLength,upperBound);
				if ( indicesIndex < 0 )
					startIndex = -indicesIndex - 1;
				else {
					if ( upperBoundInclusive )
						startIndex = indicesIndex + 1;
					else
						startIndex = indicesIndex;
				}
			} else {
				startIndex = column.indicesLength;
			}
			reset();
		}

		public final boolean hasNext ( ) {
			boolean has = false;
			currIndex--;
			if ( currIndex >= 0 ) {
				if ( lowerBoundEnabled ) {
					if ( lowerBoundInclusive )
						has = column.values[column.indices[currIndex]].compareTo(lowerBound) >= 0;
					else
						has = column.values[column.indices[currIndex]].compareTo(lowerBound) > 0;
				} else
					has = true;
			}
			if ( !has )
				currIndex = startIndex;
			return has;
		}

		public final int getNextIndex ( ) {
			return column.indices[currIndex];
		}

	}

}

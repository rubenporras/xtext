/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * Represents a range in a stream of characters.
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ITextRegion {
	int getOffset();

	int getLength();

	/**
	 * @since 2.41
	 */
	default int getEndOffset() {
		return getOffset() + getLength();
	};

	ITextRegion merge(ITextRegion region);
	
	boolean contains(ITextRegion other);
	
	boolean contains(int offset);

	static ITextRegion EMPTY_REGION = new ITextRegion() {
		@Override
		public int getOffset() {
			return 0;
		}

		@Override
		public int getLength() {
			return 0;
		}

		@Override
		public ITextRegion merge(ITextRegion region) {
			return region;
		}

		@Override
		public boolean contains(ITextRegion other) {
			return false;
		}

		@Override
		public boolean contains(int offset) {
			return false;
		}
	};
}

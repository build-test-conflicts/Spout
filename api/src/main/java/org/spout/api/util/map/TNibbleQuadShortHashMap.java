/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011 Spout LLC <http://www.spout.org/>
 * Spout is licensed under the Spout License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spout is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.util.map;

import gnu.trove.TShortCollection;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.map.TShortShortMap;
import gnu.trove.map.hash.TShortShortHashMap;
import gnu.trove.set.TShortSet;

import org.spout.api.util.hashing.NibbleQuadHashed;

/**
 * A simplistic map that supports a 4 nibbles (4 bits) for keys, using a trove short short hashmap in the backend.
 */
public class TNibbleQuadShortHashMap {
	protected final TShortShortMap map;

	public TNibbleQuadShortHashMap() {
		map = new TShortShortHashMap(100);
	}

	public TNibbleQuadShortHashMap(int capacity) {
		map = new TShortShortHashMap(capacity);
	}

	public TNibbleQuadShortHashMap(TShortShortMap map) {
		this.map = map;
	}

	public short put(int key1, int key2, int key3, int key4, short value) {
		return map.put(NibbleQuadHashed.key(key1, key2, key3, key4), value);
	}

	public short get(int key1, int key2, int key3, int key4) {
		return map.get(NibbleQuadHashed.key(key1, key2, key3, key4));
	}

	public boolean containsKey(int key1, int key2, int key3, int key4) {
		return map.containsKey(NibbleQuadHashed.key(key1, key2, key3, key4));
	}

	public void clear() {
		map.clear();
	}

	public boolean containsValue(short val) {
		return map.containsValue(val);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public TShortShortIterator iterator() {
		return map.iterator();
	}

	public TShortSet keySet() {
		return map.keySet();
	}

	public short[] keys() {
		return map.keys();
	}

	public short remove(int key1, int key2, int key3, int key4) {
		return map.remove(NibbleQuadHashed.key(key1, key2, key3, key4));
	}

	public int size() {
		return map.size();
	}

	public TShortCollection valueCollection() {
		return map.valueCollection();
	}

	public short[] values() {
		return map.values();
	}
}

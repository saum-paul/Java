package org.smacknologs.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class UnsortedArrayTest {

	@Test
	void testSizeEmpty() {
		UnsortedArray<String> array = new UnsortedArray<>();
		assertEquals(0, array.size(), "IDK");
	}

	@Test
	void testAddStrings() {
		UnsortedArray<String> array = new UnsortedArray<>();
		array.add("");
		
	}

	@Test
	void testAddKeyData() {
		UnsortedArray<String> array = new UnsortedArray<>();
		array.add("");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFind() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	class TestIntegerObject implements Comparable<TestIntegerObject> {
		int key;
		int data;

		@Override
		public int compareTo(TestIntegerObject o) {
			if (key == o.key)
				return 0;
			else if (key < o.key)
				return -1;
			else
				return 1;
		}
	}
}

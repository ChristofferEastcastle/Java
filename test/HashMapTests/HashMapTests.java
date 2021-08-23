package HashMapTests;// The following code is a series of SortingAlgos.test that were written in the order you'll read them. After
// each SortingAlgos.test was written it was run against the DataStructures.DataStructures.HashMap and the implementation was updated if it
// failed. The DataStructures.DataStructures.HashMap code is the final implementation that was built naively to pass each SortingAlgos.test.

// The Tests:

import DataStructures.HashMap.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTests {
    private HashMap map;
  
    // Set up an empty map before each SortingAlgos.test
    @BeforeEach
    public void setUp() {
        this.map = new HashMap();
    }

    // Check that a new DataStructures.DataStructures.HashMap returns 'true' for isEmpty
    @Test
    public void testIsEmptyForNewMap() {
        assertTrue(map.isEmpty());
    } 
    
    // Test adding an element makes isEmpty return 'false'
    @Test
    public void testAddMakesIsEmptyFalse() {
        map.put("Hello", 5);
        assertFalse(map.isEmpty());
    }
    
    // Check that size returns 0 for new HashMaps
    @Test
    public void testSizeForNewMap() {
        assertEquals(0, map.size());
    }
    
    // Test size increases as elements are added
    @Test
    public void testSizeIncrementsWhenAddingElements() {
        map.put("Hello", 5);
        assertEquals(1, map.size());
        
        map.put("Goodbye", 5);
        assertEquals(2, map.size());
    }
    
    // Make sure get returns the values added under keys
    @Test
    public void testGetReturnsCorrectValue() throws Exception {
        map.put("Hello", 5);
        map.put("Goodbye", 6);
        assertEquals(5, map.get("Hello"));
        assertEquals(6, map.get("Goodbye"));
    }
    
    // Test that an exception is thrown if a key does not exist
    @Test
    public void testThrowsExceptionIfKeyDoesNotExist() {
        assertThrows(NoSuchElementException.class, () -> map.get("Hello"));
    }

    // Test thats an added element replaces another with the same key
    @Test
    public void testReplacesValueWithSameKey() {
        map.put("Hello", 5);
        map.put("Hello", 6);
        
        assertEquals(6, map.get("Hello"));
    }
    
    // Make sure that two (non-equal) keys with the same hash do not overwrite each other
    @Test
    public void testDoesNotOverwriteSeparateKeysWithSameHash() {
        map.put("Ea", 5);
        map.put("FB", 6);
        
        assertEquals(5, map.get("Ea"));
        assertEquals(6, map.get("FB"));
    }
    
    // Make sure size doesn't decrement below 0
    @Test
    public void testRemoveDoesNotEffectNewMap() {
        map.remove("Hello");

        assertEquals(0, map.size());
    }
    
    // Make sure that size decrements as elements are used
    @Test
    public void testRemoveDecrementsSize() {
        map.put("Hello", 5);
        map.put("Goodbye", 6);
        
        map.remove("Hello");
        
        assertEquals(1, map.size());
        
        map.remove("Goodbye");
        
        assertEquals(0, map.size());
    }

    // Test elements are actually removed when remove is called
    @Test
    public void testRemoveDeletesElement() {
        map.put("Hello", 5);
        map.remove("Hello");
        
        assertThrows(NoSuchElementException.class, () -> map.get("Hello"));
    }
    
    // Test that contains is 'false' for new maps
    @Test
    public void testContainsKeyForNewMap() {
        assertFalse(map.containsKey("Hello"));
    }
    
    // Test that contains returns 'false' when key doesn't exist
    @Test
    public void testContainsKeyForNonExistingKey() {
        map.put("Hello", 5);
        assertFalse(map.containsKey("Goodbye"));
    }

    // Make sure that contains returns 'true' when the key does exist
    @Test
    public void testContainsKeyForExistingKey() {
        map.put("Hello", 5);
        assertTrue(map.containsKey("Hello"));
    }
    
    // Check that contains is not fooled by equivalent hash codes
    @Test
    public void testContainsKeyForKeyWithEquivalentHash() {
        map.put("Ea", 5);
        
        assertFalse(map.containsKey("FB"));
    }
}

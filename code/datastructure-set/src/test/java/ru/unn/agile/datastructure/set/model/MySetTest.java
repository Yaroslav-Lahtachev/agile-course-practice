package ru.unn.agile.datastructure.set.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySetTest {
    @Test
    public void canInitDefaultConstructor() {
        MySet mySet = new MySet();
        Assert.assertNotNull(mySet);
    }

    @Test
    public void canInitWithSpecificType() {
        MySet<String> mySet = new MySet<>();
        Assert.assertNotNull(mySet);
    }

    @Test
    public void canGetZeroSize() {
        MySet mySet = new MySet();
        Assert.assertEquals(0, mySet.size());
    }

    @Test
    public void canAddElement() {
        MySet<String> mySet = new MySet<>();
        Assert.assertTrue(mySet.add("test"));
    }

    @Test
    public void canGetRealSize() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        Assert.assertEquals(2, mySet.size());
    }

    @Test
    public void canCheckEmpty() {
        MySet mySet = new MySet();
        Assert.assertTrue(mySet.isEmpty());
    }

    @Test
    public void canCheckNotEmpty() {
        MySet<String> mySet = new MySet<>();
        mySet.add("test value");
        Assert.assertFalse(mySet.isEmpty());
    }

    @Test
    public void canBeCleared() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.clear();
        Assert.assertTrue(mySet.isEmpty());
    }

    @Test
    public void canConvertToArray() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add("second");
        Assert.assertArrayEquals(new String[]{"first", "second"}, mySet.toArray());
    }

    @Test
    public void canNotAddDuplicateElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add("first");
        Assert.assertEquals(1, mySet.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotAddNull() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add(null);
    }

    @Test
    public void canCheckExistingElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        mySet.add("fourth row");
        Assert.assertTrue(mySet.contains("third row"));
    }

    @Test(expected = NullPointerException.class)
    public void canNotCheckExistingNull() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.contains(null);
    }

    @Test
    public void canRemoveElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        mySet.remove("second row");
        Assert.assertEquals(2, mySet.size());
    }

    @Test(expected = NullPointerException.class)
    public void canNotRemoveNullElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.remove(null);
    }

    @Test
    public void canGiveIterator() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        Iterator<String> iterator = mySet.iterator();
        Assert.assertNotNull(iterator);
    }

    @Test
    public void canIterateByIterator() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        Iterator<String> iterator = mySet.iterator();
        boolean foundValue = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals("second row")) {
                foundValue = true;
            }
        }

        Assert.assertTrue(foundValue);
    }

    @Test
    public void canRemoveByIterator() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        Iterator<Integer> iterator = mySet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(2)) {
                iterator.remove();
            }
        }

        Assert.assertEquals(2, mySet.size());
    }

    @Test
    public void canCheckExistingCollection() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        Set<String> testSet = new HashSet<>();
        testSet.add("first row");
        testSet.add("second row");
        Assert.assertTrue(mySet.containsAll(testSet));
    }

    @Test(expected = NullPointerException.class)
    public void canNotCheckExistingCollectionWithNull() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(null);
        mySet.containsAll(testSet);
    }

    @Test
    public void canRemoveCollectionsIntersection() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        Set<String> testSet = new HashSet<>();
        testSet.add("first row");
        Assert.assertTrue(mySet.removeAll(testSet));
    }

    @Test(expected = NullPointerException.class)
    public void canNotRemoveNullCollection() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.removeAll(null);
    }

    @Test
    public void canUnionCollections() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        Set<String> testSet = new HashSet<>();
        testSet.add("second");
        Assert.assertTrue(mySet.addAll(testSet));
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotUnionCollectionWithNull() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        Set<String> testSet = new HashSet<>();
        testSet.add("second");
        testSet.add(null);
        mySet.addAll(testSet);
    }

    @Test
    public void canRetainCollections() {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        mySet.retainAll(testSet);
        Assert.assertEquals(1, mySet.size());
    }

    @Test(expected = NullPointerException.class)
    public void canNotRetainWithNullCollections() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.retainAll(null);
    }
}

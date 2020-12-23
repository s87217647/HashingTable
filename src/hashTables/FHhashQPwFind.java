package hashTables;

import cs1c.FHhashQP;
import cs1c.HashEntry;

import java.util.NoSuchElementException;

public class FHhashQPwFind<KeyType, E extends Comparable<KeyType>>
        extends FHhashQP<E> {

    /***
     *
     * @param key
     * @return If the hashtable contains the element using key
     */
    public boolean contain(KeyType key) {
        return mArray[findPosKey(key)].state == ACTIVE;
    }


    /**
     * Finding the element using key, if not throw exception
     * @param key the key
     * @return Founded element
     */
    public E find(KeyType key) {
        HashEntry<E> target = mArray[findPosKey(key)];

        if (target.state != ACTIVE)
            throw new NoSuchElementException();

        return target.data;
    }


    /**
     * @param key the key
     * @return hashVal hash value
     */
    protected int myHashKey(KeyType key) {
        int hashVal;

        hashVal = key.hashCode() % mTableSize;
        if (hashVal < 0)
            hashVal += mTableSize;

        return hashVal;
    }

    /**
     * @param key the key
     * @return the index of desired element
     */
    protected int findPosKey(KeyType key) {

        int kthOddNum = 1;
        int index = myHashKey(key);

        while (mArray[index].state != EMPTY
                && !(mArray[index].data.compareTo(key) == 0)) {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2;     // compute next odd #
            if (index >= mTableSize)
                index -= mTableSize;
        }
        return index;
    }
}
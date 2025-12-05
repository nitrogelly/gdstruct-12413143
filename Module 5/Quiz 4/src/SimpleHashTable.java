import java.util.NoSuchElementException;

public class SimpleHashTable {

    private StoredPlayer[] hashTable;

    public SimpleHashTable() {
        hashTable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    private boolean isOccupied(int index) {
        return hashTable[index] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stopIndex = hashedKey;
            hashedKey = (hashedKey + 1) % hashTable.length;

            while (hashedKey != stopIndex && isOccupied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if (!isOccupied(hashedKey)) {
            hashTable[hashedKey] = new StoredPlayer(key, value);
        } else {
            System.out.println("No available space for key: " + key);
        }
    }

    public Player get(String key) {
        int index = findKey(key);
        if (index == -1) return null;
        return hashTable[index].value;
    }

    // ⭐ QUIZ 4 REQUIRED FUNCTION
    public Player remove(String key) {

        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        Player removedPlayer = hashTable[hashedKey].value;
        hashTable[hashedKey] = null;

        // Rebuild entire table to fix probing chain
        StoredPlayer[] oldTable = hashTable;
        hashTable = new StoredPlayer[oldTable.length];

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }

        return removedPlayer;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashTable[hashedKey] != null &&
                hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashTable.length;

        while (hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                !hashTable[hashedKey].key.equals(key)) {

            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if (hashTable[hashedKey] != null &&
                hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                System.out.println("Element " + i + ": empty");
            } else {
                System.out.println("Element " + i + ": " + hashTable[i].value);
            }
        }
    }
}

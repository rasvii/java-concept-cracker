package src.main.dsa.datastructure.trie;

import java.util.Objects;

public class Items implements Comparable<Items>{
    
    int key;
    int count;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Items(int key, int count) {
        this.key = key;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return getKey() == items.getKey() && getCount() == items.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getCount());
    }

    @Override
    public int compareTo(Items o) {
        return Integer.compare(getCount(), o.getCount());
    }
}

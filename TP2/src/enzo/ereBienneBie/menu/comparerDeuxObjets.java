package enzo.ereBienneBie.menu;


public class comparerDeuxObjets <T extends Comparable<T>> {
    private T obj1;
    private T obj2;

    public comparerDeuxObjets(T obj1, T obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getHigher() {
        if(obj1.compareTo(obj2)>0)
            return obj1;
        return obj2;
    }

    public T getLower() {
        if(obj1.compareTo(obj2)>0)
            return obj2;
        return obj1;
    }


    public boolean comparer(T obj1, T obj2) {
        if(obj1.equals(obj2))
            return true;
        return  false;
    }
}

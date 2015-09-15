import java.util.List;

public class ListUtils<T> {

    public Boolean containsAny(List<T> container, List<T> candidates){
        for(T elem : candidates){
            if(container.contains(elem)) { return true; }
        }
        return false;
    }
}

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> S;

    public NestedIterator(List<NestedInteger> nestedList) {
        S = new Stack<>();
        // Push elements in reverse order
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            S.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return S.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!S.isEmpty()) {
            NestedInteger current = S.peek();
            if (current.isInteger()) {
                return true;
            }
            S.pop();
            List<NestedInteger> l = current.getList();
            // Push elements in reverse order
            for (int i = l.size() - 1; i >= 0; i--) {
                S.push(l.get(i));
            }
        }
        return false;
    }
}

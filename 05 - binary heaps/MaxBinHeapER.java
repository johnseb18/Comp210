package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V, P>> _heap;

    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    public MaxBinHeapER(Prioritized<V, P>[] initialEntries) {
        _heap = new ArrayList<>();
        _heap.addAll(Arrays.asList(initialEntries));
        moveUp(_heap.size()-1);
        }

    @Override
    public int size() {
        return _heap.size();
    }


    @Override
    public void enqueue(V value, P priority) {
        Patient<V, P> pE = new Patient<>(value, priority);
        _heap.add(pE);
        bubbleUp(_heap.size() - 1);
    }


    public void enqueue(V value) {
        Patient<V, P> patient = new Patient<>(value);
        _heap.add(patient);
        bubbleUp(_heap.size() - 1);
    }

    @Override
    public V dequeue() {
        if (_heap.isEmpty()) {
            return null;
        }


        Prioritized<V, P> root = _heap.get(0);

        int lastElementIndex = _heap.size() - 1;
        Prioritized<V, P> lastElement = _heap.get(lastElementIndex);

        _heap.set(0, lastElement);
        _heap.set(lastElementIndex, root);

        _heap.remove(lastElementIndex);

        if (!_heap.isEmpty()) {
            bubbleDown(0);
        }

        return root.getValue();
    }


    @Override
    public V getMax() {
        if (_heap.isEmpty()) {
            return null;
        }
        return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V, P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }




    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    static int parentInd(int index) {
        return ((index - 1) / 2);
    }

    private void bubbleUp(int index) {
        while (index != 0) {
            int parentIndex = parentInd(index);
            Prioritized<V, P> child = _heap.get(index);
            Prioritized<V, P> parent = _heap.get(parentIndex);

            if (child.getPriority().compareTo(parent.getPriority()) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    private void moveUp(int index) {
        Prioritized<V, P> child = _heap.get(index);
        Prioritized<V, P> parent = _heap.get(parentInd(index));
        if (child.getPriority().compareTo(parent.getPriority()) > 0) {
            _heap.set(parentInd(index), child);
            _heap.set(index, parent);
            moveUp(parentInd(index));
        }
    }

    private void swap(int indexOne, int indexTwo) {
        Prioritized<V, P> temp = _heap.get(indexOne);
        _heap.set(indexOne, _heap.get(indexTwo));
        _heap.set(indexTwo, temp);
    }

    private void bubbleDown(int index) {
        int largest = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex < _heap.size() && _heap.get(leftChildIndex).getPriority().compareTo(_heap.get(largest).getPriority()) > 0) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < _heap.size() && _heap.get(rightChildIndex).getPriority().compareTo(_heap.get(largest).getPriority()) > 0) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            bubbleDown(largest);
        }
    }

}

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class implements a generic array-based heap data structure that
 * stores elements of type E in an ArrayList.
 * @param <E> the type of elements stored in the heap, must implement Comparable
 */
public class ArrayHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> heap; //Internal ArrayList storage for the heap elements

    /**
     * Constructor that initializes an empty heap using an ArrayList.
     */
    public ArrayHeap() {
        heap = new ArrayList<>(); // Initialize an empty ArrayList to represent the heap
    }

    /**
     Returns the number of elements in the heap.
     @return The size of the heap.
     */
    @Override
    public int size() {
        return heap.size(); // Return the size of the heap (number of elements)
    }
    /**
     Checks if the heap is empty.
     @return True if the heap has no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty(); // Check if the heap is empty (has no elements)
    }

    /**
     Returns the maximum element in the heap (root of the max heap).
     Throws an exception if the heap is empty.
     @return The maximum element in the heap.
     @throws IllegalStateException If the heap is empty.
     */

    @Override
    public E max() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty"); // Throw an exception if the heap is empty
        }
        return heap.get(0); // Return the maximum element in the heap (root of the max heap)
    }

    /**
     Inserts an element into the heap and performs the necessary bubble up operation to maintain the heap property.
     @param element The element to insert into the heap.
     */
    public void insert(E element) {
        heap.add(element); // Add the element to the end of the ArrayList (last leaf in the binary tree)
        bubbleUp(heap.size() - 1); // Perform bubble up operation starting from the last leaf
    }

    /**
     Removes and returns the maximum element in the heap (root of the heap).
     Throws an exception if the heap is empty.
     Performs the necessary bubble down operation to maintain the heap property.
     @return The maximum element in the heap.
     @throws IllegalStateException If the heap is empty.
     */
    @Override
    public E removeMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty"); // Throw an exception if the heap is empty
        }
        E max = heap.get(0); // Get the maximum element (root of the heap)
        heap.set(0, heap.get(heap.size() - 1)); // Replace the root with the last element in the heap
        heap.remove(heap.size() - 1); // Remove the last element (previously the root) from the heap
        bubbleDown(0); // Perform bubble down operation starting from the root
        return max; // Return the maximum element that was removed from the heap
    }


    /**
     * Swaps the elements at the specified indices in the heap.
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j) {
        E temp = heap.get(i); // Store the element at index 'i' in a temporary variable
        heap.set(i, heap.get(j)); // Set the element at index 'i' to the element at index 'j'
        heap.set(j, temp); // Set the element at index 'j' to the temporary variable
    }

    /**
     * Returns the index of the parent of the element at the specified index.
     * @param i the index of the element
     * @return the index of the parent of the element
     */
    private int parent(int i) {
        return (i - 1) / 2; // The parent of an element at index 'i' is at index '(i - 1) / 2' in a binary heap
    }

    /**
     * Returns the index of the left child of the element at the specified index.
     * @param i the index of the element
     * @return the index of the left child of the element
     */
    private int leftChild(int i) {
        return 2 * i + 1; // The left child of an element at index 'i' is at index '2 * i + 1' in a binary heap
    }

    /**
     * Returns the index of the right child of the element at the specified index.
     * @param i the index of the element
     * @return the index of the right child of the element
     */
    private int rightChild(int i) {
        return 2 * i + 2; // The right child of an element at index 'i' is at index '2 * i + 2' in a binary heap
    }

    /**
     * Performs a bubble up operation starting from the specified index to maintain
     * the max heap property.
     * @param i the index to start the bubble up operation from
     */
    private void bubbleUp(int i) {
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) > 0) {
            swap(i, parent(i)); // Swap the element with its parent if it's larger
            i = parent(i); // Update the index to be the parent's index
        }
    }

    /**
     * Performs a bubble down operation starting from the specified index to maintain
     * the max heap property.
     * @param i the index to start the bubble down operation from
     */
    private void bubbleDown(int i) {
        int maxIndex = i; // Initialize the index of the element to compare with as 'i'
        int left = leftChild(i); // Get the index of the left child of the element
        int right = rightChild(i); // Get the index of the right child of the element

        // Compare the element with its left child (if present) and update 'maxIndex' if necessary
        if (left < heap.size() && heap.get(left).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = left;
        }

        // Compare the element with its right child (if present) and update 'maxIndex' if necessary
        if (right < heap.size() && heap.get(right).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = right;
        }

        // If 'maxIndex' is not equal to 'i', then swap the elements at 'i' and 'maxIndex',
        // and recursively perform the bubble-down operation on 'maxIndex'
        if (maxIndex != i) {
            swap(i, maxIndex);
            bubbleDown(maxIndex);
        }
    }

    /**
     * Builds a max heap from the given ArrayList of elements.
     * @param array the ArrayList of elements to build the max heap from
     */
    public void buildMaxHeap(ArrayList<E> array) {
        // Set the heap to the input array
        heap = array;
        // Start from the middle of the heap and perform a bubble-down operation for each element
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    /**
     * Sorts the elements in the input ArrayList in descending order using a max heap.
     * The input ArrayList is modified in place.
     * @param array The ArrayList to be sorted
     * @return The sorted ArrayList in descending order
     * @throws IllegalStateException If the heap is empty
     * @throws ClassCastException If the elements in the ArrayList are not comparable
     */
    public ArrayList<E> sort(ArrayList<E> array) {
        buildMaxHeap(array); // Builds a max heap from the input array
        ArrayList<E> sortedArray = new ArrayList<>(); // Creates a new ArrayList to store sorted elements
        while (!isEmpty()) { // While the heap is not empty
            sortedArray.add(removeMax()); // Removes the maximum element from the heap and adds it to the sortedArray
        }
        return sortedArray; // Returns the sortedArray
    }
    /**
     * Returns a string representation of the binary heap in a tree-like format.
     * @return A string representation of the binary heap in a tree-like format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int levelSize = 1; // Keeps track of the number of elements at the current level of the heap
        int count = 0; // Keeps track of the number of elements processed so far
        for (E element : heap) { // Iterates through the elements in the heap
            sb.append(element).append(" "); // Appends the element and a space to the StringBuilder
            count++;
            if (count == levelSize) { // If the count reaches the level size, a new level is reached
                sb.append("\n"); // Appends a new line character to the StringBuilder to start a new line for the next level
                levelSize *= 2; // Updates the level size to be twice the previous value (since it's a binary heap)
                count = 0; // Resets the count for the new level
            }
        }
        return sb.toString(); // Returns the string representation of the heap
    }

}

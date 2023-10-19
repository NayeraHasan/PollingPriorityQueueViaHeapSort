# PollingPriorityQueueViaHeapSort
# Priority Queues and Heapsort with Polling Data

This repository contains a Java-based implementation for processing Democratic primary polling data sing principles of Object-Oriented Programming (OOP). The main objective is to utilize a heap to sort the candidates based on their polling numbers, thereby determining the leading candidates. Additionally, a Priority Queue is implemented.

## Table of Contents

- [Overview](#overview)
- [Classes](#classes)
  - [CSVReader Class](#csvreader-class)
  - [Candidate Class](#candidate-class)
  - [Main Class](#main-class)
  - [PriorityQueue Interface](#priorityqueue-interface)
  - [ArrayHeap Class](#arrayheap-class)

## Overview
The project focuses on:
- Reading CSV files containing polling data for presidential primary candidates.
- Sorting candidates using a heap data structure.
- Implementing a Priority Queue for managing the candidates.
  
## Classes

### CSVReader Class

- **Functionality**: Reads data from a CSV file and returns it as an `ArrayList` of `String` arrays.
- **Methods**:
  - `read(FileReader csvFile)`: Reads the CSV file and returns an ArrayList of String arrays.
  - Uses a `BufferedReader` to read the file line by line.
  - - Provides a method to close the `BufferedReader`, `close()`.

### Candidate Class


- **Attributes**: Contains last name, full name, and percentage of each candidate.
- **Methods**:
  - Provides getter and setter methods for its attributes.
    - `getLastName()`: Returns the candidate's last name.
    - `getFullName()`: Returns the candidate's full name.
    - `getPct()`: Returns the candidate's percentage score.
    - `setPct(double pct)`: Sets the candidate's percentage score.
  -  Implements the `Comparable` interface to compare candidates based on their percentage and in case of a tie, the candidate’s last     
     names are used. - `compareTo(Candidate other)`
  - `toString()`: Returns a string representation of the candidate.

### Main Class

- **Functionality**:
    - Reads candidate data from CSV files specified in the command-line arguments.
    - Adds candidates to a priority queue (`ArrayHeap`) based on their percentage.
    - Prints the candidates in sorted order.
    - Demonstrates sorting an array of integers and characters using the `ArrayHeap`.
- **Methods**:
  - `main(String[] args)`: Main method to run the program.
   
### PriorityQueue Interface
Defines the basic operations for the priority queue
- **Methods**:
  - `insert(E element)`: Inserts an element into the priority queue.
  - `max()`: Returns the maximum element in the priority queue.
  - `removeMax()`: Removes and returns the maximum element in the priority queue.
  - `size()`: Returns the number of elements in the priority queue.
  - `isEmpty()`: Checks if the priority queue is empty.

### ArrayHeap Class

- **Attributes**:  Contains a single instance variable, an ArrayList representing the heap.
- **Constructor**: `ArrayHeap()`: Initializes an empty priority queue/heap.
- **Functionality**:
    - Represents a max heap using an `ArrayList`.
    - Implements the `PriorityQueue` interface.
    - Provides methods for heap operations: `insert`, `max`, `removeMax`, `bubbleUp`, `bubbleDown`, and `swap`.
    - Provides methods for heap construction and sorting: `buildMaxHeap` and `sort`.
    - Overrides the `toString` method to print the heap in a tree-like format.
- **Methods**
  1. `size()`: Returns the number of elements in the heap.
  2. `isEmpty()`: Checks if the heap is empty and returns a boolean value.
  3. `max()`: Returns the maximum element in the heap without removing it.
  4. `insert(E element)`: Inserts an element into the heap while maintaining the heap property.
  5. `removeMax()`: Removes and returns the maximum element in the heap, reorganizing the heap as necessary.
- **Helper Methods**:
  1. `swap(int i, int j)`: Swaps the elements at the specified indices in the heap.
  2. `parent(int i)`: Returns the index of the parent of the element at the specified index.
  3. `leftChild(int i)`: Returns the index of the left child of the element at the specified index.
  4. `rightChild(int i)`: Returns the index of the right child of the element at the specified index.
  5. `bubbleUp(int i)`: Adjusts the position of an element in the heap by moving it upwards until the heap property is restored.
  
- **Heapsort Related Methods**:
  1. `buildMaxHeap(ArrayList<E> array)`: Converts the given ArrayList into a max heap structure.
  2. `sort(ArrayList<E> array)`: Uses the heap structure to sort the elements in the ArrayList in descending order.
  
- **Override**:
  1. `toString()`: Returns a string representation of the heap, displaying the elements in a structured format.

package my;

import java.util.NoSuchElementException;

/**
 * Singly Linked-list (generic)
 */
public class MyLinkedList<E> {

  private Node<E> head, tail; // null
  private int size; // 0

  public MyLinkedList() { }

  // O(1)
  public void addFirst(E e) {
    final Node<E> h = head;
    final Node<E> newNode = new Node<>(e, h);
    head = newNode;
    if (h == null) {
      // adding a new node to the empty linked list
      tail = newNode;
    }
    size++;
  }

  // O(1)
  public void addLast(E e) {
    final Node<E> t = tail;
    final Node<E> newNode = new Node<>(e, null);
    tail = newNode;
    if (t == null) {
      head = newNode;
    } else {
      t.next = newNode;
    }
    size++;
  }

  // O(N)
  public void add(int index, E e) {
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    if (index == 0) {
      addFirst(e);
    } else if (index == size) {
      addLast(e);
    } else {
      Node<E> cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      cur.next = new Node<>(e, cur.next);
      size++;
    }
  }

  // O(1)
  public E removeFirst() {
    final Node<E> h = head;
    if (h == null) {
      throw new NoSuchElementException("list is empty");
    }

    E data = h.data;
    Node<E> next = h.next;
    h.data = null;
    h.next = null;
    head = next;
    if (next == null) {
      // only one element in the list
      tail = null;
    }
    size--;
    return data;
  }

  /**
   * O(N)
   * This method can be improved by using Doubly-Linked List. O(1)
   * (Doubly-Linked List has `prev` pointer.)
   * ex) tail.prev (second last node)
   */
  public E removeLast() {
    final Node<E> t = tail;
    if (t == null) {
      throw new NoSuchElementException("list is empty");
    }

    E data = t.data;
    Node<E> prev = null;
    Node<E> cur = head;
    while (cur != t) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = null;
    t.data = null;
    t.next = null;
    tail = prev;
    size--;
    return data;
  }

  // O(1)
  public E getFirst() {
    if (head == null) {
      throw new NoSuchElementException("list is empty");
    }
    return head.data;
  }

  // O(1)
  public E getLast() {
    if (tail == null) {
      throw new NoSuchElementException("list is empty");
    }
    return tail.data;
  }

  private Node<E> getNodeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    Node<E> cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur;
  }

  // O(N)
  public E get(int index) {
    return getNodeAt(index).data;
  }

  // O(N)
  public E set(int index, E e) {
    Node<E> cur = getNodeAt(index);
    E oldValue = cur.data;
    cur.data = e;
    return oldValue;
  }

  // O(N)
  public int indexOf(E e) {
    int index = 0;
    if (e == null) {
      for (Node<E> x = head; x != null; x = x.next) {
        if (x.data == null) {
          return index;
        }
        index++;
      }
    } else {
      for (Node<E> x = head; x != null; x = x.next) {
        if (e.equals(x.data)) {
          return index;
        }
        index++;
      }
    }
    return -1;
  }

  /**
   * Remove the element e from the list
   * @param e
   * @return
   */
  public boolean remove(E e) {
    if (e == null) {
      for (Node<E> x = head; x != null; x = x.next) {
        if (x.data == null) {
          x.data = null;
          size--;
          return true;
        }
      }
    } else {
      for (Node<E> x = head; x != null; x = x.next) {
        if (e.equals(x.data)) {
          x.data = null;
          size--;
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Remove the element at index
   * O(N)
   * @param index
   * @return
   */
  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    if (index == 0) {
      removeFirst();
    } else if (index == size - 1) {
      removeLast();
    } else {
      Node<E> cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      Node<E> next = cur.next.next;
      cur.next = next;
      size--;
    }
    return true;
  }


  /**
   * Returns the index of the last occurrence of element e
   * O(N)
   *
   * ll = [1, 1, 2, 3, 1, 5, 1, 2]
   * ll.lastIndexOf(1) -> 6
   * @param e
   * @return the index of the last occurrence of element e
   */
  public int lastIndexOf(E e) {
    if (e == null) {
      for (int i = size - 1; i >= 0; i--) {
        if (get(i) == null) {
          return i;
        }
      }
    } else {
      for (int i = size - 1; i >= 0; i--) {
        if (e.equals(get(i))) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Reverses the current linked list
   * "A" -> "B" -> "C" -> null
   * should be
   * "C" -> "B" -> "A" -> null
   */
  public void reverse() {
    if (size == 0 || size == 1) {
      return;
    }

    Node<E> prev = null;
    Node<E> cur = head;
    Node<E> next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    head = prev;
  }

  // O(N)
  public boolean contains(E e) {
    return indexOf(e) >= 0;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Node<E> x = head; x != null; x = x.next) {
      s.append(x.data).append(" -> ");
    }
    s.append("null");
    return s.toString();
  }

  public int size() {
    return size;
  }

  // static nested class
  public static class Node<E> {
    E data;
    Node<E> next;

    public Node(E item, Node<E> next) {
      this.data = item;
      this.next = next;
    }
  }
}


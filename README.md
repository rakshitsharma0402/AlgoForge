# AlgoForge

A Java data structures & algorithms library, built from scratch and modeled after `java.util` — designed to be imported and used the way you'd use any standard Java collection.

AlgoForge is both a learning project and a portfolio piece: every data structure and algorithm is implemented by hand (no wrapping `java.util` internally) to build a solid, from-first-principles understanding of how these structures actually work under the hood.

## Why this project exists

Most DSA practice lives in disconnected LeetCode-style solutions. AlgoForge is an attempt to go further — to build a cohesive, reusable, well-designed **library**, complete with:
- Clean public APIs consumers can actually import and use
- Consistent design conventions across every structure (naming, exception handling, indexing)
- Proper testing and documentation, not just working code

## Status

This project is under active development. Structures are built one at a time, alongside ongoing DSA study.

| Structure | Status |
|---|---|
| `SinglyLinkedList` | ✅ Complete |
| `DoublyLinkedList` | 🚧 In progress |
| `CircularLinkedList` | ⏳ Planned |
| Stack (array & linked) | ⏳ Planned |
| Queue (array, circular, deque, priority) | ⏳ Planned |
| Tree (Binary Tree, BST, AVL) | ⏳ Planned |
| Heap (Min/Max) | ⏳ Planned |
| HashMap | ⏳ Planned |
| Graph (+ BFS, DFS, Dijkstra, Union-Find) | ⏳ Planned |
| Sorting algorithms | ⏳ Planned |
| Searching algorithms | ⏳ Planned |

## Project structure

```
algoforge/
├── src/
│   ├── main/java/org/algoforge/
│   │   ├── datastructures/
│   │   │   ├── list/          # SinglyLinkedList, DoublyLinkedList, CircularLinkedList
│   │   │   ├── stack/
│   │   │   ├── queue/
│   │   │   ├── tree/
│   │   │   ├── heap/
│   │   │   └── hashmap/
│   │   ├── algorithms/
│   │   │   ├── sorting/
│   │   │   ├── searching/
│   │   │   ├── recursion/
│   │   │   └── graph/
│   │   └── common/            # shared interfaces, exceptions (as needed)
│   └── test/java/org/algoforge/
│       └── ...                # mirrors main/ package-for-package
├── pom.xml
└── README.md
```

**Design principles:**
- `datastructures/` and `algorithms/` are kept separate — algorithms like sorting/searching aren't tied to one specific structure and should be reusable across them, similar to how `java.util.Collections` operates on `java.util.List` rather than sorting logic living inside `LinkedList` itself.
- Class names (`LinkedList`, `Stack`, `Queue`, etc.) intentionally match common Java naming — consumers fully-qualify or import as needed, same as working with any two libraries that share type names.
- Each structure currently uses `Object`-based storage (generics not yet introduced) and throws standard Java exceptions (`IndexOutOfBoundsException` for invalid positions, `NoSuchElementException` for operations on empty structures) to feel idiomatic to Java developers from the start.

## Tech stack

- **Language:** Java 23
- **Build tool:** Maven
- **Testing:** JUnit 5
- **IDE:** IntelliJ IDEA
- **Version control:** Git

## Getting started

Clone the repo and build with Maven:

```bash
git clone https://github.com/rakshitsharma0402/algoforge.git
cd algoforge
mvn clean install
```

## Usage example

```java
import org.algoforge.datastructures.list.SinglyLinkedList;

SinglyLinkedList list = new SinglyLinkedList();
list.insertAtBeginning("C");
list.insertAtBeginning("B");
list.insertAtBeginning("A");
list.insertAtEnd("D");

System.out.println(list);        // A -> B -> C -> D -> null
System.out.println(list.get(2)); // C
System.out.println(list.size()); // 4
```

## Roadmap

- [x] `SinglyLinkedList` — insert/delete (beginning, end, index), get, size, toString
- [ ] `DoublyLinkedList` — bidirectional traversal, optimized index access from nearest end
- [ ] `CircularLinkedList`
- [ ] Stack & Queue variants
- [ ] Trees, Heaps, HashMap
- [ ] Graph structures & algorithms
- [ ] Sorting & searching algorithms
- [ ] Unit test coverage across all structures
- [ ] Shared `List` interface (once multiple list implementations exist to generalize from)
- [ ] Generics support (`<T>`) across the library

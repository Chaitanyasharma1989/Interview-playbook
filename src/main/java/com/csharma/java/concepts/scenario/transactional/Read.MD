Implement a Thread-Safe In-Memory Transactional CRUD Repository with Nested Transaction Support and Optimistic Locking

⸻

Problem Description:

You are tasked with designing and implementing an in-memory data repository in Java that manages entities (e.g., User objects) and supports the following features:
1.	CRUD Operations:
•	Create, Read, Update, and Delete operations on entities stored in memory (using Java Collections, no external database).
2.	Optimistic Locking:
•	Updates should only succeed if the entity’s version matches the expected version provided by the caller, to avoid lost updates in concurrent scenarios.
3.	Transaction Support:
•	All CRUD operations must be executed within an explicit transaction boundary, defined by beginTransaction(), commit(), and rollback() methods.
•	The system should maintain atomicity of operations: on rollback, all changes made during the transaction are undone.
4.	Write-Ahead Logging (WAL) for Rollback:
•	Implement a WAL mechanism to record operations and enable rollback by applying inverse operations in last-in-first-out (LIFO) order.
•	The WAL should be implemented using appropriate data structures (e.g., a stack/Deque).
5.	Thread-Safety:
•	The repository should be safe to use in a multi-threaded environment.
6.	Nested Transactions:
•	The system should support nested transactions (transactions started within another active transaction).
•	Commits and rollbacks of nested transactions should be handled correctly:
•	Committing a nested transaction merges its changes with the parent transaction but does not finalize changes.
•	Rolling back a nested transaction undoes only the changes done in that nested scope.
•	Changes become permanent only when the outermost transaction commits.

⸻

Expected Deliverables:
•	Java classes implementing the repository, entity model (e.g., User), and transaction management.
•	Proper synchronization to ensure thread-safety.
•	Clear separation of concerns (e.g., WAL management, transaction management, CRUD operations).
•	Unit tests or example usage demonstrating:
•	CRUD operations within transactions
•	Correct rollback behavior
•	Nested transaction commit and rollback
•	Optimistic locking enforcement

⸻

Discussion Points (Optional):
•	How would you extend this to support distributed transactions?
•	How does this design compare with traditional database transaction mechanisms?
•	Trade-offs of in-memory WAL vs. persisting logs to disk?
•	Possible performance bottlenecks and improvements.

⸻

This problem tests the candidate’s ability to:
•	Design thread-safe, transactional data structures
•	Use appropriate data structures for undo/rollback semantics
•	Implement nested transactions and understand transactional scopes
•	Handle concurrency via optimistic locking
•	Write clean, modular Java code
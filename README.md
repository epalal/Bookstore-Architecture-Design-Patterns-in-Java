# Java Bookstore Architecture

### Project Overview
This software system provides a robust infrastructure for bookstore management. The application handles complex inventory structures, automated pricing algorithms, and dynamic receipt generation. The codebase utilizes the Java programming language and incorporates JUnit for continuous testing validation.

### Architectural Patterns
The system architecture relies on three primary design patterns to ensure modularity and extensibility:

#### 1. Composite Pattern
The inventory system utilizes a hierarchical data structure:
* **`Item` (Component):** The foundational interface for all bookstore merchandise.
* **`BookCollection` (Composite):** Represents a curated series of books. It aggregates multiple items. The pricing algorithm automatically calculates the total cost and applies a standard 10% discount.
* **`SingleBook` (Leaf):** Represents an individual publication. It contains specific descriptive attributes and base pricing parameters.

#### 2. Strategy Pattern
The system employs dynamic selection algorithms for the shop window (`ShopWindow`):
* Various selection strategies isolate specific literary genres.
* This paradigm allows flexible modification of display criteria without altering the core inventory logic. Selected items may receive promotional discounts.

#### 3. Decorator Pattern
The transaction receipt generation utilizes structural decorators for maximum flexibility:
* **Base Receipt:** Generates the fundamental list of purchased items.
* **`ReceiptDecorator`:** The abstract base class for structural additions.
* **`TopReceipt`:** Appends custom textual headers (e.g., store name and address) to the document.
* **`DownReceipt`:** Appends custom textual footers (e.g., customer appreciation messages).
* **`DateTime`:** Injects precise chronological timestamps into the receipt output.

### Quality Assurance
The repository includes a comprehensive JUnit testing suite. These computational tests validate the mathematical accuracy of the collection pricing logic. Furthermore, the tests verify the accurate string assembly of the nested receipt decorators.

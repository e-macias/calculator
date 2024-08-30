# Implementing a Flexible Calculator

## Description
Built using Spring and Maven, this is my implementation of a simple Calculator supporing the two required methods. 

## Configuration (how to add new strategies)
The **Operations** Enum is defined under the `com.example.calculator.operations` package, containing the four basic operations, but can be expanded to all more.

1. Add a new operation to `Operation.java`.
2. Create a concrete class that implements the `OperationStrategy.java` interface.
3. Add your class to the Calculator's configuration (`CalculatorConfig.java`).
4. Create test cases for your new strategy.

## Assumptions and design decisions
Assumptions I made while designing the calcultor include:
* Assuming the "calculate" method specifically takes the java.lang.Number class, as opposed to *any* number (i.e. int, float, double). I also assumed as this is a "simple" calculator that we will be working with simple numbers (integers, decimals), and not necessarily complex numbers. Nor that overflow would be something to handle.
* Assuming that the calculator class would be expecting only numbers and not responsible for pasing the input text (possibly handled by another UI component). 
* Assuming single-threaded use. A multi-threaded environment may need additional synchronization. 

Design decisions made include:
* Incorporating `OperationStrategy` as an example of using Strategy pattern to define a set of (arithmetic) *operations*, encapsulating each one and making them interchangable at runtime without chaing the `Calculator` class.
* Using a Map for both Operation storage and configuration. I originally planned on using a Factory for creating/determining which strategy to provide to the `calculate` method. I decided on a Map for its simplicity, versatility, and to keep the number of newly created classes to a minimum. However, this decision is one I am still back and forth on.
* Using a Map for chaining. Similar to my previous bullet point, I was originally thinking about going in a different direction. Instead, returning an object to accomedate the chaining, thus implementing method chaining. I decided to go with a Map, again for its simplicity, and to keep the Calculator class and methods smaller and simpler, and avoiding modifiable class variables.
* Using Java's Number class. As stated before, I assumed this was a requirement, but I decided to use it as it covers all numeric types allowing for more flexibility in the types the calculator can handle. 
* The decision to use Spring and Maven was made to best handle IoC compatibility and build/dependencies respectively. The same could be accomplished without them, but they make working with Java easier, and so I decided to proceed in this direction.

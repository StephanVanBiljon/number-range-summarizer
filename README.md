# Number Range Summarizer

This project is a Number Range Summarizer that summarizes a list of numbers into a condensed range format.

## Assumptions

- All input elements must be integers.
- Duplicate integers are not allowed.
- Integers may be unordered.
- Signed integers are allowed.
- The number of integers >= 1.

## Prerequisites

- Java Development Kit (JDK) 17 installed
- Apache Maven installed

## Getting Started

To get started with the Number Range Summarizer, follow the steps below.

### 1. Clone the Repository

Clone the repository to your local machine using the following command:

```
git clone https://github.com/StephanVanBiljon/number-range-summarizer.git
```

### 2. Build the Project

Navigate to the project directory:

```
cd number-range-summarizer
```

Build the project using Maven:

```
mvn clean install
```

### 3. Run the Tests

Execute the tests using the following Maven command:

```
mvn test
```

This will run the unit tests and provide you with the test results.

### 4. Run the Main Method

To execute the main method and run the Number Range Summarizer, use the following Maven command:

```
mvn exec:java
```

The program will execute and provide output based on the input to the main method. Feel free to change the input to the main method to investigate any cases that you feel are missing from the unit tests.

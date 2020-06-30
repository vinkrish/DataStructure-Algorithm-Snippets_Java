### Exceptions

An exception is an abnormal condition that occurs in a code sequence during the execution of a program. This abnormal condition arises when a program violates certain constraints at runtime.

> "If a client can reasonably be expected to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception".

In Java, there are two types of exceptions:

- Checked Exceptions
- Unchecked Exceptions


#### Checked Exceptions

- The exceptions that are checked at compile time.
- Checked exceptions are mandatory to handle. They are direct subclasses of the class Exception.
- In general, checked exceptions represent errors outside the control of the program.
- If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using throws keyword.
- eg: IOException, SQLException, and ParseException.

#### Unchecked Exceptions

- The compiler doesn't check during the compilation process.
- In Java exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked.
- It reflects some error inside the program logic.
- It is up to the programmers to specify or catch the exceptions.
- eg: NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException.
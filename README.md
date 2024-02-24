### GoodClass:
for this so-called good class, one can intuitively tell that testing the main
method "interactWithDb" will become super easy as each functionality is in its own
method which can be mocked and verified super easily
there will be more unit tests for this class but each of them will be very simple
and intuitive to understand thus the simpler better tests would indicate better more modular code i.e it follows the principles of OOP

### BadClass
testing this class would be very difficult as everything is
inside the same method and there would be no mocking possible
we would have to test every possible flow of execution which will create
a very unnecessarily complex test


the tests are not extremely different but even then
the setup for the BadClassTest is a little longer and this is only
a small application... real world applications are a lot longer and more complex
note that these tests only cover one flow of execution, not all of them
so one could argue that by looking at tests we could get an idea of what the code looks like

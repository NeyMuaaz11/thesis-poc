### goodClass:
for this so-called good class, one can intuitively tell that testing the main
method "interactWithDb" will become super easy as each functionality is in its own
method which can be mocked and verified super easily
there will be more unit tests for this class but each of them will be very simple
and intuitive to understand thus the simpler better tests would indicate better code...

### badClass
testing this class would be very difficult as everything is
inside the same method and there would be no mocking possible
we would have to test every possible flow of execution which will create
a very unnecessarily complex test
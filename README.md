Due to other constraintes, including some live customer issues, I only got to spend about 2 to 2 1/2 hours on this task.

As you'll see from the UML, I am no expert in it, and if required for the position is something I would brush up on.
The data model is quite simplistic but I believe does capture all the requirements. I left it short of creating the
service classes that would be required to allow the various actors to access the data needed. For example, a service
would be required to allow an Administrator to list LoanType. I have to say that a significant part of my time on this
task was spent trying to work out how to use the UML designer I found online!

The model I chose for the service layer, is a standard one. An interface defined for the service itself with a factory
used to create an instance of it. This allows for the replacement of the implementation of the service itself to be
performed easily. This is an example of the Factory design pattern. A further design pattern I chose to use is the Builder
pattern, this pattern allows assignment of classes to be achieved in a single statement. It's also more extensible. If
a new member variable is added to the class, then to assign it, a new method simply needs to be added to the class's
Builer.

With regards to the code, it is all in the src/java directory. It will compile and there is a class called Example1 in the
techtest.examples package that will show how a REST or SOAP call implementation would invoke the service to perform the
credit check. If you run the Example1 class with no argument, it uses the default credit check service. If you pass a single
argument, it must be either "experian" or "equifax". Any other argument will report an error. The implemntation of the
experian and equifax services are stubs and return a token value.

I stopped short of producing a REST implementation as I would have used Spring Boot to do this and it would have added a
whole new level of complexity to the solution. As the spec said the service didn't need to run, I assumed that meant I
didn't need to produce the UI as there would be nothing to test with it.

Had I used Spring I would have used JUnit to produce some unit tests and would have used Mockito to create a mocked
version of the CreditAgency interface which would have been used to produce consistent results. There's no point having
unit tests if any of the external components you use may deliver inconsistent results.

I'm sure there will be plenty to discuss about this on Monday!

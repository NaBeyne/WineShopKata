# WineShop Implementation Steps

This file contains some extra information on the steps I've taken to go through the WineShop exercise, separated per commit.

## Write approval tests

I started the exercise by writing approval tests covering all code that was present. Using the built in Intellij test
coverage tracker I created a list of objects to use for my approval tests which made sure I had 100% coverage of the
existing code. For easier debugging, I created multiple approval tests covering certain increases in years to be able to
easily pinpoint when issues start to happen during my refactoring.

## Create constants and a separate method for updating one 

In this step, I created constants for all the strings in the updateWines method and I did the first simplifications of
the method. Next to that, I created the updateWine method, which contains the functionality to update one wine.

## Create separate methods for all kinds of wine

This step contains the first big refactoring, namely splitting up the large method into smaller methods for each type
of wine. After this refactoring, the main updateWine method is simplified into two steps, first identifying which wine
it has to process and then calling the corresponding method of that type of wine.

## Create WineWrappers for all wines

In this step I moved all code of the separate methods for each wine to separate classes for each wine. The classes I
created wrap the given wine, as the Wine class is not open to be extended. All wrapper classes inherit from the abstract
WineWrapper class, this class has the abstract function updateWine, which is used by the other classes to implement 
their update functionality.

## Create unit tests

Now that all functionality for the different types of wine is cleanly put into different classes, the opportunity came
to create some unit tests for all types of wine. I mainly used these tests in the next steps when I started cleaning up
the updateWine methods for all types of wine.

## Cleanup of duplicated code

The different WineWrapper classes contained a lot of duplicated code for increasing, decreasing and comparing their
variables. I created methods for these pieces of code and put these in the main WineWrapper class so they could be used
by all the subclasses.

## Create factory class

The updateWine method was already basically a factory method, so I moved this method to a separate factory class for the
creation of the correct WineWrapper for the given wines.

## Create separate methods for updating price and updating expiresInYears

In this step I separated the update price and the update expiresInYears functionality into two separate methods, which
seemed a bit more clean in my opinion as the original updateWine method covered a lot for one method. I also did this in
preparation for the addition of the eco wine, as this has the exact same functionality as the regular wine, only the
price changes twice as fast.

## Add eco wine functionality

In this final step I added the eco wine functionality and tests for the eco wine functionality. The addition of the eco
wine was done by just creating an extra WineWrapper class for the eco wine and adding this to the factory class. The
EcoWineWrapper inherits the RegularWineWrapper, in this way the updatePrice functionality of the RegularWineWrapper
could be used for updating the eco wine.
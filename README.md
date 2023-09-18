# SOLID Principles


## Author: Maria Lesenco


## Objectives:

* Study and understand the SOLID Principles.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Create a sample project that respects SOLID Principles.


## Used Design Patterns: 

* Single-responsiblity Principle
* Open-closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle


## Implementation

I thried to create all of my classes to do only one job, which is the deffinition of Single-responsiblity Principle. I divided large classes into small ones. This move allows me to say that my classes are open for extension but closed for modification. I can prove that I have implemented Liskov Substitution Principle because I have abstract parent classes and their children can be used in the same way as it was intended in abstract parent classes. I deleted everything that could force client to depend on methods they do not use. I have dependicies only with abstract classes which is deffinition of Dependency Inversion Principle.




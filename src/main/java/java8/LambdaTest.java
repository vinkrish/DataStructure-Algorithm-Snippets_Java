package java8;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 */

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java8.PersonL.Sex;

public class LambdaTest {

    interface CheckPerson {
        boolean test(PersonL p);
    }

    // Approach 1: Create Methods that Search for Persons that Match One
    // Characteristic

    public static void printPersonsOlderThan(List<PersonL> roster, int age) {
        for (PersonL p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods

    public static void printPersonsWithinAgeRange(
        List<PersonL> roster, int low, int high) {
        for (PersonL p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression

    public static void printPersons(
        List<PersonL> roster, CheckPerson tester) {
        for (PersonL p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions

    public static void printPersonsWithPredicate(
        List<PersonL> roster, Predicate<PersonL> tester) {
        for (PersonL p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application

    public static void processPersons(
        List<PersonL> roster,
        Predicate<PersonL> tester,
        Consumer<PersonL> block) {
        for (PersonL p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    // Approach 7, second example

    public static void processPersonsWithFunction(
        List<PersonL> roster,
        Predicate<PersonL> tester,
        Function<PersonL, String> mapper,
        Consumer<String> block) {
        for (PersonL p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    
    // Approach 8: Use Generics More Extensively

    public static <X, Y> void processElements(
        Iterable<X> source,
        Predicate<X> tester,
        Function<X, Y> mapper,
        Consumer<Y> block) {
            for (X p : source) {
                if (tester.test(p)) {
                    Y data = mapper.apply(p);
                    block.accept(data);
                }
            }
    }

    public static void main(String... args) {

        List<PersonL> roster = PersonL.createRoster();

        for (PersonL p : roster) {
            p.printPerson();
        }

        // Approach 1: Create Methods that Search for Persons that Match One
        // Characteristic

        System.out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Approach 2: Create More Generalized Search Methods

        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        // Approach 3: Specify Search Criteria Code in a Local Class

        System.out.println("Persons who are eligible for Selective Service:");

        class CheckPersonEligibleForSelectiveService implements CheckPerson {
           public boolean test(PersonL p) {
                return p.getGender() == PersonL.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
            }
        }

        printPersons(
            roster, new CheckPersonEligibleForSelectiveService());


        System.out.println();

        // Approach 4: Specify Search Criteria Code in an Anonymous Class

        System.out.println("Persons who are eligible for Selective Service " +
            "(anonymous class):");

        printPersons(
            roster,
            new CheckPerson() {
                public boolean test(PersonL p) {
                    return p.getGender() == PersonL.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
                }
            }
        );

        System.out.println();

        // Approach 5: Specify Search Criteria Code with a Lambda Expression
        
        CheckPerson cp = (person) -> { 
        	return person.getGender() == PersonL.Sex.MALE && person.getAge() >= 18 && person.getAge() <= 25;
        };
        CheckPerson cp2 = p -> p.getGender() == PersonL.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        printPersons(roster, cp);

        System.out.println("Persons who are eligible for Selective Service " +
            "(lambda expression):");

        printPersons(
            roster,
            (PersonL p) -> p.getGender() == PersonL.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );

        System.out.println();

        // Approach 6: Use Standard Functional Interfaces with Lambda
        // Expressions

        System.out.println("Persons who are eligible for Selective Service " +
            "(with Predicate parameter):");

        printPersonsWithPredicate(
            roster,
            p -> p.getGender() == PersonL.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );

        System.out.println();

        // Approach 7: Use Lambda Expressions Throughout Your Application

        System.out.println("Persons who are eligible for Selective Service " +
            "(with Predicate and Consumer parameters):");

        processPersons(
            roster,
            p -> p.getGender() == PersonL.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.printPerson()
        );

        System.out.println();

        // Approach 7, second example

        System.out.println("Persons who are eligible for Selective Service " +
            "(with Predicate, Function, and Consumer parameters):");

        processPersonsWithFunction(
            roster,
            p -> p.getGender() == PersonL.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );

        System.out.println();

        // Approach 8: Use Generics More Extensively

        System.out.println("Persons who are eligible for Selective Service " +
            "(generic version):");

        processElements(
            roster,
            p -> p.getGender() == PersonL.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );

        System.out.println();

        // Approach 9: Use Bulk Data Operations That Accept Lambda Expressions
        // as Parameters

        System.out.println("Persons who are eligible for Selective Service " +
            "(with bulk data operations):");

        roster
            .stream()
            .filter(
                p -> p.getGender() == PersonL.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25)
            .map(p -> p.getEmailAddress())
            .forEach(email -> System.out.println(email));
        
        System.out.println();
        
        // UnaryOperator Interface is a functional interface that represents an operation which takes a single parameter and returns a parameter of the same type.

        System.out.println("map is of UnaryOperator functional interface type:");

        roster
            .stream()
            .map(p -> { p.gender = Sex.MALE; return p; })
            .forEach(person -> person.printPerson());
     }
}

/*
	Lambda expressions were introduced as a way to simplify functional programming 
	by allowing you to write concise blocks of code that can be passed as arguments to methods. 
	
	Lambda expressions allow you to write implementations of functional interfaces (interfaces with a single abstract method) using the -> symbol.
 * */

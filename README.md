# COP4520-Assignment1

## Welcome Non-Technical Manager!

To run my program you will need to open your command prompt and download files: MyClass.java
Navigate to the to the folder where you downloaded that file.
Compile the file by typing: javac MyClass.java
Execute the file by typing: java MyClass
You will then find all neccesary information in primes.txt

## Summary

I decided to use a popular algorithm for frinding primes called Sieve of Eratosthenes. This algorithm checks each number 1-10^8 and check if its prime. A prime number is a natural number greater than 1, which is only divisible by 1 and itself.
I used multihreading and gave specific ranges to 8 threads so threads weren't doing the same work as others.
Each thread counted all the prime numbers in their range and added the sum of those prime numbers.
This design makes the program more efficient than just using one main thread that computes all the work. I checked how many primes were in 10^8 and then made sure my final program got the same result. And did the same for sum of prime numbers and the ten maximum primes. All results found in primes.txt have been double checked and are accurate.

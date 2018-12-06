# GetPrime
User input number n. Program will list all prime numbers from 0 - n with choice of querying multiple numbers. 

!Project incomplete. Need to implement algorithm optimization, which is currently commented out due to error. 

For number n, will check in ascending order starting from 1 to check every number and confirm if prime and add to list.  

Code uses Sieve of Eratosthenes and custom method to skip multiples of 3 and 5 when searching for prime. Also skips evens for obvious resons. 

For each number, p, being checked. Instead of iterating through from 1-p, it uses the lists of generated primes and checks if there are any factors from 1-Sqrt(p):

###Let's say m = sqrt(n) then m × m = n. Now if n is not a prime then n can be written as n = a × b, so m × m = a × b. Notice that m is a real number whereas n, a and b are natural numbers.

Now there can be 3 cases:

a > m ⇒ b < m
a = m ⇒ b = m
a < m ⇒ b > m

In all 3 cases, min(a, b) ≤ m. Hence if we search till m, we are bound to find at least one factor of n, which is enough to show that n is not prime.###

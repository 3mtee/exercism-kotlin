# Secret Handshake

> There are 10 types of people in the world: Those who understand
> binary, and those who don't.

You and your fellow cohort of those in the "know" when it comes to
binary decide to come up with a secret "handshake".

```text
00001 = wink
00010 = double blink
00100 = close your eyes
01000 = jump
10000 = Reverse the order of the operations in the secret handshake.
```

Given a decimal number, convert it to the appropriate sequence of events for a secret handshake.

Here's a couple of examples:

Given the input 3, the function would return the array
["wink", "double blink"] because 3 is 11 in binary.

Given the input 19, the function would return the array
["double blink", "wink"] because 19 is 10011 in binary.
Notice that the addition of 16 (10000 in binary)
has caused the array to be reversed.

## Setup

Go through the setup instructions for Kotlin to install the necessary
dependencies:

[https://exercism.io/tracks/kotlin/installation](https://exercism.io/tracks/kotlin/installation)

## Making the test suite pass

Execute the tests with:

```bash
$ gradlew test
```

> Use `gradlew.bat` if you're on Windows

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore` annotation.

## Source

Bert, in Mary Poppins [http://www.imdb.com/title/tt0058331/quotes/qt0437047](http://www.imdb.com/title/tt0058331/quotes/qt0437047)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
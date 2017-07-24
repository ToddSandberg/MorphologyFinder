# MorphologyFinder

Finds the morphology of a word by removing suffixes, then removing prefixes. It then checks the dictionary provided and checks if the word is in the dictionary. If it's not it puts the prefixes back on. 

**Warning** Suffixes are not perfect and prefixes rely heavily on loading a dictionary.

#### How to Use

Using the MorphologyFinder class you can call the breakApart() method which break's apart the word. Then you can get the suffixes, prefixes, root, and traits.

### MorphologyFinderTest

A couple of JUnit tests to check if the program is working correctly.

### SuffixApp

Take's the MorphInput.txt file and runs MorphologyFinder on it, then outputs it to MorphResults.txt

### Superlative Tests

Compares "UniMorph-English_ADJ_Only.csv", which is a large list of comparative and superlative adjectives and their morphology, with MorphologyFinder's output. It outputs all errors to UnimorphMisses.txt.

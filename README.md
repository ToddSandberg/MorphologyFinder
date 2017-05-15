# MorphologyFinder

Finds the morphology of a word by removing suffixes and prefixes until it finds the root word, then checks if the root word it found is in the dictionary english0.txt. If not it backs up a step. 

### MorphologyFinderTest

A couple of JUnit tests to check if the program is working correctly.

### SuffixApp

Take's the MorphInput.txt file and runs MorphologyFinder on it, then outputs it to MorphResults.txt

### Superlative Tests

Compares "UniMorph-English_ADJ_Only.csv", which is a large list of comperative and superlative adjectives and their morphology, with MorphologyFinder's output. It outputs all errors to UnimorphMisses.txt.

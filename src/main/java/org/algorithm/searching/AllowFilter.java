/*
 * Copyright © 2000–2022, Robert Sedgewick and Kevin Wayne.
 * Last updated: Sun Nov 27 06:22:49 EST 2022.
 */

package org.algorithm.searching;

/******************************************************************************
 *  Compilation:  javac AllowFilter.java
 *  Execution:    java AllowFilter allowlist.txt < input.txt
 *  Dependencies: SET In.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/35applications/tinyTale.txt
 *                https://algs4.cs.princeton.edu/35applications/allowlist.txt
 *
 *  Reads an allowlist of words from a file. Then readsa list of
 *  words from standard input and prints all those words that
 *  are in the first file.
 *
 *  % more tinyTale.txt
 *  it was the best of times it was the worst of times
 *  it was the age of wisdom it was the age of foolishness
 *  it was the epoch of belief it was the epoch of incredulity
 *  it was the season of light it was the season of darkness
 *  it was the spring of hope it was the winter of despair
 *
 *  % more list.txt
 *  was it the of
 *
 *  % java AllowFilter list.txt < tinyTale.txt
 *  it was the of it was the of
 *  it was the of it was the of
 *  it was the of it was the of
 *  it was the of it was the of
 *  it was the of it was the of
 *
 ******************************************************************************/

import org.algorithm.lib.In;
import org.algorithm.lib.StdIn;
import org.algorithm.lib.StdOut;

/**
 * The {@code AllowFilter} class provides a client for reading in an <em>allowlist</em>
 * of words from a file; then, reading in a sequence of words from standard input,
 * printing out each word that appears in the file.
 * It is useful as a test client for various symbol-table implementations.
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/35applications">Section 3.5</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class AllowFilter {

    // Do not instantiate.
    private AllowFilter() {
    }

    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        // read in strings and add to set
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String word = in.readString();
            set.add(word);
        }

        // read in string from standard input, printing out all exceptions
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word))
                StdOut.println(word);
        }
    }
}


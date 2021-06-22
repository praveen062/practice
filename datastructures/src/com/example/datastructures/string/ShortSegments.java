package com.example.datastructures.string;

//Java program to find the shortest substring of a
//string containing all given words using HashMap
import java.io.*;
import java.util.*;
import java.util.HashMap;

public class ShortSegments {

	 public static void findShortest(String sentence,
             String[] words)
{
// Make an array of words from given sentence
// We remove punctuations before splitting.
String replicate = sentence.replace(".", "");
replicate = replicate.replace(", ", "");
replicate = replicate.replace("!", "");
String sent_words[] = replicate.split(" ");

// hashmap to store given words in a map.
HashMap<String, Integer> map = new HashMap<>();
int length = words.length;
for (int i = 0; i < length; i++)
map.put(words[i], -1);

// Traverse through all sentence words
// and if they match with given words
// then mark their appearances in map.
int len_sub = Integer.MAX_VALUE;
int count = 0;
int local_start = 0, local_end = 0;
for (int i = 0; i < sent_words.length; i++) {
if (map.containsKey(sent_words[i]) == true) {

// If this is the first occurrence
int index = map.get(sent_words[i]);
if (index == -1)
count++;

// Store latest index
map.put(sent_words[i], i);

// If all words matched
if (count == length) {

// Find smallest index
int min = Integer.MAX_VALUE;
for (Map.Entry<String, Integer> m :
             map.entrySet()) {
int val = m.getValue();
if (val < min)
    min = val;
}

// Check if current length is smaller
// then length so far
int s = i - min;
if (s < len_sub) {
local_start = min;
local_end = i;
len_sub=s;
}
}
}
}

// Printing original substring (with punctuations)
// using resultant local_start and local_end.
String[] original_parts = sentence.split(" ");
for (int i = local_start; i <=local_end; i++)
System.out.print(original_parts[i] + " ");
}

// Driver code
public static void main(String args[])
{
String sentence = "This is a test. This is a programming test. This is a programming test in any language.";
String[] words = { "This", "test", "a", "programming" };
findShortest(sentence, words);
}
}

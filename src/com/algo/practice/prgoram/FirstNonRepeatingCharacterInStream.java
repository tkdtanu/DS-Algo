package com.algo.practice.prgoram;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.LongStream;

/*
* Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If no non repeating element is found print -1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the stream. Then in the next line are x characters which are inserted to the stream.

Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.

Constraints:
1 <= T <= 200
1 <= N <= 500

Example:
Input:
4
4
a a b c
3
a a c
12
o t z o m e q l f t x z
40
v f g v j w d v j j a f q z z x l c x d z n c q g j l a p o p k v x f g v i c e
284
w l r b b m q b h c d a r z o w k k y h i d d q s c d x r j m o w f r x s j y b l d b e f s a r c b y n e c d y g g x x p k l o r e l l n m p a p q f w k h o p k m c o q h n w n k u e w h s q m g b b u q c l j j i v s w m d k q t b x i x m v t r r b l j p t n s n f w z q f j m a f a d r r w s o f s b c n u v q h f f b s a q x w p q c a c e h c h z v f r k m l n o z j k p q p x r j x k i t z y x a c b h h k i c q c o e n d t o m f g d w d w f c g p x i q v k u y t d l c g d e w h t a c i o h o r d t q k v w c s g s p q o q m s b o a g u w n n y q x n z l g d g w

Output:
a -1 b b
a -1 c
o o o t t t t t t z z m
v v v f f f f f f f f g g g g g g g g g g g g g w w w w w w w w w w w w w w w w
w w w w w w w w w w w w w w w l l l l l l l l l l l l l l l l l l l l l l l l l a a a a a a z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z z -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
*/
public class FirstNonRepeatingCharacterInStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long noOfTestCase = scanner.nextLong();

        LongStream.range(0, noOfTestCase).forEach(value -> {
            Queue<Character> characterQueue = new LinkedList<>();
            Long characterCountInStream = scanner.nextLong();
            boolean[] existingCharaterArray = new boolean[26];

            for (long value1 = 0; value1 < characterCountInStream; value1++) {
                char currentCharater = scanner.next().charAt(0);
                int position = currentCharater -97; //as we know lower case charaer start from 97
                if (!existingCharaterArray[position]) {
                    existingCharaterArray[position] = true;
                    characterQueue.add(currentCharater);
                    Character uniqueCharater = characterQueue.peek();
                    System.out.print(uniqueCharater);
                } else {
                    ((LinkedList<Character>) characterQueue).removeFirstOccurrence((char)currentCharater);
                    Character uniqueCharater = characterQueue.peek();
                    System.out.print(uniqueCharater != null ? uniqueCharater : "-1");

                }
                if(value1 != characterCountInStream -1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        });
    }
}

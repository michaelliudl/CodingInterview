package com.topcoder.problems;
/**
 * Problem Statement
     
 Let's say you have a binary string such as the following:
 011100011
 One way to encrypt this string is to add to each digit the sum of its adjacent digits. For example, the above string would become:
 123210122
 In particular, if P is the original string, and Q is the encrypted string, then Q[i] = P[i-1] + P[i] + P[i+1] for all digit positions i. Characters off the left and right edges of the string are treated as zeroes.
 An encrypted string given to you in this format can be decoded as follows (using 123210122 as an example):
 Assume P[0] = 0.
 Because Q[0] = P[0] + P[1] = 0 + P[1] = 1, we know that P[1] = 1.
 Because Q[1] = P[0] + P[1] + P[2] = 0 + 1 + P[2] = 2, we know that P[2] = 1.
 Because Q[2] = P[1] + P[2] + P[3] = 1 + 1 + P[3] = 3, we know that P[3] = 1.
 Repeating these steps gives us P[4] = 0, P[5] = 0, P[6] = 0, P[7] = 1, and P[8] = 1.
 We check our work by noting that Q[8] = P[7] + P[8] = 1 + 1 = 2. Since this equation works out, we are finished, and we have recovered one possible original string.
 Now we repeat the process, assuming the opposite about P[0]:
 Assume P[0] = 1.
 Because Q[0] = P[0] + P[1] = 1 + P[1] = 0, we know that P[1] = 0.
 Because Q[1] = P[0] + P[1] + P[2] = 1 + 0 + P[2] = 2, we know that P[2] = 1.
 Now note that Q[2] = P[1] + P[2] + P[3] = 0 + 1 + P[3] = 3, which leads us to the conclusion that P[3] = 2. However, this violates the fact that each character in the original string must be '0' or '1'. Therefore, there exists no such original string P where the first digit is '1'.
 Note that this algorithm produces at most two decodings for any given encrypted string. There can never be more than one possible way to decode a string once the first binary digit is set.
 Given a String message, containing the encrypted string, return a String[] with exactly two elements. The first element should contain the decrypted string assuming the first character is '0'; the second element should assume the first character is '1'. If one of the tests fails, return the string "NONE" in its place. For the above example, you should return {"011100011", "NONE"}.
 Definition
     
 Class:
 BinaryCode
 Method:
 decode
 Parameters:
 String
 Returns:
 String[]
 Method signature:
 String[] decode(String message)
 (be sure your method is public)
     

 Constraints
 -
 message will contain between 1 and 50 characters, inclusive.
 -
 Each character in message will be either '0', '1', '2', or '3'.
 Examples
 0)

     
 "123210122"
 Returns: { "011100011",  "NONE" }
 The example from above.
 1)

     
 "11"
 Returns: { "01",  "10" }
 We know that one of the digits must be '1', and the other must be '0'. We return both cases.
 2)

     
 "22111"
 Returns: { "NONE",  "11001" }
 Since the first digit of the encrypted string is '2', the first two digits of the original string must be '1'. Our test fails when we try to assume that P[0] = 0.
 3)

     
 "123210120"
 Returns: { "NONE",  "NONE" }
 This is the same as the first example, but the rightmost digit has been changed to something inconsistent with the rest of the original string. No solutions are possible.
 4)

     
 "3"
 Returns: { "NONE",  "NONE" }

 5)

     
 "12221112222221112221111111112221111"
 Returns:
 { "01101001101101001101001001001101001",
 "10110010110110010110010010010110010" }
 */
public class BinaryCode {
    public String[] decode(String message) {
        if (message == null || message.length() < 1 || message.length() > 50) {
            throw new IllegalArgumentException();
        }
        int len = message.length();
        int resultZero[] = new int[len];
        int resultOne[] = new int[len];
        resultZero[0] = 0;
        resultOne[0] = 1;
        for (int i = 0; i < len; i++) {
            int qi = Character.getNumericValue(message.charAt(i));
            if (qi < 0 || qi > 3) {
                throw new IllegalArgumentException();
            }
            if (i == 0) {
                int piPlusOne = qi - resultZero[0];
                if (piPlusOne == 0 || piPlusOne == 1) {
                    resultZero[1] = piPlusOne;
                } else {
                    resultZero = null;
                }
                piPlusOne = qi - resultOne[0];
                if (piPlusOne == 0 || piPlusOne == 1) {
                    resultOne[1] = piPlusOne;
                } else {
                    resultOne = null;
                }
            } else if (i == len - 1) {
                if (resultZero != null) {
                    if (qi != resultZero[i - 1] + resultZero[i]) {
                        resultZero = null;
                    }
                }
                if (resultOne != null) {
                    if (qi != resultOne[i - 1] + resultOne[i]) {
                        resultOne = null;
                    }
                }
            } else {
                if (resultZero != null) {
                    int piPlusOne = qi - resultZero[i] - resultZero[i - 1];
                    if (piPlusOne == 0 || piPlusOne == 1) {
                        resultZero[i + 1] = piPlusOne;
                    } else {
                        resultZero = null;
                    }
                }
                if (resultOne != null) {
                    int piPlusOne = qi - resultOne[i] - resultOne[i - 1];
                    if (piPlusOne == 0 || piPlusOne == 1) {
                        resultOne[i + 1] = piPlusOne;
                    } else {
                        resultOne = null;
                    }
                }
            }
        }
        String result[] = new String[2];
        if (resultZero == null) {
            result[0] = "NONE";
        } else {
            result[0] = convertToString(resultZero);
        }
        if (resultOne == null) {
            result[1]  = "NONE";
        } else {
            result[1] = convertToString(resultOne);
        }
        return result;
    }

    private String convertToString(int[] resultArray) {
        StringBuilder sb = new StringBuilder();
        for (int i : resultArray) {
            sb.append(i);
        }
        return sb.toString();
    }
}

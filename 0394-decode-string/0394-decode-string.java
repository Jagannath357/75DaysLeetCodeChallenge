import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the number k (handling multiple digits)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the multiplier and the current state to stacks
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset for the content inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the multiplier and the previous context
                int repeatTimes = countStack.pop();
                StringBuilder decodedSegment = currentString;
                currentString = stringStack.pop();
                
                // Append the repeated segment to the previous context
                while (repeatTimes-- > 0) {
                    currentString.append(decodedSegment);
                }
            } else {
                // Just a regular character, append to the current working string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/description/?envType=problem-list-v2&envId=string

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

solution:=
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                 st.push(s.charAt(i));
            }
            else {
                if(st.isEmpty()){
                    return false;
                }
               
                    char top = st.pop(); 
                   if ((top == '(' && s.charAt(i) != ')') || 
                    (top == '[' && s.charAt(i) != ']') || 
                    (top == '{' && s.charAt(i) != '}')) {
                    return false;
                    }
                
            }

        }
        return st.isEmpty();
    }
}

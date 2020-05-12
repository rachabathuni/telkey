package com.sailu.telkey;

public class Trans {
    public int index;
    public String inChar;
    public char prevPrevChar;
    public char prevChar;
    public String outputStr;
    public int replaceChars;
    public MatchFunction prevCharMatch;

    public interface MatchFunction {
        public boolean match(char ch);
    }

    public Trans(String inc, char ppchar, char pchar, String ostr, int rchars) {
        inChar = inc;
        prevPrevChar = ppchar;
        prevChar = pchar;
        outputStr = ostr;
        replaceChars = rchars;
        prevCharMatch = null;
    }

    public void setPrevCharMatch(MatchFunction m) {

        prevCharMatch = m;
    }

    public boolean isMatch(char ppchar, char pchar) {
        if (prevPrevChar == TransEngine.NULL_CHAR || prevPrevChar == ppchar)
        {
            if (prevCharMatch != null) {
                return prevCharMatch.match(pchar);
            }
            else {
                return (pchar == prevChar);
            }
        }
        else {
            return false;
        }
    }

    public void setPrevChar(char ch) {
        prevChar = ch;
    }

    public void setIndex(int idx) {
        index = idx;
    }
}

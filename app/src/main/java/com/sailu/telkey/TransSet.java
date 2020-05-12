package com.sailu.telkey;

import java.util.ArrayList;

public class TransSet {
    private ArrayList<Trans> list;
    private Trans defaultTrans;

    public TransSet() {
        list = new ArrayList<Trans>();
        defaultTrans = null;
    }
    public Trans get(String inchar, char ppchar, char pchar) {
        Trans matched_tran = null;

        for (Trans tran: list) {
            if (tran.isMatch(ppchar, pchar)) {
                matched_tran = tran;
                break;
            }
        }

        if (matched_tran == null && defaultTrans != null) {
            System.out.println("Matching default transition");
            matched_tran = defaultTrans;
        }

        if (matched_tran != null) {
            System.out.println("Matched transition: inchar: [" + inchar + "] index: " + matched_tran.index);
        }
        else {
            System.out.println("No matched trans");
        }

        return matched_tran;
    }

    public void add(Trans t) {
        list.add(t);
        t.setIndex(list.size());
    }

    public void setDefaultTrans(Trans t) {
        defaultTrans = t;
    }
}
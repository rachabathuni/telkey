package com.sailu.telkey;

import java.util.HashMap;

public class TransEngine {
    public static final char NUMBER_0 = '\u0C66';
    public static final char NUMBER_1 = '\u0C67';
    public static final char NUMBER_2 = '\u0C68';
    public static final char NUMBER_3 = '\u0C69';
    public static final char NUMBER_4 = '\u0C6A';
    public static final char NUMBER_5 = '\u0C6B';
    public static final char NUMBER_6 = '\u0C6C';
    public static final char NUMBER_7 = '\u0C6D';
    public static final char NUMBER_8 = '\u0C6E';
    public static final char NUMBER_9 = '\u0C6F';

    public static final char VOW_a = '\u0C05';
    public static final char VOW_aa = '\u0C06';
    public static final char VOW_i = '\u0C07';
    public static final char VOW_ii = '\u0C08';
    public static final char VOW_u = '\u0C09';
    public static final char VOW_uu = '\u0C0A';
    public static final char VOW_R = '\u0C0B';
    public static final char VOW_RR = '\u0C60';
    public static final char VOW_e = '\u0C0E';
    public static final char VOW_ee = '\u0C0F';
    public static final char VOW_ai = '\u0C10';
    public static final char VOW_o = '\u0C12';
    public static final char VOW_oo = '\u0C13';
    public static final char VOW_ou = '\u0C14';
    public static final char VOW_alu = '\u0C0C';
    public static final char VOW_aloo = '\u0C61';

    public static final char CONS_k = '\u0C15';
    public static final char CONS_K = '\u0C16';
    public static final char CONS_g = '\u0C17';
    public static final char CONS_G = '\u0C18';
    public static final char CONS_INYA = '\u0C19';
    public static final char CONS_c = '\u0C1A';
    public static final char CONS_C = '\u0C1B';
    public static final char CONS_j = '\u0C1C';
    public static final char CONS_J = '\u0C1D';
    public static final char CONS_INI = '\u0C1E';
    public static final char CONS_T = '\u0C1F';
    public static final char CONS_TH = '\u0C20';
    public static final char CONS_D = '\u0C21';
    public static final char CONS_DH = '\u0C22';
    public static final char CONS_N = '\u0C23';
    public static final char CONS_t = '\u0C24';
    public static final char CONS_th = '\u0C25';
    public static final char CONS_d = '\u0C26';
    public static final char CONS_dh = '\u0C27';
    public static final char CONS_n = '\u0C28';
    public static final char CONS_p = '\u0C2A';
    public static final char CONS_P = '\u0C2B';
    public static final char CONS_b = '\u0C2C';
    public static final char CONS_B = '\u0C2D';
    public static final char CONS_m = '\u0C2E';
    public static final char CONS_y = '\u0C2F';
    public static final char CONS_r = '\u0C30';
    public static final char CONS_BANDI_RA = '\u0C31';
    public static final char CONS_l = '\u0C32';
    public static final char CONS_L = '\u0C33';
    public static final char CONS_v = '\u0C35';
    public static final char CONS_S = '\u0C36';
    public static final char CONS_sh = '\u0C37';
    public static final char CONS_s = '\u0C38';
    public static final char CONS_h = '\u0C39';

    // cha as in rachchabanda
    public static final char CONS_q = '\u0C58';

    // ja as in jalleda
    public static final char CONS_z = '\u0C59';

    public static final char VIRAMA = '\u0C4D';
    public static final char VISARGA = '\u0C03';
    public static final char ANUSVARA = '\u0C02';
    public static final char EXT_AI = '\u0C48';
    public static final char EXT_OU = '\u0C4C';
    public static final char EXT_A = '\u0C3E';
    public static final char EXT_E = '\u0C47';
    public static final char EXT_I = '\u0C40';
    public static final char EXT_O = '\u0C4B';
    public static final char EXT_R = '\u0C43';
    public static final char EXT_RR = '\u0C44';
    public static final char EXT_U = '\u0C42';
    public static final char EXT_e = '\u0C46';
    public static final char EXT_i = '\u0C3F';
    public static final char EXT_o = '\u0C4A';
    public static final char EXT_u = '\u0C41';

    public static final char ZERO_WIDTH_SPACE = '\u200B';
    public static final char ZERO_WIDTH_NON_JOINER = '\u200c';
    public static final char THIN_SPACE = '\u2009';

    public static final char NON_JOINER = ZERO_WIDTH_NON_JOINER;

    public static final char NULL_CHAR = '\u0000';
    public static final char SPACE = ' ';

    Object[][] states =
            {
                    // Backspace
                    {"BS", NULL_CHAR, VIRAMA, "", 2},
                    {"BS", NULL_CHAR, "is_consonent", VIRAMA, 0},
                    {"BS", NULL_CHAR, EXT_A, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_E, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_I, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_U, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_O, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_e, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_i, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_o, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_u, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_R, VIRAMA, 1},
                    {"BS", NULL_CHAR, EXT_RR, VIRAMA, 1},
                    {"BS", NULL_CHAR, NULL_CHAR, "", 1},

                    {"a", NULL_CHAR, VIRAMA, "", 1 },
                    {"a", NULL_CHAR, ANUSVARA, CONS_m, 1 },
                    {"a", NULL_CHAR, VOW_a, VOW_aa, 1 },
                    {"a", NULL_CHAR, "is_consonent", EXT_A, 0 },
                    {"a", NULL_CHAR, SPACE, VOW_a, 0 },
                    {"a", NULL_CHAR, EXT_e, EXT_E, 1},
                    {"a", NULL_CHAR, NULL_CHAR, VOW_a, 0 },

                    {"A",  NULL_CHAR, VIRAMA, EXT_A, 1 },
                    {"A",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_A, 1 },
                    {"A",  NULL_CHAR, VOW_a, VOW_aa, 1 },
                    {"A",  NULL_CHAR, "is_consonent", EXT_A, 0 },
                    {"A",  NULL_CHAR, SPACE, VOW_aa, 0 },
                    {"A",  NULL_CHAR, NULL_CHAR, VOW_aa, 0 },

                    {"e",  NULL_CHAR, VIRAMA, EXT_e, 1 },
                    {"e",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_e, 1 },
                    {"e",  NULL_CHAR, SPACE, VOW_e, 0 },
                    {"e",  NULL_CHAR, EXT_e, EXT_I, 1},
                    {"e",  NULL_CHAR, "is_consonent", EXT_E, 0},
                    {"e",  NULL_CHAR, NULL_CHAR, VOW_e, 0 },

                    {"E",  NULL_CHAR, VIRAMA, EXT_E, 1 },
                    {"E",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_E, 1 },
                    {"E",  NULL_CHAR, SPACE, VOW_ee, 0 },
                    {"E",  NULL_CHAR, EXT_e, EXT_E, 1},
                    {"E",  NULL_CHAR, NULL_CHAR, VOW_ee, 0 },

                    {"i",  NULL_CHAR, VOW_a, VOW_ai, 1 },
                    {"i",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_i, 1 },
                    {"i",  NULL_CHAR, "is_consonent", EXT_AI, 0},
                    {"i",  NULL_CHAR, VIRAMA, EXT_i, 1 },
                    {"i",  NULL_CHAR, SPACE, VOW_i, 0 },
                    {"i",  NULL_CHAR, EXT_i, EXT_I, 1},
                    {"i",  NULL_CHAR, NULL_CHAR, VOW_i, 0 },

                    {"I",  NULL_CHAR, VOW_a, VOW_ai, 1 },
                    {"I",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_I, 1 },
                    {"I",  NULL_CHAR, "is_consonent", EXT_AI, 0},
                    {"I",  NULL_CHAR, VIRAMA, EXT_I, 1 },
                    {"I",  NULL_CHAR, EXT_i, EXT_I, 1},
                    {"I",  NULL_CHAR, SPACE, VOW_ii, 0 },
                    {"I",  NULL_CHAR, NULL_CHAR, VOW_ii, 0 },

                    {"o",  NULL_CHAR, VIRAMA, EXT_o, 1 },
                    {"o",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_o, 1 },
                    {"o",  NULL_CHAR, SPACE, VOW_o, 0 },
                    {"o",  NULL_CHAR, EXT_o, EXT_O, 1},
                    {"o",  NULL_CHAR, NULL_CHAR, VOW_o, 0 },

                    {"O",  NULL_CHAR, VIRAMA, EXT_O, 1 },
                    {"O",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_O, 1 },
                    {"O",  NULL_CHAR, SPACE, VOW_oo, 0 },
                    {"O",  NULL_CHAR, EXT_o, EXT_O, 1},
                    {"O",  NULL_CHAR, NULL_CHAR, VOW_oo, 0 },

                    {"u",  NULL_CHAR, VOW_a, VOW_ou, 1 },
                    {"u",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_u, 1 },
                    {"u",  NULL_CHAR, "is_consonent", EXT_OU, 0},
                    {"u",  NULL_CHAR, EXT_o, EXT_OU, 1},
                    {"u",  NULL_CHAR, VIRAMA, EXT_u, 1 },
                    {"u",  NULL_CHAR, VOW_R, VOW_RR, 1 },
                    {"u",  NULL_CHAR, EXT_R, EXT_RR, 1 },
                    {"u",  NULL_CHAR, SPACE, VOW_u, 0 },
                    {"u",  NULL_CHAR, EXT_u, EXT_U, 1},
                    {"u",  NULL_CHAR, NULL_CHAR, VOW_u, 0 },

                    {"U",  NULL_CHAR, VOW_a, VOW_ou, 1 },
                    {"U",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_U, 1 },
                    {"U",  NULL_CHAR, "is_consonent", EXT_OU, 0},
                    {"U",  NULL_CHAR, EXT_R, EXT_RR, 1 },
                    {"U",  NULL_CHAR, VIRAMA, EXT_U, 1 },
                    {"U",  NULL_CHAR, SPACE, VOW_uu, 0 },
                    {"U",  NULL_CHAR, EXT_u, EXT_U, 1},
                    {"U",  NULL_CHAR, NULL_CHAR, VOW_uu, 0 },

                    {"h", CONS_s, VIRAMA, ""+CONS_sh+VIRAMA, 2 },
                    {"h", NULL_CHAR, '@', VISARGA, 1 },
                    {"h",  CONS_c, VIRAMA, "", 0 },
                    {"h",  CONS_C, VIRAMA, "", 0 },
                    {"h",  CONS_t, VIRAMA, ""+CONS_th+VIRAMA, 2 },
                    {"h",  CONS_T, VIRAMA, ""+CONS_TH+VIRAMA, 2 },
                    {"h", CONS_k, VIRAMA, ""+CONS_K+VIRAMA, 2},
                    {"h", CONS_g, VIRAMA, ""+CONS_G+VIRAMA, 2},
                    {"h", CONS_c, VIRAMA, ""+CONS_C+VIRAMA, 2},
                    {"h", CONS_j, VIRAMA, ""+CONS_J+VIRAMA, 2},
                    {"h", CONS_T, VIRAMA, ""+CONS_TH+VIRAMA, 2},
                    {"h", CONS_D, VIRAMA, ""+CONS_DH+VIRAMA, 2},
                    {"h", CONS_t, VIRAMA, ""+CONS_th+VIRAMA, 2},
                    {"h", CONS_d, VIRAMA, ""+CONS_dh+VIRAMA, 2},
                    {"h", CONS_p, VIRAMA, ""+CONS_P+VIRAMA, 2},
                    {"h", CONS_b, VIRAMA, ""+CONS_B+VIRAMA, 2},
                    {"h", NULL_CHAR, VIRAMA, ""+CONS_h+VIRAMA, 1},
                    {"h", NULL_CHAR, NULL_CHAR, ""+CONS_h+VIRAMA, 0},

                    {"m",  NULL_CHAR, '~', ""+CONS_INYA+VIRAMA, 1 },
                    {"m",  NULL_CHAR, VIRAMA, ""+CONS_m + VIRAMA, 0 },
                    {"m",  NULL_CHAR, ANUSVARA, ""+CONS_m+VIRAMA+CONS_m+VIRAMA, 1},
                    {"m",  NULL_CHAR, "is_consonent", ANUSVARA, 0 },
                    {"m",  NULL_CHAR, "is_extension", ANUSVARA, 0},
                    {"m",  NULL_CHAR, "is_vowel", ANUSVARA, 0 },
                    {"m",  NULL_CHAR, NULL_CHAR, ""+CONS_m + VIRAMA, 0 },

                    {"M",  NULL_CHAR, VIRAMA, ANUSVARA, 1 },
                    {"M",  NULL_CHAR, "is_consonent", ANUSVARA, 0 },
                    {"M",  NULL_CHAR, NULL_CHAR, ANUSVARA, 0 },

                    {"n",  NULL_CHAR, '~', ""+CONS_INI+VIRAMA, 1 },
                    {"n",  NULL_CHAR, VIRAMA, ""+CONS_n + VIRAMA, 0 },
                    {"n",  NULL_CHAR, NULL_CHAR, ""+CONS_n + VIRAMA, 0 },

                    {"N", NULL_CHAR, NULL_CHAR, ""+CONS_N+VIRAMA, 0},

                    {"R",  NULL_CHAR, VIRAMA, EXT_R, 1 },
                    {"R",  NULL_CHAR, ANUSVARA, ""+CONS_m + EXT_R, 1 },
                    {"R",  NULL_CHAR, "is_consonent", EXT_R, 0 },
                    {"R",  NULL_CHAR, NULL_CHAR, VOW_R, 0 },

                    {"b", NULL_CHAR, NULL_CHAR, ""+CONS_b+VIRAMA, 0},

                    {"B", NULL_CHAR, NULL_CHAR, ""+CONS_B+VIRAMA, 0},

                    {"c", NULL_CHAR, NULL_CHAR, ""+CONS_c+VIRAMA, 0},

                    {"C", NULL_CHAR, NULL_CHAR, ""+CONS_C+VIRAMA, 0},

                    {"d", NULL_CHAR, NULL_CHAR, ""+CONS_d+VIRAMA, 0},

                    {"D", NULL_CHAR, NULL_CHAR, ""+CONS_D+VIRAMA, 0},

                    {"f", NULL_CHAR, NULL_CHAR, ""+CONS_P+VIRAMA, 0},

                    {"F", NULL_CHAR, NULL_CHAR, ""+CONS_P+VIRAMA, 0},

                    {"g", NULL_CHAR, NULL_CHAR, ""+CONS_g+VIRAMA, 0},

                    {"G", NULL_CHAR, NULL_CHAR, ""+CONS_G+VIRAMA, 0},

                    {"j", NULL_CHAR, NULL_CHAR, ""+CONS_j+VIRAMA, 0},

                    {"J", NULL_CHAR, NULL_CHAR, ""+CONS_J+VIRAMA, 0},

                    {"k", NULL_CHAR, NULL_CHAR, ""+CONS_k+VIRAMA, 0},

                    {"K", NULL_CHAR, NULL_CHAR, ""+CONS_K+VIRAMA, 0},

                    {"l", NULL_CHAR, NULL_CHAR, ""+CONS_l+VIRAMA, 0},

                    {"L", NULL_CHAR, NULL_CHAR, ""+CONS_L+VIRAMA, 0},

                    {"p", NULL_CHAR, NULL_CHAR, ""+CONS_p+VIRAMA, 0},

                    {"P", NULL_CHAR, NULL_CHAR, ""+CONS_P+VIRAMA, 0},

                    {"q", NULL_CHAR, NULL_CHAR, ""+CONS_q+VIRAMA, 0},

                    {"Q", NULL_CHAR, NULL_CHAR, ""+CONS_q+VIRAMA, 0},

                    {"r",  NULL_CHAR, '~', ""+CONS_BANDI_RA+VIRAMA, 1 },
                    {"r", NULL_CHAR, NULL_CHAR, ""+CONS_r+VIRAMA, 0},

                    {"s", NULL_CHAR, NULL_CHAR, ""+CONS_s+VIRAMA, 0},

                    {"S", NULL_CHAR, NULL_CHAR, ""+CONS_S+VIRAMA, 0},

                    {"t", NULL_CHAR, NULL_CHAR, ""+CONS_t+VIRAMA, 0},

                    {"T", NULL_CHAR, NULL_CHAR, ""+CONS_T+VIRAMA, 0},

                    {"v", NULL_CHAR, NULL_CHAR, ""+CONS_v+VIRAMA, 0},

                    {"w", NULL_CHAR, NULL_CHAR, ""+CONS_v+VIRAMA, 0},

                    {"x", NULL_CHAR, NULL_CHAR, ""+CONS_k+VIRAMA+CONS_sh+VIRAMA, 0},

                    {"y", NULL_CHAR, NULL_CHAR, ""+CONS_y+VIRAMA, 0},

                    {"z", NULL_CHAR, NULL_CHAR, ""+CONS_z+VIRAMA, 0},

                    {"^", NULL_CHAR, NULL_CHAR, NON_JOINER, 0 },

                    {"&",  NULL_CHAR, ANUSVARA, ""+CONS_m + VIRAMA, 1 },
                    {"&",  NULL_CHAR, NULL_CHAR, "&", 0 },

                    {" ", NULL_CHAR, ' ', ". ", 1},
                    {" ", NULL_CHAR, NULL_CHAR, " ", 0},
            };


    private HashMap<String, TransSet> hash;

    public TransEngine() {
        initStateHash();
    }

    public Trans get(String inchar, char ppchar, char pchar) {
        TransSet t = hash.get(inchar);
        if (t != null) {
            return t.get(inchar, ppchar, pchar);
        }

        return null;
    }

    public Trans get(char inchar, char ppchar, char pchar) {
        String instr = String.valueOf(inchar);
        System.out.println("get: inchar:[" + inchar + "] ppchar: [" + ppchar + "] pchar: [" + pchar + "]");
        return get(instr, ppchar, pchar);
    }

    private void initStateHash() {
        hash = new HashMap<String, TransSet>();
        int row_count = 0;

        for (Object state: states) {
            Object[] data = (Object[]) state;
            TransSet trans = hash.get(data[0]);
            if (trans == null) {
                trans = new TransSet();
                hash.put((String)data[0], trans);
            }
            row_count++;
            System.out.println("Input (" + row_count + "): [" + data[0] + "] [" + data[1] + "] [" + data[2] + "] [" + data[3] + "] [" + data[4] + "]");
            String outStr = String.valueOf(data[3]);
            Trans transition = new Trans((String)data[0], (char)data[1], 'a', outStr, (int)data[4]);
            if (data[2].equals("is_consonent")) {
                transition.setPrevCharMatch(
                        new Trans.MatchFunction() {
                            public boolean match(char ch){
                                return (ch>=CONS_k && ch<=CONS_h);
                            }
                        }
                );
            }
            else if (data[2].equals("is_extension")) {
                transition.setPrevCharMatch(
                        new Trans.MatchFunction() {
                            public boolean match(char ch){
                                return (ch== EXT_AI || ch == EXT_OU || ch == EXT_A || ch == EXT_E || ch == EXT_I ||
                                        ch == EXT_O || ch == EXT_R || ch == EXT_RR || ch == EXT_U || ch == EXT_e ||
                                        ch == EXT_i || ch == EXT_o || ch == EXT_u);
                            }
                        }
                );
            }
            else if (data[2].equals("is_vowel")) {
                transition.setPrevCharMatch(
                        new Trans.MatchFunction() {
                            public boolean match(char ch){
                                return ( (ch>=VOW_a && ch<=VOW_R) || ch==VOW_RR || ch==VOW_aloo);
                            }
                        }
                );
            }
            else {
                transition.setPrevChar((char)data[2]);
            }

            trans.add(transition);
            if (transition.prevChar == NULL_CHAR && transition.prevPrevChar == NULL_CHAR) {
                trans.setDefaultTrans(transition);
            }

        }

    }
}


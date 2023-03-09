package com.itextpdf.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;
import kotlin.jvm.internal.CharCompanionObject;

public class TernaryTree implements Cloneable, Serializable {
    protected static final int BLOCK_SIZE = 2048;
    private static final long serialVersionUID = 5313366505322983510L;

    /* renamed from: eq */
    protected char[] f1451eq;
    protected char freenode;

    /* renamed from: hi */
    protected char[] f1452hi;

    /* renamed from: kv */
    protected CharVector f1453kv;
    protected int length;

    /* renamed from: lo */
    protected char[] f1454lo;
    protected char root;

    /* renamed from: sc */
    protected char[] f1455sc;

    TernaryTree() {
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.root = 0;
        this.freenode = 1;
        this.length = 0;
        this.f1454lo = new char[2048];
        this.f1452hi = new char[2048];
        this.f1451eq = new char[2048];
        this.f1455sc = new char[2048];
        this.f1453kv = new CharVector();
    }

    public void insert(String str, char c) {
        int length2 = str.length() + 1;
        int i = this.freenode + length2;
        char[] cArr = this.f1451eq;
        if (i > cArr.length) {
            redimNodeArrays(cArr.length + 2048);
        }
        int i2 = length2 - 1;
        char[] cArr2 = new char[length2];
        str.getChars(0, i2, cArr2, 0);
        cArr2[i2] = 0;
        this.root = insert(this.root, cArr2, 0, c);
    }

    public void insert(char[] cArr, int i, char c) {
        int strlen = this.freenode + strlen(cArr) + 1;
        char[] cArr2 = this.f1451eq;
        if (strlen > cArr2.length) {
            redimNodeArrays(cArr2.length + 2048);
        }
        this.root = insert(this.root, cArr, i, c);
    }

    private char insert(char c, char[] cArr, int i, char c2) {
        int strlen = strlen(cArr, i);
        if (c == 0) {
            char c3 = this.freenode;
            this.freenode = (char) (c3 + 1);
            this.f1451eq[c3] = c2;
            this.length++;
            this.f1452hi[c3] = 0;
            if (strlen > 0) {
                this.f1455sc[c3] = CharCompanionObject.MAX_VALUE;
                this.f1454lo[c3] = (char) this.f1453kv.alloc(strlen + 1);
                strcpy(this.f1453kv.getArray(), this.f1454lo[c3], cArr, i);
            } else {
                this.f1455sc[c3] = 0;
                this.f1454lo[c3] = 0;
            }
            return c3;
        }
        char[] cArr2 = this.f1455sc;
        if (cArr2[c] == 65535) {
            char c4 = this.freenode;
            this.freenode = (char) (c4 + 1);
            char[] cArr3 = this.f1454lo;
            cArr3[c4] = cArr3[c];
            char[] cArr4 = this.f1451eq;
            cArr4[c4] = cArr4[c];
            cArr3[c] = 0;
            if (strlen > 0) {
                cArr2[c] = this.f1453kv.get(cArr3[c4]);
                this.f1451eq[c] = c4;
                char[] cArr5 = this.f1454lo;
                cArr5[c4] = (char) (cArr5[c4] + 1);
                if (this.f1453kv.get(cArr5[c4]) == 0) {
                    this.f1454lo[c4] = 0;
                    this.f1455sc[c4] = 0;
                    this.f1452hi[c4] = 0;
                } else {
                    this.f1455sc[c4] = CharCompanionObject.MAX_VALUE;
                }
            } else {
                cArr2[c4] = CharCompanionObject.MAX_VALUE;
                this.f1452hi[c] = c4;
                cArr2[c] = 0;
                cArr4[c] = c2;
                this.length++;
                return c;
            }
        }
        char c5 = cArr[i];
        char[] cArr6 = this.f1455sc;
        if (c5 < cArr6[c]) {
            char[] cArr7 = this.f1454lo;
            cArr7[c] = insert(cArr7[c], cArr, i, c2);
        } else if (c5 != cArr6[c]) {
            char[] cArr8 = this.f1452hi;
            cArr8[c] = insert(cArr8[c], cArr, i, c2);
        } else if (c5 != 0) {
            char[] cArr9 = this.f1451eq;
            cArr9[c] = insert(cArr9[c], cArr, i + 1, c2);
        } else {
            this.f1451eq[c] = c2;
        }
        return c;
    }

    public static int strcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr[i] == cArr2[i2]) {
            if (cArr[i] == 0) {
                return 0;
            }
            i++;
            i2++;
        }
        return cArr[i] - cArr2[i2];
    }

    public static int strcmp(String str, char[] cArr, int i) {
        int length2 = str.length();
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + i2;
            int charAt = str.charAt(i2) - cArr[i3];
            if (charAt != 0 || cArr[i3] == 0) {
                return charAt;
            }
            i2++;
        }
        int i4 = i + i2;
        if (cArr[i4] != 0) {
            return -cArr[i4];
        }
        return 0;
    }

    public static void strcpy(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr2[i2] != 0) {
            cArr[i] = cArr2[i2];
            i++;
            i2++;
        }
        cArr[i] = 0;
    }

    public static int strlen(char[] cArr, int i) {
        int i2 = 0;
        while (i < cArr.length && cArr[i] != 0) {
            i2++;
            i++;
        }
        return i2;
    }

    public static int strlen(char[] cArr) {
        return strlen(cArr, 0);
    }

    public int find(String str) {
        int length2 = str.length();
        char[] cArr = new char[(length2 + 1)];
        str.getChars(0, length2, cArr, 0);
        cArr[length2] = 0;
        return find(cArr, 0);
    }

    public int find(char[] cArr, int i) {
        char c = this.root;
        while (c != 0) {
            char[] cArr2 = this.f1455sc;
            if (cArr2[c] != 65535) {
                char c2 = cArr[i];
                int i2 = c2 - cArr2[c];
                if (i2 == 0) {
                    if (c2 == 0) {
                        return this.f1451eq[c];
                    }
                    i++;
                    c = this.f1451eq[c];
                } else if (i2 < 0) {
                    c = this.f1454lo[c];
                } else {
                    c = this.f1452hi[c];
                }
            } else if (strcmp(cArr, i, this.f1453kv.getArray(), this.f1454lo[c]) == 0) {
                return this.f1451eq[c];
            } else {
                return -1;
            }
        }
        return -1;
    }

    public boolean knows(String str) {
        return find(str) >= 0;
    }

    private void redimNodeArrays(int i) {
        char[] cArr = this.f1454lo;
        int length2 = i < cArr.length ? i : cArr.length;
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, length2);
        this.f1454lo = cArr2;
        char[] cArr3 = new char[i];
        System.arraycopy(this.f1452hi, 0, cArr3, 0, length2);
        this.f1452hi = cArr3;
        char[] cArr4 = new char[i];
        System.arraycopy(this.f1451eq, 0, cArr4, 0, length2);
        this.f1451eq = cArr4;
        char[] cArr5 = new char[i];
        System.arraycopy(this.f1455sc, 0, cArr5, 0, length2);
        this.f1455sc = cArr5;
    }

    public int size() {
        return this.length;
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.f1454lo = (char[]) this.f1454lo.clone();
        ternaryTree.f1452hi = (char[]) this.f1452hi.clone();
        ternaryTree.f1451eq = (char[]) this.f1451eq.clone();
        ternaryTree.f1455sc = (char[]) this.f1455sc.clone();
        ternaryTree.f1453kv = (CharVector) this.f1453kv.clone();
        ternaryTree.root = this.root;
        ternaryTree.freenode = this.freenode;
        ternaryTree.length = this.length;
        return ternaryTree;
    }

    /* access modifiers changed from: protected */
    public void insertBalanced(String[] strArr, char[] cArr, int i, int i2) {
        if (i2 >= 1) {
            int i3 = i2 >> 1;
            int i4 = i3 + i;
            insert(strArr[i4], cArr[i4]);
            insertBalanced(strArr, cArr, i, i3);
            insertBalanced(strArr, cArr, i4 + 1, (i2 - i3) - 1);
        }
    }

    public void balance() {
        int i = this.length;
        String[] strArr = new String[i];
        char[] cArr = new char[i];
        Iterator iterator = new Iterator();
        int i2 = 0;
        while (iterator.hasMoreElements()) {
            cArr[i2] = iterator.getValue();
            strArr[i2] = iterator.nextElement();
            i2++;
        }
        init();
        insertBalanced(strArr, cArr, 0, i);
    }

    public void trimToSize() {
        balance();
        redimNodeArrays(this.freenode);
        CharVector charVector = new CharVector();
        charVector.alloc(1);
        compact(charVector, new TernaryTree(), this.root);
        this.f1453kv = charVector;
        charVector.trimToSize();
    }

    private void compact(CharVector charVector, TernaryTree ternaryTree, char c) {
        if (c != 0) {
            if (this.f1455sc[c] == 65535) {
                int find = ternaryTree.find(this.f1453kv.getArray(), this.f1454lo[c]);
                if (find < 0) {
                    find = charVector.alloc(strlen(this.f1453kv.getArray(), this.f1454lo[c]) + 1);
                    strcpy(charVector.getArray(), find, this.f1453kv.getArray(), this.f1454lo[c]);
                    ternaryTree.insert(charVector.getArray(), find, (char) find);
                }
                this.f1454lo[c] = (char) find;
                return;
            }
            compact(charVector, ternaryTree, this.f1454lo[c]);
            if (this.f1455sc[c] != 0) {
                compact(charVector, ternaryTree, this.f1451eq[c]);
            }
            compact(charVector, ternaryTree, this.f1452hi[c]);
        }
    }

    public Enumeration<String> keys() {
        return new Iterator();
    }

    public class Iterator implements Enumeration<String> {
        int cur = -1;
        String curkey;

        /* renamed from: ks */
        StringBuffer f1456ks = new StringBuffer();

        /* renamed from: ns */
        Stack<Item> f1457ns = new Stack<>();

        private class Item implements Cloneable {
            char child;
            char parent;

            public Item() {
                this.parent = 0;
                this.child = 0;
            }

            public Item(char c, char c2) {
                this.parent = c;
                this.child = c2;
            }

            public Item clone() {
                return new Item(this.parent, this.child);
            }
        }

        public Iterator() {
            rewind();
        }

        public void rewind() {
            this.f1457ns.removeAllElements();
            this.f1456ks.setLength(0);
            this.cur = TernaryTree.this.root;
            run();
        }

        public String nextElement() {
            String str = this.curkey;
            this.cur = m977up();
            run();
            return str;
        }

        public char getValue() {
            if (this.cur >= 0) {
                return TernaryTree.this.f1451eq[this.cur];
            }
            return 0;
        }

        public boolean hasMoreElements() {
            return this.cur != -1;
        }

        /* renamed from: up */
        private int m977up() {
            new Item();
            if (this.f1457ns.empty()) {
                return -1;
            }
            if (this.cur != 0 && TernaryTree.this.f1455sc[this.cur] == 0) {
                return TernaryTree.this.f1454lo[this.cur];
            }
            boolean z = true;
            char c = 0;
            while (z) {
                Item pop = this.f1457ns.pop();
                pop.child = (char) (pop.child + 1);
                char c2 = pop.child;
                if (c2 != 1) {
                    if (c2 == 2) {
                        c = TernaryTree.this.f1452hi[pop.parent];
                        this.f1457ns.push(pop.clone());
                        if (this.f1456ks.length() > 0) {
                            StringBuffer stringBuffer = this.f1456ks;
                            stringBuffer.setLength(stringBuffer.length() - 1);
                        }
                    } else if (this.f1457ns.empty()) {
                        return -1;
                    } else {
                        z = true;
                    }
                } else if (TernaryTree.this.f1455sc[pop.parent] != 0) {
                    c = TernaryTree.this.f1451eq[pop.parent];
                    this.f1457ns.push(pop.clone());
                    this.f1456ks.append(TernaryTree.this.f1455sc[pop.parent]);
                } else {
                    pop.child = (char) (pop.child + 1);
                    this.f1457ns.push(pop.clone());
                    c = TernaryTree.this.f1452hi[pop.parent];
                }
                z = false;
            }
            return c;
        }

        /* JADX WARNING: type inference failed for: r4v1, types: [int] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int run() {
            /*
                r8 = this;
                int r0 = r8.cur
                r1 = -1
                if (r0 != r1) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r2 = 0
            L_0x0008:
                int r3 = r8.cur
                r4 = 65535(0xffff, float:9.1834E-41)
                r5 = 1
                if (r3 == 0) goto L_0x003d
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f1455sc
                int r6 = r8.cur
                char r3 = r3[r6]
                if (r3 != r4) goto L_0x001c
            L_0x001a:
                r2 = 1
                goto L_0x003d
            L_0x001c:
                java.util.Stack<com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item> r3 = r8.f1457ns
                com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item r7 = new com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item
                char r6 = (char) r6
                r7.<init>(r6, r0)
                r3.push(r7)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f1455sc
                int r6 = r8.cur
                char r3 = r3[r6]
                if (r3 != 0) goto L_0x0032
                goto L_0x001a
            L_0x0032:
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r3.f1454lo
                int r4 = r8.cur
                char r3 = r3[r4]
                r8.cur = r3
                goto L_0x0008
            L_0x003d:
                if (r2 == 0) goto L_0x007c
                java.lang.StringBuffer r1 = new java.lang.StringBuffer
                java.lang.StringBuffer r2 = r8.f1456ks
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r2 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r2 = r2.f1455sc
                int r3 = r8.cur
                char r2 = r2[r3]
                if (r2 != r4) goto L_0x0075
                com.itextpdf.text.pdf.hyphenation.TernaryTree r2 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r2 = r2.f1454lo
                int r3 = r8.cur
                char r2 = r2[r3]
            L_0x005c:
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.f1453kv
                char r3 = r3.get(r2)
                if (r3 == 0) goto L_0x0075
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.f1453kv
                int r4 = r2 + 1
                char r2 = r3.get(r2)
                r1.append(r2)
                r2 = r4
                goto L_0x005c
            L_0x0075:
                java.lang.String r1 = r1.toString()
                r8.curkey = r1
                return r0
            L_0x007c:
                int r3 = r8.m977up()
                r8.cur = r3
                if (r3 != r1) goto L_0x0008
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator.run():int");
        }
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.length));
        PrintStream printStream2 = System.out;
        printStream2.println("Node count = " + Integer.toString(this.freenode));
        PrintStream printStream3 = System.out;
        printStream3.println("Key Array length = " + Integer.toString(this.f1453kv.length()));
    }
}

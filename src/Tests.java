
class Tests {
    //������(3 �����)
    public static final boolean[][] STARS = new boolean[][] {
        {false, true, false, false, true, true, false, false, false, false},
        {true, false, true, false, false, false, false, false, false, true},
        {false, true, false, false, false, false, true, false, true, false},
        {false, false, false, false, true, false, true, false, false, true},
        {true, false, false, true, false, false, false, false, true, false},
        {true, false, false, false, false, false, true, true, false, false},
        {false, false, true, true, false, true, false, false, false, false},
        {false, false, false, false, false, true, false, false, true, true},
        {false, false, true, false, true, false, false, true, false, false},
        {false, true, false, true, false, false, false, true, false, false}
    };
    //6 ������ (2 �����)
    public static final boolean[][] SIX = new boolean[][] {
        {false, false, true, true, false, false},
        {false, false, false, false, true, true},
        {true, false, false, false, false, true},
        {true, false, false, false, true, false},
        {false, true, false, true, false, false},
        {false, true, true, false, false, false}
    };
    //������� 8, ������ ��������� ��� ������
    public static final boolean[][] GLASES = new boolean[][] {
        {false, true, true, true, false, false, false, false, false, false, false, false},
        {true, false, false, true, false, false, true, false, false, false, false, false},
        {true, false, false, true, true, false, false, false, false, false, false, false},
        {true, true, true, false, true, true, false, false, false, false, false, false},
        {false, false, true, true, false, true, false, false, false, false, false, false},
        {false, false, false, true, true, false, true, false, false, false, false, false},
        {false, true, false, false, false, true, false, true, true, true, false, false},
        {false, false, false, false, false, false, true, false, true, false, true, false},
        {false, false, false, false, false, false, true, true, false, true, true, true},
        {false, false, false, false, false, false, true, false, true, false, false, true},
        {false, false, false, false, false, false, false, true, true, false, false, false},
        {false, false, false, false, false, false, false, false, true, true, false, false}
    };
    //������� � ����������� ��������� ����� ��������
    public static final boolean[][] KVAD_TREU = new boolean[][] {
        {false, false, true, true, true, false, false, false, false, false, false},
        {false, false, true, true, false, true, true, false, false, true, true},
        {true, true, false, false, true, true, false, false, false, false, false},
        {true, true, false, false, true, false, false, false, false, false, false},
        {true, false, true, true, false, true, false, false, false, false, false},
        {false, true, true, false, true, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, true, false, false},
        {false, false, false, false, false, false, true, false, true, true, false},
        {false, false, false, false, false, false, true, true, false, false, true},
        {false, true, false, false, false, false, false, true, false, false, true},
        {false, true, false, false, false, false, false, false, true, true, false}
    };
    //������� � ��������
    public static final boolean[][] KVAD_KVAD = new boolean[][] {
        {false, true, false, true, true, false, false, true},
        {true, false, true, false, true, true, false, false},
        {false, true, false, true, false, true, true, false},
        {true, false, true, false, false, false, true, true},
        {true, true, false, false, false, true, true, true},
        {false, true, true, false, true, false, true, true},
        {false, false, true, true, true, true, false, true},
        {true, false, false, true, true, true, true, false}
    };
    public static final boolean[][] KVAD_FOUR = new boolean[][] {
        {false, true, false, true, true, false, false, true, false, false, false, false, false, false, false, false},
        {true, false, true, false, true, true, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, true, false, true, true, false, false, false, false, false, false, false, false, false},
        {true, false, true, false, false, false, true, true, false, false, false, false, false, false, false, false},
        {true, true, false, false, false, true, true, true, false, false, false, false, false, false, false, false},
        {false, true, true, false, true, false, true, true, false, false, false, false, false, false, false, false},
        {false, false, true, true, true, true, false, true, false, false, false, false, false, false, false, false},
        {true, false, false, true, true, true, true, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, true, true, false, false, true},
        {false, false, false, false, false, false, false, false, true, false, true, false, true, true, false, false},
        {false, false, false, false, false, false, false, false, false, true, false, true, false, true, true, false},
        {false, false, false, false, false, false, false, false, true, false, true, false, false, false, true, true},
        {false, false, false, false, false, false, false, false, true, true, false, false, false, true, true, true},
        {false, false, false, false, false, false, false, false, false, true, true, false, true, false, true, true},
        {false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, true},
        {false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, false},
    };
    public static final boolean[][] ANO_TEST_ONE = new boolean[][] {
        {false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static final boolean[][] ANO_TEST_TWO = new boolean[][] {
        {false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };
    public static final boolean[][] ANO_TEST_THREE = new boolean[][] {
        {false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true, false, false, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true, true, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, true, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, true, true, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, true, false, true, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, false}

    };
    public static final boolean[][] FIVE = new boolean[][] {
            {false, true, true, true, true},
            {true, false, true, true, true},
            {true, true, false, true, true},
            {true, true, true, false, true},
            {true, true, true, true, false},
    };
}

package DivineChili;

public enum KeyboardNotes {
    C1(48),
    Cs1(49),
    D1(50),
    Eb1(51),
    E1(52),
    F1(53),
    Fs1(54),
    G1(55),
    Gs1(56),
    A1(57),
    Bb1(58),
    B1(59),
    C2(60),
    Cs2(61),
    D2(62),
    Eb2(63),
    E2(64),
    F2(65),
    Fs2(66),
    G2(67),
    Gs2(68),
    A2(69),
    Bb2(70),
    B2(71),
    C3(72),
    Cs3(73),
    D3(74),
    Eb3(75),
    E3(76),
    F3(77),
    Fs3(78),
    G3(79),
    Gs3(80),
    A3(81),
    Bb3(82),
    B3(83),
    C4(84);


    private final int id;
    KeyboardNotes(int id) { this.id = id; }
    public int getValue() { return id; }
}
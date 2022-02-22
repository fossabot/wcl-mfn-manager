package com.wcl.mfnmanager.services.draft.downloader;

import java.util.Arrays;
import java.util.Optional;

public enum PositionFilter {
    ALL(""),
    QB("1"),
    RB("2"),
    FB("3"),
    TE("4"),
    WR("5"),
    LT("7"),
    LG("8"),
    C("9"),
    RG("10"),
    RT("11"),
    P("12"),
    K("13"),
    LDE("14"),
    DT("15"),
    RDE("16"),
    SLB("19"),
    MLB("21"),
    WLB("23"),
    CB("24"),
    SS("26"),
    FS("27"),
    KH("28"),
    LS("29"),
    KR("30"),
    PR("31"),
    GUNNER("32"),
    KO("33"),
    FGK("34"),
    STBLK("35"),
    STRUSH("36");


    private final String position;

    PositionFilter(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public Optional<PositionFilter> getPositionFilterForPosition(String position) {
        return Arrays.stream(PositionFilter.values()).filter(a -> position.equals(a.getPosition())).findFirst();
    }
}

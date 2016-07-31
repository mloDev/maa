package de.mlo.enums;

public enum Resone {
	krank("krank"),
	NFWechsel("NF-Wechsel"),
	StGWechsel("StG-Wechsel"),
	keineZulassung("keine Zulassung"),
	persGründe("pers. Gründe");

    private final String displayName;

    Resone(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

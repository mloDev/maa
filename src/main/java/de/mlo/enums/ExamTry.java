package de.mlo.enums;

public enum ExamTry {
	
	ersterVersuch("1. Versuch"),
	zweiterVersuch("2. Versuch"),
	mdlFortsetzung("mdl. Forsetzung"),
	dritterVersuch("3. Versuch"),
	wmdlFortsetzung("mdl. Forsetzung");

    private final String displayName;

    ExamTry(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}

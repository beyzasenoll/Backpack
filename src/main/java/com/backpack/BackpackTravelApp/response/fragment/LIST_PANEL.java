package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_PANEL {
    MINI_RULES_DICTIONARY MINI_RULES_DICTIONARYObject;
    LIST_TAB LIST_TABObject;
    SEARCH_DATA SEARCH_DATAObject;
    private boolean IS_LOADED_FROM_CACHE;
    ArrayList<Object> LIST_OC_RECOMMENDATION = new ArrayList<Object>();
    MINIRULES_TYPE_QUALIFIER_DICTIONARY MINIRULES_TYPE_QUALIFIER_DICTIONARYObject;
    private String TYPE;


    // Getter Methods

    public MINI_RULES_DICTIONARY getMINI_RULES_DICTIONARY() {
        return MINI_RULES_DICTIONARYObject;
    }

    public LIST_TAB getLIST_TAB() {
        return LIST_TABObject;
    }

    public SEARCH_DATA getSEARCH_DATA() {
        return SEARCH_DATAObject;
    }

    public boolean getIS_LOADED_FROM_CACHE() {
        return IS_LOADED_FROM_CACHE;
    }

    public MINIRULES_TYPE_QUALIFIER_DICTIONARY getMINIRULES_TYPE_QUALIFIER_DICTIONARY() {
        return MINIRULES_TYPE_QUALIFIER_DICTIONARYObject;
    }

    public String getTYPE() {
        return TYPE;
    }

    // Setter Methods

    public void setMINI_RULES_DICTIONARY(MINI_RULES_DICTIONARY MINI_RULES_DICTIONARYObject) {
        this.MINI_RULES_DICTIONARYObject = MINI_RULES_DICTIONARYObject;
    }

    public void setLIST_TAB(LIST_TAB LIST_TABObject) {
        this.LIST_TABObject = LIST_TABObject;
    }

    public void setSEARCH_DATA(SEARCH_DATA SEARCH_DATAObject) {
        this.SEARCH_DATAObject = SEARCH_DATAObject;
    }

    public void setIS_LOADED_FROM_CACHE(boolean IS_LOADED_FROM_CACHE) {
        this.IS_LOADED_FROM_CACHE = IS_LOADED_FROM_CACHE;
    }

    public void setMINIRULES_TYPE_QUALIFIER_DICTIONARY(MINIRULES_TYPE_QUALIFIER_DICTIONARY MINIRULES_TYPE_QUALIFIER_DICTIONARYObject) {
        this.MINIRULES_TYPE_QUALIFIER_DICTIONARYObject = MINIRULES_TYPE_QUALIFIER_DICTIONARYObject;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
}

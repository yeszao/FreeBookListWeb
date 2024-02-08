package com.runlala.scaffold.enums;

public enum Language {
    AF("Afrikaans"),
    AR("العربية"),
    BG("Български"),
    BN("বাংলা"),
    BS("Bosnian"),
    CA("Català"),
    CS("Čeština"),
    CY("Cymraeg"),
    DA("Dansk"),
    DE("Deutsch"),
    EL("Ελληνικά"),
    EN("English"),
    ES("Español"),
    ET("Eesti"),
    FA("فارسی"),
    FI("Suomi"),
    FR("Français"),
    HE("עברית"),
    HI("हिन्दी"),
    HR("Hrvatski"),
    HU("Magyar"),
    ID("Indonesia"),
    IS("Íslenska"),  // Note: Java does not support variable names starting with an underscore
    IT("Italiano"),
    JA("日本語"),
    KO("한국어"),
    LT("Lietuvių"),
    LV("Latviešu"),
    MS("Melayu"),
    MT("Malti"),
    MWW("Hmong Daw"),
    NB("Norsk Bokmål"),
    NL("Nederlands"),
    PL("Polski"),
    PT("Português (Brasil)"),
    RO("Română"),
    RU("Русский"),
    SK("Slovenčina"),
    SL("Slovenščina"),
    SR_LATN("Srpski (latinica)"),
    SV("Svenska"),
    SW("Kiswahili"),
    TA("தமிழ்"),
    TH("ไทย"),
    TLH_LATN("Klingon (Latin)"),
    TR("Türkçe"),
    UK("Українська"),
    UR("اردو"),
    VI("Tiếng Việt"),
    ZH_HANS("中文 (简体)");

    private final String nativeName;

    Language(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNativeName() {
        return nativeName;
    }

}

package ir.rainyday.fontmanager;

import androidx.annotation.NonNull;
import android.text.TextUtils;

public class AppFont {

    //region fields
    private @NonNull
    int id = 0;
    private @NonNull
    String familyName;
    private @NonNull
    String fontPath;
    private @NonNull
    String defaultFont;
    private @NonNull
    String fontExtension;

    private String thin;
    private String extraLight;
    private String light;
    private String regular;
    private String medium;
    private String semiBold;
    private String bold;
    private String extraBold;
    private String black;
    //endregion

    //region getters
    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getFamilyName() {
        return familyName;
    }

    @NonNull
    public String getFontPath() {
        return fontPath;
    }

    @NonNull
    public String getDefaultFont() {
        return defaultFont;
    }

    @NonNull
    public String getDefaultFontPath() {
        return getFullPath(defaultFont);
    }

    @NonNull
    public String getFontExtension() {
        return fontExtension;
    }

    @NonNull
    public String getThin() {
        return getNonNullFont(thin);
    }

    @NonNull
    public String getThinPath() {
        return getFullPath(thin);
    }

    @NonNull
    public String getExtraLight() {
        return getNonNullFont(extraLight);
    }

    @NonNull
    public String getExtraLightPath() {
        return getFullPath(extraLight);
    }

    @NonNull
    public String getLight() {
        return getNonNullFont(light);
    }

    @NonNull
    public String getLightPath() {
        return getFullPath(light);
    }

    @NonNull
    public String getRegular() {
        return getNonNullFont(regular);
    }

    @NonNull
    public String getRegularPath() {
        return getFullPath(regular);
    }

    @NonNull
    public String getMedium() {
        return getNonNullFont(medium);
    }

    @NonNull
    public String getMediumPath() {
        return getFullPath(medium);
    }

    @NonNull
    public String getSemiBold() {
        return getNonNullFont(semiBold);
    }

    @NonNull
    public String getSemiBoldPath() {
        return getFullPath(semiBold);
    }

    @NonNull
    public String getBold() {
        return getNonNullFont(bold);
    }

    @NonNull
    public String getBoldPath() {
        return getFullPath(bold);
    }

    @NonNull
    public String getExtraBold() {
        return getNonNullFont(extraBold);
    }

    @NonNull
    public String getExtraBoldPath() {
        return getFullPath(extraBold);
    }

    @NonNull
    public String getBlack() {
        return getNonNullFont(black);
    }

    @NonNull
    public String getBlackPath() {
        return getFullPath(black);
    }


    //helpers
    private String getFullPath(String font) {
        return String.format("%s%s.%s", getFontPath(), getNonNullFont(font), getFontExtension());
    }

    private String getNonNullFont(String font) {
        return (font != null && !TextUtils.isEmpty(font)) ? font : getDefaultFont();
    }

    //endregion

    //region builder
    public AppFont(@NonNull int id, @NonNull String familyName, @NonNull String fontPath, @NonNull String defaultFont, @NonNull String fontExtension, String extraLight, String thin, String light, String regular, String medium, String semiBold, String bold, String extraBold, String black) {
        this.id = id;
        this.familyName = familyName;
        this.fontPath = fontPath;
        this.defaultFont = defaultFont;
        this.fontExtension = fontExtension.startsWith(".") ? fontExtension.replace(".", "") : fontExtension;
        this.extraLight = extraLight;
        this.thin = thin;
        this.light = light;
        this.regular = regular;
        this.medium = medium;
        this.semiBold = semiBold;
        this.bold = bold;
        this.extraBold = extraBold;
        this.black = black;
    }

    public static class AppFontBuilder {
        private @NonNull
        int nestedId;
        private @NonNull
        String nestedFamilyName;
        private @NonNull
        String nestedFontPath;
        private @NonNull
        String nestedDefaultFont;
        @NonNull
        private String nestedFontExtension;

        private String nestedThin;
        private String nestedExtraLight;
        private String nestedLight;
        private String nestedRegular;
        private String nestedMedium;
        private String nestedSemiBold;
        private String nestedBold;
        private String nestedExtraBold;
        private String nestedBlack;


        public AppFontBuilder(@NonNull int id  , @NonNull String familyName, @NonNull String fontPath, @NonNull String defaultFont, @NonNull String fontExtension) {
            this.nestedId = id;
            this.nestedFamilyName = familyName;
            this.nestedFontPath = fontPath;
            this.nestedDefaultFont = defaultFont;
            this.nestedFontExtension = fontExtension;
        }


        public AppFontBuilder thin(String thin) {
            this.nestedThin = thin;
            return this;
        }

        public AppFontBuilder extraLight(String extraLight) {
            this.nestedExtraLight = extraLight;
            return this;
        }

        public AppFontBuilder light(String light) {
            this.nestedLight = light;
            return this;
        }

        public AppFontBuilder regular(String regular) {
            this.nestedRegular = regular;
            return this;
        }

        public AppFontBuilder medium(String medium) {
            this.nestedMedium = medium;
            return this;
        }

        public AppFontBuilder semiBold(String semiBold) {
            this.nestedSemiBold = semiBold;
            return this;
        }

        public AppFontBuilder bold(String bold) {
            this.nestedBold = bold;
            return this;
        }

        public AppFontBuilder extraBold(String extraBold) {
            this.nestedExtraBold = extraBold;
            return this;
        }

        public AppFontBuilder black(String black) {
            this.nestedBlack = black;
            return this;
        }

        public AppFont build()
        {
            return new AppFont(nestedId,
                    nestedFamilyName,
                    nestedFontPath,
                    nestedDefaultFont,
                    nestedFontExtension,
                    nestedExtraLight,
                    nestedThin,
                    nestedLight,
                    nestedRegular,
                    nestedMedium,
                    nestedSemiBold,
                    nestedBold,
                    nestedExtraBold,
                    nestedBlack);
        }
    }
    //endregion

    //region equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppFont appFont = (AppFont) o;

        if (id != appFont.id) return false;
        if (!familyName.equals(appFont.familyName)) return false;
        if (!fontPath.equals(appFont.fontPath)) return false;
        if (!defaultFont.equals(appFont.defaultFont)) return false;
        if (!fontExtension.equals(appFont.fontExtension)) return false;
        if (extraLight != null ? !extraLight.equals(appFont.extraLight) : appFont.extraLight != null)
            return false;
        if (thin != null ? !thin.equals(appFont.thin) : appFont.thin != null) return false;
        if (light != null ? !light.equals(appFont.light) : appFont.light != null) return false;
        if (regular != null ? !regular.equals(appFont.regular) : appFont.regular != null)
            return false;
        if (medium != null ? !medium.equals(appFont.medium) : appFont.medium != null) return false;
        if (semiBold != null ? !semiBold.equals(appFont.semiBold) : appFont.semiBold != null)
            return false;
        if (bold != null ? !bold.equals(appFont.bold) : appFont.bold != null) return false;
        if (extraBold != null ? !extraBold.equals(appFont.extraBold) : appFont.extraBold != null) return false;
        return black != null ? black.equals(appFont.black) : appFont.black == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + familyName.hashCode();
        result = 31 * result + fontPath.hashCode();
        result = 31 * result + defaultFont.hashCode();
        result = 31 * result + fontExtension.hashCode();
        result = 31 * result + (extraLight != null ? extraLight.hashCode() : 0);
        result = 31 * result + (thin != null ? thin.hashCode() : 0);
        result = 31 * result + (light != null ? light.hashCode() : 0);
        result = 31 * result + (regular != null ? regular.hashCode() : 0);
        result = 31 * result + (medium != null ? medium.hashCode() : 0);
        result = 31 * result + (semiBold != null ? semiBold.hashCode() : 0);
        result = 31 * result + (bold != null ? bold.hashCode() : 0);
        result = 31 * result + (extraBold != null ? extraBold.hashCode() : 0);
        result = 31 * result + (black != null ? black.hashCode() : 0);
        return result;
    }

    //endregion
}

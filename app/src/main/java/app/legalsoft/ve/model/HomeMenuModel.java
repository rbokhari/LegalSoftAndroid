package app.legalsoft.ve.model;

/**
 * Created by Syed.Rahman on 15/03/2015.
 */
public class HomeMenuModel {
    String TitleText;
    int TitleIcon;

    public HomeMenuModel(String titleText, int titleIcon) {
        TitleText = titleText;
        TitleIcon = titleIcon;
    }

    public String getTitleText() {
        return TitleText;
    }

    public int getTitleIcon() {
        return TitleIcon;
    }
}

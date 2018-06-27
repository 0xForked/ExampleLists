package id.aasumitro.gridimpl.recycler;

public class ModelRecycler {

    private String mTitle;
    private int mImage;

    public ModelRecycler(String title, int image) {

        this.mTitle = title;

        this.mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImage() {
        return mImage;
    }


}

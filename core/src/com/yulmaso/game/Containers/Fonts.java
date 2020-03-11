package com.yulmaso.game.Containers;

public enum Fonts {

    NUMBERS_SMALL("numbers-small.png", 7, 10, 10, 1),
    NUMBERS_MEDIUM("numbers-medium.png", 14, 20, 10, 1);

    String nameOfPic;
    int tileWidth;
    int tileHeight;
    int numberOfColumns;
    int numberOfRows;

    Fonts(String nameOfPic, int tileWidth, int tileHeight, int numberOfColumns, int numberOfRows){
        this.nameOfPic = nameOfPic;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    public String getNameOfPic() {
        return nameOfPic;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }
}

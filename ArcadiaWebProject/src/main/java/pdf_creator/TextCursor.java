package pdf_creator;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.IOException;

public class TextCursor {

    public enum Align {
        CENTER,
        LEFT,
        RIGHT
    }

    private float startX;
    private float startY;
    private float curentX;
    private float curentY;
    private float marginX;
    private float marginY;
    private float width;
    private float heightCounter;
    private Align alignment;

    public TextCursor() {

    }

    public TextCursor(PDPage page, float marginX, float marginY) {
        PDRectangle mediabox = page.getMediaBox();
        this.marginX = marginX;
        this.marginY = marginY;
        this.startX = mediabox.getLowerLeftX();
        this.startY = mediabox.getUpperRightY() ;
        this.curentX = startX + marginX;
        this.curentY = startY - marginY;
        this.heightCounter = curentY;
        this.width = mediabox.getWidth() - 2 * marginX;
        this.alignment = Align.LEFT;
    }

    public void setCursorToCenter(String text, PDFont font, int fontSize) throws IOException {

        float length = ( font.getStringWidth(text) / 1000f) * fontSize;
        float diff = (this.width - length) / 2;
        setCurentX(diff);
    }

    public void setCursorToLeft() {
        setCurentX(startX + marginX);
    }

    public void setCursorToRight(String text) {
        setCurentX(startX + marginX);
    }

    public void setCurentX(float curentX) {
        this.curentX = curentX;
    }

    public void setCurentY(float curentY) {
        this.curentY = curentY;
    }

    public void setMarginX(float marginX) {
        this.marginX = marginX;
    }

    public void setMarginY(float marginY) {
        this.marginY = marginY;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeightCounter(float heightCounter) {
        this.heightCounter = heightCounter;
    }

    public void setAlignment(Align alignment) {
        this.alignment = alignment;
    }

    public float getMarginX() {
        return marginX;
    }

    public float getMarginY() {
        return marginY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeightCounter() {
        return heightCounter;
    }

    public float getCurentX() {
        return curentX;
    }

    public float getCurentY() {
        return curentY;
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public Align getAlignment() {
        return alignment;
    }
}
package com.developersbd.nabannapro;

/**
 * Created by TC on 4/14/2017.
 */

public class listItem {
    private String tblHeader;
    private String nutElement;
    private String applyingMethod;


    public listItem(String tblHeader, String nutElement, String applyingMethod) {
        super();
        this.tblHeader = tblHeader;
        this.nutElement = nutElement;
        this.applyingMethod = applyingMethod;

    }

    public String getTblHeader() {
        return tblHeader;
    }

    public void setTblHeader(String tblHeader) {
        this.tblHeader = tblHeader;
    }

    public String getNutElement() {
        return nutElement;
    }

    public void setNutElement(String nutElement) {
        this.nutElement = nutElement;
    }

    public String getApplyingMethod() {
        return applyingMethod;
    }

    public void setApplyingMethod(String applyingMethod) {
        this.applyingMethod = applyingMethod;
    }




}

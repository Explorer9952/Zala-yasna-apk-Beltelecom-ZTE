package com.picovr.picovrlib;

/* loaded from: classes.dex */
public class DistortionParameters {
    private float[] ChromaticAberration;
    private int Eqn;
    private float[] InvK;
    private float[] K;
    private int MaxCoefficients;
    private float MaxInvR;
    private float MaxR;
    private float MetersPerTanAngleAtCenter;
    private int PicoManagerStutas = 0;
    private int ScreenHeight;
    private String ScreenName;
    private int ScreenRefreshDirectoin;
    private int ScreenSetupDirection;
    private int ScreenWidth;
    private double ScreenXppi;
    private double ScreenYppi;
    private float displayRefreshRate;
    private float[] eyeTextureFov;
    private int[] eyeTextureResolution;
    private float heightMeters;
    private int heightPixels;
    private float horizontalOffsetMeters;
    private float lensSeparation;
    private float widthMeters;
    private int widthPixels;

    public float[] getChromaticAberration() {
        return this.ChromaticAberration;
    }

    public float getDisplayRefreshRate() {
        return this.displayRefreshRate;
    }

    public int getEqn() {
        return this.Eqn;
    }

    public float[] getEyeTextureFov() {
        return this.eyeTextureFov;
    }

    public int[] getEyeTextureResolution() {
        return this.eyeTextureResolution;
    }

    public float getHeightMeters() {
        return this.heightMeters;
    }

    public int getHeightPixels() {
        return this.heightPixels;
    }

    public float getHorizontalOffsetMeters() {
        return this.horizontalOffsetMeters;
    }

    public float[] getInvK() {
        return this.InvK;
    }

    public float[] getK() {
        return this.K;
    }

    public float getLensSeparation() {
        return this.lensSeparation;
    }

    public int getMaxCoefficients() {
        return this.MaxCoefficients;
    }

    public float getMaxInvR() {
        return this.MaxInvR;
    }

    public float getMaxR() {
        return this.MaxR;
    }

    public float getMetersPerTanAngleAtCenter() {
        return this.MetersPerTanAngleAtCenter;
    }

    public int getPicoManagerStutas() {
        return this.PicoManagerStutas;
    }

    public int getScreenHeight() {
        return this.ScreenHeight;
    }

    public String getScreenName() {
        return this.ScreenName;
    }

    public int getScreenRefreshDirectoin() {
        return this.ScreenRefreshDirectoin;
    }

    public int getScreenSetupDirection() {
        return this.ScreenSetupDirection;
    }

    public int getScreenWidth() {
        return this.ScreenWidth;
    }

    public double getScreenXppi() {
        return this.ScreenXppi;
    }

    public double getScreenYppi() {
        return this.ScreenYppi;
    }

    public float getWidthMeters() {
        return this.widthMeters;
    }

    public int getWidthPixels() {
        return this.widthPixels;
    }

    public void setChromaticAberration(float[] fArr) {
        this.ChromaticAberration = fArr;
    }

    public void setDisplayRefreshRate(float f) {
        this.displayRefreshRate = f;
    }

    public void setEqn(int i) {
        this.Eqn = i;
    }

    public void setEyeTextureFov(float[] fArr) {
        this.eyeTextureFov = fArr;
    }

    public void setEyeTextureResolution(int[] iArr) {
        this.eyeTextureResolution = iArr;
    }

    public void setHeightMeters(float f) {
        this.heightMeters = f;
    }

    public void setHeightPixels(int i) {
        this.heightPixels = i;
    }

    public void setHorizontalOffsetMeters(float f) {
        this.horizontalOffsetMeters = f;
    }

    public void setInvK(float[] fArr) {
        this.InvK = fArr;
    }

    public void setK(float[] fArr) {
        this.K = fArr;
    }

    public void setLensSeparation(float f) {
        this.lensSeparation = f;
    }

    public void setMaxCoefficients(int i) {
        this.MaxCoefficients = i;
    }

    public void setMaxInvR(float f) {
        this.MaxInvR = f;
    }

    public void setMaxR(float f) {
        this.MaxR = f;
    }

    public void setMetersPerTanAngleAtCenter(float f) {
        this.MetersPerTanAngleAtCenter = f;
    }

    public void setPicoManagerStutas(int i) {
        this.PicoManagerStutas = i;
    }

    public void setScreenHeight(int i) {
        this.ScreenHeight = i;
    }

    public void setScreenName(String str) {
        this.ScreenName = str;
    }

    public void setScreenRefreshDirectoin(int i) {
        this.ScreenRefreshDirectoin = i;
    }

    public void setScreenSetupDirection(int i) {
        this.ScreenSetupDirection = i;
    }

    public void setScreenWidth(int i) {
        this.ScreenWidth = i;
    }

    public void setScreenXppi(double d2) {
        this.ScreenXppi = d2;
    }

    public void setScreenYppi(double d2) {
        this.ScreenYppi = d2;
    }

    public void setWidthMeters(float f) {
        this.widthMeters = f;
    }

    public void setWidthPixels(int i) {
        this.widthPixels = i;
    }
}

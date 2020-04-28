package com.aerospace.university.matlab_executor.model;

public class Fdtd2Darguments {

    private String lambda;
    private String Q;           // число узлов сеточной области на длину волны (по пространству)
    private String Qt;            // число узлов сеточной области на длину волны (по времени)
    private String QT;             // "длительность" запускаемого цуга в длинах волн
    private String LzConst;             // "длительность" запускаемого цуга в длинах волн
    private String LyConst;             // "длительность" запускаемого цуга в длинах волн
    private String Eps;             // распространение в кварце

    public String getLambda() {
        return lambda;
    }

    public void setLambda(String lambda) {
        this.lambda = lambda;
    }

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getQt() {
        return Qt;
    }

    public void setQt(String qt) {
        Qt = qt;
    }

    public String getQT() {
        return QT;
    }

    public void setQT(String QT) {
        this.QT = QT;
    }

    public String getLyConst() {
        return LyConst;
    }

    public void setLyConst(String lyConst) {
        LyConst = lyConst;
    }

    public String getLzConst() {
        return LzConst;
    }

    public void setLzConst(String lzConst) {
        LzConst = lzConst;
    }

    public String getEps() {
        return Eps;
    }

    public void setEps(String eps) {
        Eps = eps;
    }
}

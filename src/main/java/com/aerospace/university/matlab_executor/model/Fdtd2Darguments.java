package com.aerospace.university.matlab_executor.model;

public class Fdtd2Darguments {

    private String lambda;
    private String q;           // число узлов сеточной области на длину волны (по пространству)
    private String qt;            // число узлов сеточной области на длину волны (по времени)
    private String qT;             // "длительность" запускаемого цуга в длинах волн
    private String lzConst;             // "длительность" запускаемого цуга в длинах волн
    private String lyConst;             // "длительность" запускаемого цуга в длинах волн
    private String eps;             // распространение в кварце

    public Fdtd2Darguments() {
    }

    public Fdtd2Darguments(String lambda, String q, String qt, String qT, String lzConst, String lyConst, String eps) {
        this.lambda = lambda;
        this.q = q;
        this.qt = qt;
        this.qT = qT;
        this.lzConst = lzConst;
        this.lyConst = lyConst;
        this.eps = eps;
    }

    public String getLambda() {
        return lambda;
    }

    public void setLambda(String lambda) {
        this.lambda = lambda;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getqT() {
        return qT;
    }

    public void setqT(String qT) {
        this.qT = qT;
    }

    public String getLyConst() {
        return lyConst;
    }

    public void setLyConst(String lyConst) {
        this.lyConst = lyConst;
    }

    public String getLzConst() {
        return lzConst;
    }

    public void setLzConst(String lzConst) {
        this.lzConst = lzConst;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}

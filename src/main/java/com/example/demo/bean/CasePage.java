package com.example.demo.bean;

import java.io.Serializable;

public class CasePage implements Serializable {

    protected int pageon;
    protected int rowcount;//每行的数量
    protected int pagecount; //总共的页数
    protected int row;
    protected int start;
    protected int end;
    protected int pageNumber;
    protected int var;

    public CasePage(int pageon, int row, int rowcount) {
        pageNumber = 11;
        this.pageon = pageon;
        this.row = row;
        this.rowcount = rowcount;
        compute();
    }

    public CasePage() {
        pageNumber = 11;
    }

    public void compute() {
        if (rowcount <= 0)
            return;
        if (row <= 0)
            row = 10;
        pagecount = rowcount % row != 0 ? rowcount / row + 1 : rowcount / row;
        if (pageon > pagecount)
            pageon = pagecount;
        if (pageon < 1)
            pageon = 1;
        start = (pageon - 1) * row;
        end = pageon * row;
        if (end > rowcount)
            end = rowcount;
    }

    public CasePage(int pageon, int row) {
        pageNumber = 11;
        this.pageon = pageon;
        this.row = row;
    }
    public CasePage(int pageon) {
        pageNumber = 11;
        this.pageon = pageon;
    }

    public int getPageon() {
        return pageon;
    }

    public void setPageon(int pageon) {
        this.pageon = pageon;
    }

    public int getRowcount() {
        return rowcount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
}

package com.example.btl_thibanglaixe.Model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by hoang on 1/26/2018.
 */

public class DeThi implements Serializable{
    List<CauHoi> listCauHoi;

    public DeThi(List<CauHoi> listCauHoi) {
        this.listCauHoi = listCauHoi;
    }

    public List<CauHoi> getListCauHoi() {
        return listCauHoi;
    }

    public void setListCauHoi(List<CauHoi> listCauHoi) {
        this.listCauHoi = listCauHoi;
    }
}

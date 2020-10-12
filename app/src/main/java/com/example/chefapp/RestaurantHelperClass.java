package com.example.chefapp;

public class RestaurantHelperClass {
    String rname, raddress, rtype, rphone, remail, rtime, rspeciality, rfood, rprice;
    String fname;
    String ftype;
    String fcategory;
    String fprice;
    String fportion_size;

    String startTime, endTime;

    String checkbox1, CB2, CB3, CB4, CB5, CB6, CB7, CB8, CB9, CB10, CB11, CB12, CB13, CB14, CB15, CB16, CB17, CB18,  CB19;

    public RestaurantHelperClass() {}

    public RestaurantHelperClass(String rname, String raddress, String rtype, String rphone, String remail, String rtime) {
        this.rname = rname;
        this.raddress = raddress;
        this.rtype = rtype;
        this.rphone = rphone;
        this.remail = remail;
        this.rtime = rtime;
//        this.rspeciality = rspeciality;
//        this.rfood = rfood;
//        this.rprice = rprice;
    }

    public RestaurantHelperClass(String fname, String ftype, String fcategory, String fprice, String fportion_size) {
        this.fname = fname;
        this.ftype = ftype;
        this.fcategory = fcategory;
        this.fprice = fprice;
        this.fportion_size = fportion_size;
    }

    //Constructer for Operating Time
    public RestaurantHelperClass(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    //Constructer for OtherFacilityAvailable
    public RestaurantHelperClass(String checkbox1, String CB2, String CB3, String CB4, String CB5, String CB6, String CB7, String CB8, String CB9, String CB10, String CB11, String CB12, String CB13, String CB14, String CB15, String CB16, String CB17, String CB18, String CB19) {
        this.checkbox1 = checkbox1;
        this.CB2 = CB2;
        this.CB3 = CB3;
        this.CB4 = CB4;
        this.CB5 = CB5;
        this.CB6 = CB6;
        this.CB7 = CB7;
        this.CB8 = CB8;
        this.CB9 = CB9;
        this.CB10 = CB10;
        this.CB11 = CB11;
        this.CB12 = CB12;
        this.CB13 = CB13;
        this.CB14 = CB14;
        this.CB15 = CB15;
        this.CB16 = CB16;
        this.CB17 = CB17;
        this.CB18 = CB18;
        this.CB19 = CB19;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getRspeciality() {
        return rspeciality;
    }

    public void setRspeciality(String rspeciality) {
        this.rspeciality = rspeciality;
    }

    public String getRfood() {
        return rfood;
    }

    public void setRfood(String rfood) {
        this.rfood = rfood;
    }

    public String getRprice() {
        return rprice;
    }

    public void setRprice(String rprice) {
        this.rprice = rprice;
    }

    //Food Getter-Setter
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getFportion_size() {
        return fportion_size;
    }

    public void setFportion_size(String fportion_size) {
        this.fportion_size = fportion_size;
    }


    //GETTER SETTER for time.
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCheckbox1() {
        return checkbox1;
    }


    //GETTER SETTER for Other Facility Available.
    public void setCheckbox1(String checkbox1) {
        this.checkbox1 = checkbox1;
    }

    public String getCB2() {
        return CB2;
    }

    public void setCB2(String CB2) {
        this.CB2 = CB2;
    }

    public String getCB3() {
        return CB3;
    }

    public void setCB3(String CB3) {
        this.CB3 = CB3;
    }

    public String getCB4() {
        return CB4;
    }

    public void setCB4(String CB4) {
        this.CB4 = CB4;
    }

    public String getCB5() {
        return CB5;
    }

    public void setCB5(String CB5) {
        this.CB5 = CB5;
    }

    public String getCB6() {
        return CB6;
    }

    public void setCB6(String CB6) {
        this.CB6 = CB6;
    }

    public String getCB7() {
        return CB7;
    }

    public void setCB7(String CB7) {
        this.CB7 = CB7;
    }

    public String getCB8() {
        return CB8;
    }

    public void setCB8(String CB8) {
        this.CB8 = CB8;
    }

    public String getCB9() {
        return CB9;
    }

    public void setCB9(String CB9) {
        this.CB9 = CB9;
    }

    public String getCB10() {
        return CB10;
    }

    public void setCB10(String CB10) {
        this.CB10 = CB10;
    }

    public String getCB11() {
        return CB11;
    }

    public void setCB11(String CB11) {
        this.CB11 = CB11;
    }

    public String getCB12() {
        return CB12;
    }

    public void setCB12(String CB12) {
        this.CB12 = CB12;
    }

    public String getCB13() {
        return CB13;
    }

    public void setCB13(String CB13) {
        this.CB13 = CB13;
    }

    public String getCB14() {
        return CB14;
    }

    public void setCB14(String CB14) {
        this.CB14 = CB14;
    }

    public String getCB15() {
        return CB15;
    }

    public void setCB15(String CB15) {
        this.CB15 = CB15;
    }

    public String getCB16() {
        return CB16;
    }

    public void setCB16(String CB16) {
        this.CB16 = CB16;
    }

    public String getCB17() {
        return CB17;
    }

    public void setCB17(String CB17) {
        this.CB17 = CB17;
    }

    public String getCB18() {
        return CB18;
    }

    public void setCB18(String CB18) {
        this.CB18 = CB18;
    }

    public String getCB19() {
        return CB19;
    }

    public void setCB19(String CB19) {
        this.CB19 = CB19;
    }
}

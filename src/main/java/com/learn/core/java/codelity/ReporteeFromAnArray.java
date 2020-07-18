package com.learn.core.java.codelity;

import java.util.HashMap;
import java.util.Map;

public class ReporteeFromAnArray {

    public static void main(String[] args) {


        int a[] = {4, 4, 3, 3, 1, 0};
        System.out.println(new ReporteeFromAnArray().solution(a));

    }


    private  int solution(int[] ranks){
        if(ranks == null || ranks.length<2 || ranks.length> 1000000000) {
            return 0;
        }
        Map<Integer,ReportTo> rankReport = new HashMap<>();
        for(int i =0; i< ranks.length; i++) {

            int no = ranks[i];
            int reportToNo = no+1;

            System.out.println(" no, re" + no  + " " + reportToNo);
            ReportTo reportTo =  rankReport.get(reportToNo);
            if(reportTo == null) {
                reportTo = new ReportTo();
                reportTo.addReportee();
                rankReport.put(reportToNo,reportTo);
            } else {
                reportTo.addReportee();
            }
            ReportTo currentNoAsReportTo = rankReport.get(no);
            if(currentNoAsReportTo != null) {
                currentNoAsReportTo.setReportToExist();
            } else  {
                currentNoAsReportTo = new ReportTo();
                currentNoAsReportTo.setReportToExist();
                rankReport.put(no,currentNoAsReportTo);
            }
        }

        int totalReportee = 0;
        for(Integer key : rankReport.keySet()) {
            ReportTo reportTo = rankReport.get(key);
            if(reportTo.isReportToExist()) {
                totalReportee +=reportTo.getReporteeCounter();
            }
        }
        return totalReportee;
    }

    class ReportTo{

        int reporteeCounter = 0;
        boolean reportToExist = false;

        public void addReportee() {
            reporteeCounter = reporteeCounter+1 ;
        }

        public void setReportToExist(){
            reportToExist = true;
        }

        public int getReporteeCounter() {
            return reporteeCounter;
        }

        public boolean isReportToExist() {
            return reportToExist;
        }
    }

}

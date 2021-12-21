package com.company;

public class HotAndCold {

    public static void main(String[] args)
    {
        HotAndCold hotAndCold = new HotAndCold();
        hotAndCold.testCases();
    }

    public String getHint(String hiddentStr, String guessStr)
    {
        String hotAndColdCount = "0H0C";
        if (guessStr.length() != 4) {
            return hotAndColdCount;
        }
        int hot = 0;
        int cold = 0;

        for (int i = 0; i < hiddentStr.length(); i++) {
            if (hiddentStr.charAt(i) == guessStr.charAt(i)) {
                hot++;
            }
            if (hiddentStr.contains(String.valueOf(guessStr.charAt(i)))) {
                cold++;
            }
        }
        cold-=hot;
        hotAndColdCount = hot + "H" + cold + "C";
        return hotAndColdCount;
    }

    public boolean assertHint(int caseNumber, String results, String expected)
    {
        boolean correct = results.equals(expected);
        System.out.println("Expected value = " + expected + " Actual value = " + results);
        System.out.println("Case " + caseNumber + " = " + (correct ? "passed" : "fail"));
        return results.equals(expected);
    }

    public void testCases()
    {
        String case1 = getHint("1807", "7810");
        assertHint(1, case1, "1H3C");

        String case2 = getHint("1807", "2805");
        assertHint(2, case2, "2H0C");

        String case3 = getHint("1807", "9807");
        assertHint(3, case3, "3H0C");

        String case4 = getHint("1807", "1807");
        assertHint(4, case4, "4H0C");

        //insert additional test cases here

        String case5 = getHint("1807", "9999");
        assertHint(5, case5, "0H0C");

        String case6 = getHint("1807", "8710");
        assertHint(6, case6, "0H4C");

        String case7 = getHint("1807", "7801");
        assertHint(7, case7, "2H2C");

        String case8 = getHint("1807", "153212");
        assertHint(8, case8, "0H0C");

        String case9 = getHint("1807", "9180");
        assertHint(9, case9, "0H3C");
    }

}

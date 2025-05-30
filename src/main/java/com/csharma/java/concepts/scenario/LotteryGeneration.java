package com.csharma.java.concepts.scenario;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryGeneration {



    /*
    Lottery

    Each lottery contains 5 number from [0-9]
    each lottery has buy time : 14:04


    Generate 10000 lottery

     */
    public static void main(String[] args) {
        //String s = randomLotteryNumber();
        //System.out.println(s);


        //String s1 = randomBuyTime();
        //System.out.println(s1);
        List<Lottery> lotteries = generateLottery(1000);
        //System.out.println(lotteries);

        char mostCommonDigitInLotteryNumber = findMostCommonDigitInLotteryNumber(lotteries);
        System.out.println(mostCommonDigitInLotteryNumber);
    }

    static class Lottery{
        String lotteryNumber;
        String buyTime;

        public Lottery (String lotteryNumber, String buyTime){
            this.lotteryNumber = lotteryNumber;
            this.buyTime = buyTime;
        }

        @Override
        public String toString(){
            return "Ticket {number =" + lotteryNumber  + "buy time" + buyTime ;
        }
    }


    public static List<Lottery> generateLottery(int numberOfTickets){
        List<Lottery> lotteryTicket =  new ArrayList<>(numberOfTickets);

        for(int i=0; i< numberOfTickets; i++){
            String lotteryNumber = randomLotteryNumber();
            String buyTime = randomBuyTime();
            lotteryTicket.add(new Lottery(lotteryNumber, buyTime));
        }
        return lotteryTicket;
    }


    private static final int DIGIT_PER_TICKET = 5;

    private static Random random = new Random();

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private static String randomLotteryNumber(){
        char[] digits = new char[DIGIT_PER_TICKET];
        for(int i = 0; i< DIGIT_PER_TICKET; i++){
            digits[i] = (char) ('0' + random.nextInt(10));
        }
        return new String(digits);
    }

    private static String randomBuyTime(){
        int hour = random.nextInt(24);
        int minute =  random.nextInt(60);
        return LocalTime.of(hour, minute).format(TIME_FORMATTER);
    }

    public static char findMostCommonDigitInLotteryNumber(List<Lottery> lotteries){
        int[] digitCount =  new int[10];

        for(Lottery ticket : lotteries){
            for(char digit: ticket.lotteryNumber.toCharArray()){
                if(Character.isDigit(digit)){
                    digitCount[digit -'0']++;
                }
            }
        }

        int maxCount = 0;
        int mostCommonDigit = 0;


        for(int i=0; i< digitCount.length;i++){
            if(digitCount[i] > maxCount){
                maxCount = digitCount[i];
                mostCommonDigit = i;
            }
        }

        System.out.println("Most count number or frequencies");
        for(int i =0; i< digitCount.length;i++){
            System.out.println("Digit " +i+":" +digitCount[i]);
        }
        return (char)('0' + mostCommonDigit);
    }
}

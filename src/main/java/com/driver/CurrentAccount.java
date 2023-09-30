package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;

        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }

    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(checkvalid(tradeLicenseId)==false){
            if(validity(tradeLicenseId)==false){
                throw new Exception("Valid License can not be generated");
            }
            rarrrange(tradeLicenseId);
        }
        else{

            tradeLicenseId=this.tradeLicenseId;

        }






    }

    private boolean validity(String tradeLicenseId) {
        int[] freq=new int[26];
        char maxchar='0';
        int maxrep=0;

        for(int i=0;i<tradeLicenseId.length();i++){
            char ch=tradeLicenseId.charAt(i);

            freq[ch-'A']++;
            if(freq[ch-'A']>maxrep){
                maxrep=freq[ch-'A'];
                maxchar=ch;
            }
        }
        if(tradeLicenseId.length()/2<maxrep){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean checkvalid(String tradeLicenseId) {
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    private char[] rarrrange(String s) {
        int freq[]=new int[26];
        char maxfreqchar='0';
        int maxfreq=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'A']++;

            if(freq[ch-'A']>maxfreq){
                maxfreq=freq[ch-'A'];
                maxfreqchar=ch;
            }
        }

        char result[]=new char[s.length()];
        int index=0;

        while(freq[maxfreqchar-'A']>0){
            result[index]=maxfreqchar;

            index=index+2;

            freq[maxfreqchar]--;
        }

        for(int i=0;i<26;i++){
            int frequency=freq[i];
            while(frequency>0){
                if(index>=s.length()){
                    index=1;
                }
                result[index]=(char)(i+'A');
                index=index+2;
            }
        }
        return result;
    }

}

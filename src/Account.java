public class Account {
    private String ownerName;
    private int accountNumber;
    private double percentRate;
    private double balance;

    public Account(String ownerName, int accountNumber, double percentRate, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.percentRate = percentRate;
        this.balance = balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void takemoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " hrn. was taken from " + accountNumber);
        } else {
            System.out.println("Not enough money in the account " + accountNumber);
        }
    }

    public void putmoney(double amount) {
        balance += amount;
        System.out.println(amount + " hrn. was put to " + accountNumber);
    }

    public double addpercent() {
        double dodamount = balance * percentRate / 100;
        balance += dodamount;
        //System.out.println(dodamount + " was given to " + accountNumber);
        return dodamount;
    }

    public void getBalanceInWords(double amount) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        if (amount == 0) {
            System.out.println("zero");
            return;
        }
        int hrns = (int) amount;
        int kops = (int) Math.round((amount - hrns) * 100);

        String hrnsInWords = "";
        if (hrns >= 1000) {
            hrnsInWords += ones[hrns / 1000] + " thousand ";
            hrns %= 1000;
        }
        if (hrns >= 100) {
            hrnsInWords += ones[hrns / 100] + " hundred ";
            hrns %= 100;
        }
        if (hrns >= 11 && hrns <= 19) {
            hrnsInWords += teens[hrns - 11] + " hrn.";
        } else {
            if (hrns >= 10) {
                hrnsInWords += tens[hrns / 10] + " ";
                hrns %= 10;
            }
            if (hrns >= 1) {
                hrnsInWords += ones[hrns] + " ";
            }
            hrnsInWords += "hrn.";
        }

        String kopsInWords = "";
        if (kops >= 11 && kops <= 19) {
            kopsInWords += teens[kops - 11] + " kop.";
        } else {
            if (kops >= 10) {
                kopsInWords += tens[kops / 10] + " ";
                kops %= 10;
            }
            if (kops >= 1) {
                kopsInWords += ones[kops] + " ";
            }
            kopsInWords += "kop.";
        }

        if (kops == 0) {
            System.out.println(hrnsInWords + " was given to " + accountNumber);
        } else {
            System.out.println(hrnsInWords + " and " + kopsInWords + " was given to " + accountNumber);
        }
    }

    public static void main(String[] args) {
        Account acc = new Account("Ivan Patsuk", 123456, 15.0, 1000.0);
        acc.setOwnerName("Ivan Nepatsuk");
        acc.takemoney(500.0);
        acc.putmoney(2000.0);
        double dodamount = acc.addpercent();
        acc.getBalanceInWords(dodamount);
    }
}

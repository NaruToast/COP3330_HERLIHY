public class ContactItem implements Item{
    private String fName, lName, pNumber, email;
    @Override
    public int isInt(char a){
        if(a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a =='9'){
            return 1;
        }else{
            return 0;
        }
    }
    @Override
    public void printItem() {
        System.out.print("Name: " + fName + " " + lName + "\n" + "Phone: " + pNumber + "\n" + "Email: " + email + "\n");
    }
    public String getEmail() {
        return email;
    }
    public String getFName() {
        return fName;
    }
    public String getLName() {
        return lName;
    }
    public String getPNumber() {
        return pNumber;
    }
    public void setEmail(String myEmail) {
        email = myEmail;
    }
    public void setFName(String myfName) {
        fName = myfName;
    }
    public void setLName(String mylName) {
        lName = mylName;
    }
    public void setPNumber(String mypNumber) {
        pNumber = mypNumber;
    }
    public int pNumberCheck(String mypNumber){
        char buffer;
        if(mypNumber.length() != 12){
            System.out.println("String length invalid");
            return 1;
        }
        for(int i = 0; i < mypNumber.length(); i++){
            if(i <= 2){
                if(isInt(mypNumber.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }if(i == 3){
                buffer = mypNumber.charAt(i);
                if(buffer != '-'){
                    System.out.println("Char at position " + i + " is not a -");
                    return 1;
                }
            }if(3 < i && i <= 6){
                if(isInt(mypNumber.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }if(i == 7){
                buffer = mypNumber.charAt(i);
                if(buffer != '-'){
                    System.out.println("Char at position " + i + " is not a -");
                    return 1;
                }
            }if(7 < i){
                if(isInt(mypNumber.charAt(i)) != 1){
                    System.out.println("Char at position " + i + " is not an int");
                    return 1;
                }
            }
        }
        return 0;
    }
    public int emailCheck(String myEmail){
        // used for each check to make sure email is of format: x@y.z
        int xCheck = 0, yCheck = 0, zCheck = 0, andCheck = 0, periodCheck = 0, i = 0, andPos = -1, periodPos = -1;
        while(i < myEmail.length()){
            if(myEmail.charAt(i) != '@' && myEmail.charAt(i) != '.'){
                xCheck = 1;
                if(andCheck == 1){
                    yCheck = 1;
                    if(periodCheck == 1){
                        zCheck = 1;
                    }
                }
            }
            if(xCheck == 1 && andCheck != 1 && myEmail.charAt(i) == '@'){
                andCheck = 1;
                andPos = i;
            }
            if(yCheck == 1 && periodCheck != 1 && myEmail.charAt(i) == '.'){
                periodCheck = 1;
                periodPos = i;
            }
            if(myEmail.charAt(i) == '@' && andPos != i){
                zCheck = 0;
                break;
            }if(myEmail.charAt(i) == '.' && periodPos != i){
                zCheck = 0;
                break;
            }
            i++;
        }
        if(zCheck == 1){
            return 0;
        }else{
            return 1;
        }
    }
}
